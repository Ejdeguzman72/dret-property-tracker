package com.dret.propertytracker.daoimpl;

import com.dret.propertytracker.dao.PropertyDao;
import com.dret.propertytracker.domain.Property;
import com.dret.propertytracker.mapper.PropertyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PropertyDaoImpl implements PropertyDao {

    private static final String GET_ALL_PROPERTY_SQL = "SELECT PROPERTY_ID,ADDRESS,CITY,STATE,ZIP FROM PROPERTY";
    private static final String GET_PROPERTY_BY_ID_SQL = "SELECT PROPERTY_ID,ADDRESS,CITY,STATE,ZIP FROM PROPERTY WHERE PROPERTY_ID = ?";
    private static final String INSERT_PROPERTY_INFO_SQL = "INSERT INTO PROPERTY (ADDRESS,CITY,STATE,ZIP) VALUES (?,?,?,?)";
    private static final String UPDATE_PROPERTY_INFO_SQL = "UPDATE PROPERTY SET ADDRESS=?,CITY=?,STATE=?,ZIP=?";
    private static final String DELETE_PROPERTY_INFO_SQL = "DELETE FROM PROPERTY WHERE PROPERTY_ID = ?";

    private final PropertyMapper propertyMapper = new PropertyMapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyDaoImpl.class);
    @Override
    public List<Property> getAllPropertyInformation() {
        List<Property> list = new ArrayList<>();
        try {
            list = jdbcTemplate.query(GET_ALL_PROPERTY_SQL, propertyMapper);

            LOGGER.info("Fetching data list...");
        } catch (Exception e) {
            LOGGER.error("Error fetching data: " + e.toString());
        }

        return list;
    }

    @Override
    public Property getPropertyById(long propertyId) {
        Property property = new Property();
        try {
            property = (Property) jdbcTemplate.queryForObject(GET_PROPERTY_BY_ID_SQL, new PropertyMapper(), propertyId);

            LOGGER.info("Fetching property with ID: " + propertyId);
        } catch (EmptyResultDataAccessException e) {
            LOGGER.error("Error fetching data: " + e.toString());
        }

        return property;
    }

    @Override
    public int addPropertyInformation(Property property) {
        int result = 0;
        try {
            result = jdbcTemplate.update(INSERT_PROPERTY_INFO_SQL, new Object[] {
                    property.getAddress(),
                    property.getCity(),
                    property.getState(),
                    property.getZipcode()
            });

            if (result > 0) {

                LOGGER.info("Inserting info: " + property.toString());
            }
        } catch (Exception e) {
            LOGGER.error("Error inserting data: " + e.toString());
        }

        return result;
    }

    @Override
    public int updateProperty(long propertyId, Property propertyDetails) {
        int result = 0;
        try {
            Property property = getPropertyById(propertyId);
            if (property != null) {
                property.setAddress(propertyDetails.getAddress());
                property.setCity(propertyDetails.getCity());
                property.setState(propertyDetails.getState());
                property.setZipcode(propertyDetails.getZipcode());

                result = jdbcTemplate.update(UPDATE_PROPERTY_INFO_SQL,new Object[] {
                        property.getPropertyId(),
                        property.getAddress(),
                        property.getCity(),
                        property.getState(),
                        property.getZipcode()
                });

                LOGGER.info("Updating property with ID: " + propertyId);
            }
        } catch (EmptyResultDataAccessException e) {
            LOGGER.error("Error updating data: " + e.toString());
        } catch (Exception e) {
            LOGGER.error("Error fetching data: " + e.toString());
        }

        return result;
    }

    @Override
    public int deletePropertyInformation(long propertyId) {
        int result = 0;
        try {
            result = jdbcTemplate.update(DELETE_PROPERTY_INFO_SQL, propertyId);

            LOGGER.info("Deleting property with ID: " + propertyId);
        } catch (EmptyResultDataAccessException e) {
            LOGGER.error("Error deleting data:" + e.toString());
        }

        return result;
    }
}

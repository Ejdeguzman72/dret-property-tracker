package com.dret.propertytracker.service;

import com.dret.propertytracker.daoimpl.PropertyDaoImpl;
import com.dret.propertytracker.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyDaoImpl propertyDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyService.class);

    public PropertyListResponse getAllPropertyInformation() {
        PropertyListResponse response = new PropertyListResponse();
        List<Property> list = new ArrayList<>();
        list = propertyDao.getAllPropertyInformation();
        response.setList(list);
        return response;
    }

    public PropertyAddUpdateResponse addPropertyInfo(PropertyAddUpdateRequest request) {
        PropertyAddUpdateResponse response = new PropertyAddUpdateResponse();
        Property property = new Property();
        int result = 0;
        try {
            result = propertyDao.addPropertyInformation(request);
            if (result > 0) {
                property.setAddress(request.getAddress());
                property.setCity(request.getCity());
                property.setState(request.getState());
                property.setZipcode(request.getZipcode());

                response.setProperty(property);
            }
        } catch (Exception e) {
            LOGGER.error("Error inserting data: " + e.toString());
        }

        return response;
    }

    public PropertySearchResponse searchPropertyById(long propertyId) {
        PropertySearchResponse response = new PropertySearchResponse();
        Property property = new Property();
        try {
            property = propertyDao.getPropertyById(propertyId);
            response.setProperty(property);
        } catch (Exception e) {
            LOGGER.error("Error fetching data: " + e.toString());
        }

        return response;
    }

    public PropertyAddUpdateResponse updatePropertyInformation(long propertyId, PropertyAddUpdateRequest request) {
        PropertyAddUpdateResponse response = new PropertyAddUpdateResponse();
        int result = 0;
        Property property = new Property();
        try {
            property = propertyDao.getPropertyById(propertyId);
            if (property != null) {
                result = propertyDao.updateProperty(propertyId,request);

                property.setAddress(request.getAddress());
                property.setCity(request.getCity());
                property.setState(request.getState());
                property.setZipcode(request.getZipcode());

                response.setProperty(property);
            }
        } catch (Exception e) {
            LOGGER.error("Error updating data: " + e.toString());
        }
        return response;
    }

    public PropertySearchResponse deletePropertyInformation(long propertyId) {
        PropertySearchResponse response = new PropertySearchResponse();
        Property property = propertyDao.getPropertyById(propertyId);
        int result = 0;

        result = propertyDao.deletePropertyInformation(propertyId);
        if (result > 0) {
            response.setProperty(property);
        }

        return response;
    }

}

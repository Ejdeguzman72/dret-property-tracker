package com.dret.propertytracker.mapper;

import com.dret.propertytracker.domain.AppConstants;
import com.dret.propertytracker.domain.Property;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PropertyMapper implements RowMapper {
    @Override
    public Property mapRow(ResultSet rs, int rowNum) throws SQLException {
        Property property = new Property();
        property.setPropertyId(rs.getLong(AppConstants.COL_PROPERTY_ID));
        property.setAddress(rs.getString(AppConstants.COL_ADDRESS));
        property.setCity(rs.getString(AppConstants.COL_CITY));
        property.setState(rs.getString(AppConstants.COL_STATE));
        property.setZipcode(rs.getString(AppConstants.COL_ZIP));

        return property;
    }
}

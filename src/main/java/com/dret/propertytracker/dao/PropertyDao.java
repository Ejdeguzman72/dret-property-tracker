package com.dret.propertytracker.dao;

import com.dret.propertytracker.domain.Property;

import java.util.List;

public interface PropertyDao {

    List<Property> getAllPropertyInformation();
    Property getPropertyById(long propertyId);

    int addPropertyInformation(Property property);
    int updateProperty(long propertyId, Property propertyDetails);
    int deletePropertyInformation(long propertyId);
}

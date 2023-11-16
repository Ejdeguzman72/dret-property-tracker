package com.dret.propertytracker.controller;

import com.dret.propertytracker.domain.*;
import com.dret.propertytracker.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping(value = UriConstants.GET_ALL_PROPERTY_INFO_URI)
    public PropertyListResponse getAllPropertyInformation() {
        return propertyService.getAllPropertyInformation();
    }

    @GetMapping(value = UriConstants.GET_PROPERTY_BY_ID)
    public PropertySearchResponse getPropertyById(@PathVariable long propertyId) {
        PropertySearchResponse response = propertyService.searchPropertyById(propertyId);
        return response;
    }

    @PostMapping(value = UriConstants.ADD_PROPERTY_INFO_URI)
    public PropertyAddUpdateResponse addPropertyInformation(@RequestBody PropertyAddUpdateRequest request) {
        PropertyAddUpdateResponse response = propertyService.addPropertyInfo(request);
        return response;
    }

    @PutMapping(value = UriConstants.UPDATE_PROPERTY_URI)
    public PropertyAddUpdateResponse updatePropertyInformation(@RequestBody PropertyAddUpdateRequest request) {
        PropertyAddUpdateResponse response = propertyService.updatePropertyInformation(request.getPropertyId(),request);
        return response;
    }

    @DeleteMapping(value = UriConstants.DELETE_PROPERTY_URI)
    public PropertySearchResponse deletePropertyInformation(@PathVariable long propertyId) {
        PropertySearchResponse response = propertyService.deletePropertyInformation(propertyId);
        return response;
    }
}

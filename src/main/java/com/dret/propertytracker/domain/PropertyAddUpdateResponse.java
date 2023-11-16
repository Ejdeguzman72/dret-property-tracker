package com.dret.propertytracker.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.web.bind.annotation.CrossOrigin;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@CrossOrigin
public class PropertyAddUpdateResponse {
    Property property;

    public Property getProperty() {
        return property;
    }

    public PropertyAddUpdateResponse() {
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}

package com.dret.propertytracker.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@CrossOrigin
public class PropertyListResponse {

    List<Property> list;

    public List<Property> getList() {
        return list;
    }

    public void setList(List<Property> list) {
        this.list = list;
    }

    public PropertyListResponse() {
    }
}

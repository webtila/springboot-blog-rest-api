package com.springboot.blog.springbootblogrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value= HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Long fieldValue;

    public ResourceNotFound(String resourceName, String fieldName, Long fieldValue) {
       super(String.format("%s is not found for %s : '%s'",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Long getFieldValue() {
        return fieldValue;
    }
}

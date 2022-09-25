package com.example.customValidation.dto;

import javax.validation.Valid;
import java.util.Map;

public class RequestBodyMap <E,R>{


    @Valid
    private Map<E,R> mapData;

    public RequestBodyMap() {
    }

    public Map<E, R> getMapData() {
        return mapData;
    }

    public void setMapData(Map<E, R> mapData) {
        this.mapData = mapData;
    }
}

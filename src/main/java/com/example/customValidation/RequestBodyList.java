package com.example.customValidation;


import javax.validation.Valid;
import java.util.List;
import java.util.Map;

public class RequestBodyList<T> {


     private List<@Valid T> data;



    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public RequestBodyList() {
    }

}

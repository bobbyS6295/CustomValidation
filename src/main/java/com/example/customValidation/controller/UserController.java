package com.example.customValidation.controller;


import com.example.customValidation.RequestBodyList;
import com.example.customValidation.dto.RequestBodyMap;
import com.example.customValidation.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {


    @PostMapping("/checkCase")
    public String validateCheckCase(@Valid  @RequestBody RequestBodyList<User> user){
        return "success";
    }



    @PostMapping("/map")
    public String validateChseckCase(@Valid  @RequestBody RequestBodyMap<String,User> user){
        return "success";
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> exceptionHandler(MethodArgumentNotValidException e, BindingResult bindingResult){

        return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
    }


}

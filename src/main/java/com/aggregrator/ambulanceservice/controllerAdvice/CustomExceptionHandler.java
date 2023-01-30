package com.aggregrator.ambulanceservice.controllerAdvice;


import com.aggregrator.ambulanceservice.exception.AmbulanceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.HashMap;

//@ControllerAdvice
public class CustomExceptionHandler {

//    @ExceptionHandler(AmbulanceNotFoundException.class)
//    public ResponseEntity<HashMap<String,Object>>handleAmbulanceNotFoundException(AmbulanceNotFoundException ex){
//        HashMap<String,Object> errorResponseMap = new HashMap<>();
//        errorResponseMap.put("status","error");
//        errorResponseMap.put("message",ex.getMessage());
//        errorResponseMap.put("timestamp", new Date());
//        return ResponseEntity.status(ex.getCode()).body(errorResponseMap);
//
//    }
}

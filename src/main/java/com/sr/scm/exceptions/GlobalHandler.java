package com.sr.scm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(value=NullPointerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> handleNullPointerException(NullPointerException e)
    {
            Map<String,String> map=new HashMap<>();
            map.put("Error Message","Null pointer occured");
            map.put("Details",e.getMessage());
            return map;
    }

    @ExceptionHandler(value=Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,String> handleException(Exception e)
    {
        Map<String,String> map=new HashMap<>();
        map.put("Error Message","Exception occured");
        map.put("Details",e.getMessage());
        return map;
    }
}

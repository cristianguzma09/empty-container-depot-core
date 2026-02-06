package com.ecd.core.adapter.in.web;


import com.ecd.core.domain.exception.ConflictException;
import com.ecd.core.domain.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> notFound(NotFoundException ex){

        return base(404, "Not Found", ex.getMessage());
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, Object> conflict(ConflictException ex){
        return base(409, "Conflict", ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> validation(MethodArgumentNotValidException ex){
        Map<String, Object> body = base(400, "Bad Request", "Validación Fallida!");
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(
                err -> errors.put(err.getField(), err.getDefaultMessage()));
        body.put("fieldErrors", errors);
        return body;
    }

    private Map<String, Object> base(int status, String error, String message){
           Map<String, Object> body = new HashMap<>();
           body.put("timestamp", Instant.now().toString());
           body.put("status", status);
           body.put("error", error);
           body.put("message", message);
        return body;
    }


}

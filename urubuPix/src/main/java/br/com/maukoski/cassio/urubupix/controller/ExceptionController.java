package br.com.maukoski.cassio.urubupix.controller;

import br.com.maukoski.cassio.urubupix.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public String handleNotFound(NoHandlerFoundException e) {
        return new Error(e.getRequestURL(),e.getHttpMethod(), 404).toString();
    }
}

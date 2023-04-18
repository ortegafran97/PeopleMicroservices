package com.donks.PeopleMgr.Exceptions;

import com.donks.PeopleMgr.Exceptions.Classes.AlreadyExistsException;
import com.donks.PeopleMgr.Exceptions.Classes.CouldntCompleteException;
import com.donks.PeopleMgr.Exceptions.Classes.NotFoundException;
import com.donks.PeopleMgr.Exceptions.Classes.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> defaultErrorHandler(HttpServletRequest req, Exception e)
    {
        return new ResponseEntity<ErrorMessage>(new ErrorMessage("Error generico", e.getMessage(), "1", req.getRequestURI()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> notFoundHandler(HttpServletRequest req, Exception e){
        return new ResponseEntity<ErrorMessage>(new ErrorMessage("No encontrado",e.getMessage(),null,req.getRequestURI()),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> alreadyExistsHandler(HttpServletRequest req, Exception e){
        return new ResponseEntity<ErrorMessage>(new ErrorMessage("Registro ya existente",e.getMessage(),null,req.getRequestURI()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> notValidValueHandler(HttpServletRequest req, Exception e){
        return new ResponseEntity<ErrorMessage>(new ErrorMessage("Valor no admitido",e.getMessage(),null,req.getRequestURI()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CouldntCompleteException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> couldntCompleteHandler(HttpServletRequest req, Exception e){
        return new ResponseEntity<ErrorMessage>(new ErrorMessage("No se pudo completar la operacion",e.getMessage(),null,req.getRequestURI()),HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

package com.generation.javeat.controllers.util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class UniversalExceptionHandler 
{
     @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> gestisciEccezioneConversioneJson(HttpMessageNotReadableException e){//catch(HttpMessageNotReadableException e)
        return new ResponseEntity<String>("Errore di conversione da Json a Oggetto", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> gestisciEccezionPathVariable(MethodArgumentTypeMismatchException e){
        return new ResponseEntity<String>("Errore nella path variable", HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(EntityException.class)
    public ResponseEntity<?> gestisciEccezioneEntita(EntityException e){//catch(HttpMessageNotReadableException e)
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
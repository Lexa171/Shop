package by.onlineStore.controller;

import by.onlineStore.exception.ConflictException;
import by.onlineStore.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandlingController {

    private Logger logger;

    public GlobalExceptionHandlingController() {
        logger = LoggerFactory.getLogger(getClass());
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseBody
    public ResponseEntity processConflictException(ConcurrencyFailureException ex) {
        logger.error("Exception: ", ex);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ResponseEntity processNotFoundException(ConcurrencyFailureException ex) {
        logger.error("Exception: ", ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    public ResponseEntity processDataIntegrityViolationException(ConcurrencyFailureException ex) {
        logger.error("Exception: ", ex);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
    /*@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Conflict of values")
    @ExceptionHandler(ConflictException.class)
    public void conflict() {
        logger.error("Request raised a ConflictException");
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not found")
    @ExceptionHandler(NotFoundException.class)
    public void notFound() {
        logger.error("Request raised a NotFoundException");
    }

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Data integrity violation")
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void integrityViolation() {
        logger.error("Request raised a DataIntegrityViolationException");
    }*/

}

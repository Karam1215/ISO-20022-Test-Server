package com.karam.iso20022testserver.code.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(XmlValidationException.class)
    public ResponseEntity<ErrorResponse> handleXmlValidationException(XmlValidationException ex) {
        ErrorResponse errorResponse = new ErrorResponse("XML_VALIDATION_ERROR", ex.getMessage(), "Invalid XML structure");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidIbanException.class)
    public ResponseEntity<ErrorResponse> handleInvalidIbanException(InvalidIbanException ex) {
        ErrorResponse errorResponse = new ErrorResponse("INVALID_IBAN", ex.getMessage(), "The IBAN is not valid according to business rules.");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse("INTERNAL_ERROR", "Something went wrong", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

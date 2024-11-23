package com.karam.iso20022testserver.code.exeptions;

public class InvalidIbanException extends RuntimeException {
    public InvalidIbanException(String message) {
        super(message);
    }
}

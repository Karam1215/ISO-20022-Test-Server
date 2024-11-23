package com.karam.iso20022testserver.code.exeptions;

public class ErrorResponse {
    private String errorCode;
    private String errorMessage;
    private String details;

    public ErrorResponse(String errorCode, String errorMessage, String details) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.details = details;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

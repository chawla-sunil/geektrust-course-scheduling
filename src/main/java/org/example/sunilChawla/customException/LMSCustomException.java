package org.example.sunilChawla.customException;

public class LMSCustomException extends Exception{

    private String errorCode;
    private String messageText;

    public LMSCustomException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.messageText = errorMessage;
    }
}
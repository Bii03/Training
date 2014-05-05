package com.endava.exceptionchaining;

public class BusinessException extends Exception{
    BusinessException (Exception ex) {
        super(ex);
    }

}

package com.melnek_odonto.AppointmentScheduling.exceptions;

public class LocalDateTimeAlreadyInUseException extends RuntimeException{
    public LocalDateTimeAlreadyInUseException(String message){
        super(message);
    }
}

package com.melnek_odonto.AppointmentScheduling.exceptions;

public class NotFoundIdException extends RuntimeException{
    public NotFoundIdException(String message){
        super(message);
    }
}

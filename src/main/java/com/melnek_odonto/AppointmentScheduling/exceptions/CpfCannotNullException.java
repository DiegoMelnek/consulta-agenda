package com.melnek_odonto.AppointmentScheduling.exceptions;

public class CpfCannotNullException extends RuntimeException{
    public CpfCannotNullException(String message){
        super(message);
    }
}

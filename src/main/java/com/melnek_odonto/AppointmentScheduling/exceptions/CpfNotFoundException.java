package com.melnek_odonto.AppointmentScheduling.exceptions;

public class CpfNotFoundException extends RuntimeException{
    public CpfNotFoundException(String message){
        super(message);
    }
}

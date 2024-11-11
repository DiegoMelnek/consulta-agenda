package com.melnek_odonto.AppointmentScheduling.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Trata a exceção quando o CPF é nulo
    @ExceptionHandler(CpfCannotNullException.class)
    public ResponseEntity<String> handleCpfCannotNullException(CpfCannotNullException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Trata a exceção quando o CPF não é encontrado
    @ExceptionHandler(CpfNotFoundException.class)
    public ResponseEntity<String> handleCpfNotFoundException(CpfNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Trata a exceção quando o ID é nulo
    @ExceptionHandler(IdCannotNullException.class)
    public ResponseEntity<String> handleIdCannotNullException(IdCannotNullException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Trata a exceção quando a data e hora já estão em uso
    @ExceptionHandler(LocalDateTimeAlreadyInUseException.class)
    public ResponseEntity<String> handleLocalDateTimeAlreadyInUseException(LocalDateTimeAlreadyInUseException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Trata a exceção quando o ID não é encontrado
    @ExceptionHandler(NotFoundIdException.class)
    public ResponseEntity<String> handleNotFoundIdException(NotFoundIdException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Exceção genérica para capturar erros não tratados
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return new ResponseEntity<>("Ocorreu um erro interno no servidor", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

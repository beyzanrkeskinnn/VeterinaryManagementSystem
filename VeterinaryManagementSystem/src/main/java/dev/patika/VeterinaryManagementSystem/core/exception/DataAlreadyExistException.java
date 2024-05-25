package dev.patika.VeterinaryManagementSystem.core.exception;

public class DataAlreadyExistException extends RuntimeException{
    public DataAlreadyExistException(String message){
        super(message);
    }
}

package com.codedifferently.apiexamplejava.generics;
public class UpdateException extends Exception{
    private static final String errorMessage = "Error updating type";
    public UpdateException(String message, String type){
        super(String.format("%s - %s : %s", errorMessage, type, message));
    }
}

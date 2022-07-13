package com.codedifferently.apiexamplejava.generics;
public class CreateException extends Exception{
    private static final String errorMessage = "Error creating type";
    public CreateException(String message, String type){
        super(String.format("%s - %s : %s", errorMessage, type, message));
    }
}

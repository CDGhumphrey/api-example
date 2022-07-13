package com.codedifferently.apiexamplejava.generics;
public class GetException extends Exception{
    private static final String errorMessage = "Error retrieving type";
    public GetException(String message, String type){
        super(String.format("%s - %s : %s", errorMessage, type, message));
    }
}

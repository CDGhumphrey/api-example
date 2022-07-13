package com.codedifferently.apiexamplejava.generics;
public class DeleteException extends Exception{
    private static final String errorMessage = "Error deleting type";
    public DeleteException(String message, String type){
        super(String.format("%s - %s : %s", errorMessage, type, message));
    }
}

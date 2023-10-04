package com.excepetion;

public class SongNotFoundException extends Exception{
    public SongNotFoundException(String message){
        super(message);
    }
}

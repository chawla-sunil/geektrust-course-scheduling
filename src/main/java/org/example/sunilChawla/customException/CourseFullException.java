package org.example.sunilChawla.customException;

public class CourseFullException extends Exception{
    public CourseFullException(String message){
        super(message);
    }
}
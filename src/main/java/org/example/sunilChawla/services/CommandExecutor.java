package org.example.sunilChawla.services;

import org.example.sunilChawla.customException.CourseFullException;
import org.example.sunilChawla.customException.InvalidInputException;
import org.example.sunilChawla.model.InputAction;
import org.example.sunilChawla.model.Course;

import java.util.Map;

public interface CommandExecutor {
    void executeCommand(Map<String, Course> courses, Map<String, Course> registrationIdCourseMap, InputAction inputAction) throws InvalidInputException, CourseFullException;
}

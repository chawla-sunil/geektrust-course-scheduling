package org.example.sunilChawla.services;

import org.example.sunilChawla.customException.CourseFullException;
import org.example.sunilChawla.customException.InvalidInputException;
import org.example.sunilChawla.model.InputAction;
import org.example.sunilChawla.model.Course;
import org.example.sunilChawla.services.serviceImpls.AddCourseOfferingCommandExecutorImpl;
import org.example.sunilChawla.services.serviceImpls.AllotCourseCommandExecutorImpl;
import org.example.sunilChawla.services.serviceImpls.CancelCourseCommandExecutorImpl;
import org.example.sunilChawla.services.serviceImpls.RegisterCourseCommandExecutorImpl;

import java.util.HashMap;
import java.util.Map;

public class LMS {
    private Map<String , Course> courses;
    private Map<String,Course> registrationIdCourseMap;

    public LMS() {
        courses = new HashMap<>();
        registrationIdCourseMap = new HashMap<>();
    }

    public void performAction(InputAction inputInputAction) throws InvalidInputException {
        CommandExecutor commandExecutor = null;
        try {
            switch (inputInputAction.getInputAction()) {
                case ADD_COURSE_OFFERING -> commandExecutor = new AddCourseOfferingCommandExecutorImpl();
                case REGISTER -> commandExecutor = new RegisterCourseCommandExecutorImpl();
                case CANCEL -> commandExecutor = new CancelCourseCommandExecutorImpl();
                case ALLOT -> commandExecutor = new AllotCourseCommandExecutorImpl();
                default -> {
                }
            }

            commandExecutor.executeCommand(courses,registrationIdCourseMap, inputInputAction);
        } catch(CourseFullException e) {
            System.out.println(e.getMessage());
        }
    }
}

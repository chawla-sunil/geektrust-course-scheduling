package org.example.sunilChawla.services.serviceImpls;



import org.example.sunilChawla.customException.InvalidInputException;
import org.example.sunilChawla.model.InputAction;
import org.example.sunilChawla.model.Course;
import org.example.sunilChawla.services.CommandExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class AddCourseOfferingCommandExecutorImpl implements CommandExecutor {

    @Override
    public void executeCommand(Map<String, Course> courses, Map<String, Course> registrationIdCourseMap, InputAction inputAction) throws InvalidInputException {
        List<String> arguments = inputAction.getActionArguments();
        Course course;

        try {
            String courseName = arguments.get(0);
            String courseInstructor = arguments.get(1);
            Date date = new SimpleDateFormat("ddMMyyyy").parse(arguments.get(2));
            int minCount = Integer.parseInt(arguments.get(3));
            int maxCount = Integer.parseInt(arguments.get(4));
            course = new Course("OFFERING-" + courseName + "-" + courseInstructor, courseName, courseInstructor,
                                 date, minCount, maxCount, false, false);
        } catch (Exception e) {
            // catch for date parsing error
            throw new InvalidInputException("INPUT_ERROR");
        }

        // course adding/offering
        courses.put(course.getCourseId(),course);
        System.out.println(course.getCourseId());
    }

}

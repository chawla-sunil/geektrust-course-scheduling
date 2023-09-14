package org.example.sunilChawla.services.serviceImpls;

import org.example.sunilChawla.customException.CourseFullException;
import org.example.sunilChawla.customException.InvalidInputException;
import org.example.sunilChawla.model.InputAction;
import org.example.sunilChawla.model.Course;
import org.example.sunilChawla.model.Employee;
import org.example.sunilChawla.services.CommandExecutor;

import java.util.Map;

import static org.example.sunilChawla.utils.Helper.ACCEPTED;
import static org.example.sunilChawla.utils.Helper.REJECTED;

public class RegisterCourseCommandExecutorImpl implements CommandExecutor {

    @Override
    public void executeCommand(Map<String, Course> courses, Map<String, Course> registrationIdCourseMap, InputAction inputAction) throws InvalidInputException, CourseFullException {
        String courseId = inputAction.getActionArguments().get(1);
        Employee employee = new Employee(inputAction.getActionArguments().get(0));

        if (courses.containsKey(courseId)) {
            Course course = courses.get(courseId);
            if (!courses.get(courseId).isAllotted() || !courses.get(courseId).isCancelled()) {
                if (course.getRegIdVsEmployees().size()==course.getMaxEmployees()) {
                    throw new CourseFullException("COURSE_FULL_ERROR");
                } else {
                    //registering the employee to the course courseId
                    String registrationId = course.addEmployee(employee);
                    registrationIdCourseMap.put(registrationId , course);
                    System.out.println(registrationId+" "+ACCEPTED);
                }
            } else {
                //When course is already, and now we cannot allow this to anyone
                System.out.println("REG-COURSE-" + employee.getName() + "-" + courses.get(courseId).getCourseName() + " " + REJECTED);
            }
        } else {
            //when courseId is entered wrong
            System.out.println("INPUT_DATA_ERROR");
        }
    }
}

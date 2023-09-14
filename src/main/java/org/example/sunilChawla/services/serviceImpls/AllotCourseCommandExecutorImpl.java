package org.example.sunilChawla.services.serviceImpls;

import org.example.sunilChawla.customException.InvalidInputException;
import org.example.sunilChawla.model.InputAction;
import org.example.sunilChawla.model.Course;
import org.example.sunilChawla.model.Employee;
import org.example.sunilChawla.services.CommandExecutor;
import org.example.sunilChawla.utils.Helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

public class AllotCourseCommandExecutorImpl implements CommandExecutor {
    @Override
    public void executeCommand(Map<String, Course> courses, Map<String, Course> registrationIdCourseMap, InputAction inputAction) throws InvalidInputException {
        String courseId = inputAction.getActionArguments().get(0);
        Course course = courses.get(courseId);

        if (course!=null) {
            if (course.getRegIdVsEmployees().size() < course.getMinEmployees()) {
                course.setCancelled(true);
                printCourseAllotment(course);
            } else {
                course.setAllotted(true);
                printCourseAllotment(course);
            }
        } else {
            throw new InvalidInputException("INPUT_DATA_ERROR");
        }
    }

    private void printCourseAllotment(Course course) {
        String status = course.isCancelled() ? Helper.COURSE_CANCELED : Helper.CONFIRMED ;
        for (Map.Entry<String, Employee> entry: course.getRegIdVsEmployees().entrySet()) {
            String pattern = "ddMMyyyy";
            DateFormat df = new SimpleDateFormat(pattern);
            System.out.println(entry.getKey() + " " + entry.getValue().getEmail() + " " + course.getCourseId() + " " +
                    course.getCourseName() + " " + course.getInstructor() + " " + df.format(course.getDate()) + " " + status);
        }
    }
}


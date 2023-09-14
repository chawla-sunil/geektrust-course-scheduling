package org.example.sunilChawla.services.serviceImpls;


import org.example.sunilChawla.model.InputAction;
import org.example.sunilChawla.model.Course;
import org.example.sunilChawla.services.CommandExecutor;

import java.util.Map;

import static org.example.sunilChawla.utils.Helper.CANCEL_ACCEPTED;
import static org.example.sunilChawla.utils.Helper.CANCEL_REJECTED;

public class CancelCourseCommandExecutorImpl implements CommandExecutor {
    @Override
    public void executeCommand(Map<String, Course> courses, Map<String, Course> registrationIdCourseMap, InputAction inputAction) {
        String registrationId = inputAction.getActionArguments().get(0);
        if (registrationIdCourseMap.get(registrationId) != null) {     // does course exist ??

            if (registrationIdCourseMap.get(registrationId).isAllotted()) {  // course already allotted ??
                System.out.println(registrationId+ " " + CANCEL_REJECTED);
            } else {
                //Remove the employee from course,
                removeEmployeeFromCourse(registrationId, registrationIdCourseMap);
                System.out.println(registrationId + " " + CANCEL_ACCEPTED);
            }
        } else {
            System.out.println(registrationId + " " + CANCEL_REJECTED);
        }
    }

    private void removeEmployeeFromCourse(String registrationId, Map<String, Course> registrationIdCourseMap) {
        Course course = registrationIdCourseMap.get(registrationId);
        course.getRegIdVsEmployees().remove(registrationId);
        registrationIdCourseMap.remove(registrationId);
    }
}
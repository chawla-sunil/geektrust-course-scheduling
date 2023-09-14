package org.example.sunilChawla.model;

import java.util.*;

public class Course{
    private final String courseId;
    private final String courseName;
    private final String instructor;
    private final Date date;
    private final int minEmployees;
    private final int maxEmployees;
    private boolean isAllotted;
    private boolean isCancelled;

    private final Map<String , Employee> regIdVsEmployees;


    public Course(String courseId, String courseName, String instructor, Date date, int minEmployees, int maxEmployees, boolean isAllotted, boolean isCancelled) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.date = date;
        this.minEmployees = minEmployees;
        this.maxEmployees = maxEmployees;
        this.isAllotted = isAllotted;
        this.isCancelled = isCancelled;
        regIdVsEmployees = new HashMap<>();
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public Date getDate() {
        return date;
    }

    public int getMinEmployees() {
        return minEmployees;
    }

    public int getMaxEmployees() {
        return maxEmployees;
    }

    public boolean isAllotted() {
        return isAllotted;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setAllotted(boolean allotted) {
        isAllotted = allotted;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public Map<String, Employee> getRegIdVsEmployees() {
        return regIdVsEmployees;
    }

    public String addEmployee(Employee employee) {
        String registrationId = "REG-COURSE-" + employee.getName() + "-" + this.courseName;
        this.regIdVsEmployees.put(registrationId , employee);
        return registrationId;
    }

}


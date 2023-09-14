package org.example.sunilChawla.utils;

public class Helper {

    public static final String REJECTED = "REJECTED";
    public static final String ACCEPTED = "ACCEPTED";
    public static final String CANCEL_REJECTED = "CANCEL_REJECTED";
    public static final String CANCEL_ACCEPTED = "CANCEL_ACCEPTED";
    public static final String COURSE_CANCELED = "COURSE_CANCELED";
    public static final String CONFIRMED = "CONFIRMED";

    public static String getInputToEnumString(String input) {
        return switch (input) {
            case "ADD-COURSE-OFFERING" -> "ADD_COURSE_OFFERING";
            case "ALLOT-COURSE" -> "ALLOT_COURSE";
            default -> input;
        };
    }
}
package org.example.sunilChawla.enums;

public enum InputActionEnum {
    ADD_COURSE_OFFERING(5),
    CANCEL(1),
    REGISTER(2),
    ALLOT(1);

    InputActionEnum(Integer numberOfArgumentsForThisAction) {
        this.numberOfArguments = numberOfArgumentsForThisAction;
    }

    private final Integer numberOfArguments;

    public Integer getNumberOfArguments() {
        return numberOfArguments;
    }
}

package org.example.sunilChawla.model;

import org.example.sunilChawla.enums.InputActionEnum;

import java.util.List;

public class InputAction {
    private final InputActionEnum inputAction;
    private final List<String> actionArguments;

    public InputAction(InputActionEnum inputAction, List<String> commandParams){
        this.inputAction = inputAction;
        this.actionArguments = commandParams;
    }

    public InputActionEnum getInputAction() {
        return inputAction;
    }

    public List<String> getActionArguments() {
        return actionArguments;
    }

}

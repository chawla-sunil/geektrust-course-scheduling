package org.example.sunilChawla.services;

import org.example.sunilChawla.customException.InvalidInputException;
import org.example.sunilChawla.enums.InputActionEnum;
import org.example.sunilChawla.model.InputAction;
import org.example.sunilChawla.utils.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputActionService {
    public InputAction getInputAction(String input) throws InvalidInputException {
        try {
            String[] actionAndArguments = input.split(" ");
            InputActionEnum action = InputActionEnum.valueOf(Helper.getInputToEnumString(actionAndArguments[0]));
            List<String> actionArguments = new ArrayList<>(Arrays.asList(actionAndArguments));
            actionArguments.remove(0);

            InputAction inputAction = new InputAction(action, actionArguments);
            if(action.getNumberOfArguments()!= inputAction.getActionArguments().size()) {
                throw new InvalidInputException("INPUT_DATA_ERROR");
            }
            return inputAction;
        } catch (Exception e) {
            throw new InvalidInputException("INPUT_DATA_ERROR");
        }
    }
}

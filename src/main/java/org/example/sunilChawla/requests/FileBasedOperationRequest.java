package org.example.sunilChawla.requests;

import org.example.sunilChawla.customException.InvalidInputException;
import org.example.sunilChawla.model.InputAction;
import org.example.sunilChawla.services.InputActionService;

import java.io.BufferedReader;
import java.io.IOException;

public class FileBasedOperationRequest extends OperationRequest {

    private String filePath;

    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }


    public InputAction readLineAndGetAction(BufferedReader reader) throws InvalidInputException, IOException {
        InputActionService inputActionService = new InputActionService();
        String inputString = reader.readLine();
        if (inputString == null) {
            return null;
        }
        if (inputString.isEmpty()) {
            // when we encounter empty line ==> inputString.length() = 0;
            readLineAndGetAction(reader);
        }
        try {
            return inputActionService.getInputAction(inputString);
        } catch(InvalidInputException e) {
            System.out.println(e.getMessage());
            return readLineAndGetAction(reader);
        }
    }


}

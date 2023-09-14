package org.example.sunilChawla.services.serviceImpls;

import org.example.sunilChawla.customException.InvalidInputException;
import org.example.sunilChawla.model.InputAction;
import org.example.sunilChawla.requests.FileBasedOperationRequest;
import org.example.sunilChawla.requests.OperationRequest;
import org.example.sunilChawla.services.LMS;
import org.example.sunilChawla.services.OperationService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileBased implements OperationService {
    @Override
    public void performOperation(OperationRequest operationRequest) {
        FileBasedOperationRequest fileBasedOperationRequest = (FileBasedOperationRequest) operationRequest;
        LMS lms = fileBasedOperationRequest.getLms();

        try {
            File file = new File(fileBasedOperationRequest.getFilePath());
            BufferedReader fileReader = new BufferedReader(new FileReader(file));

            // Read the operation to be done from the file
            try {
                InputAction inputAction = fileBasedOperationRequest.readLineAndGetAction(fileReader);
                while (inputAction != null) {
                    lms.performAction(inputAction);
                    inputAction = fileBasedOperationRequest.readLineAndGetAction(fileReader);
                }
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Problem While Reading File And Performing OperationService.");
        }
    }
}

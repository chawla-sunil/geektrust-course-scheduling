package org.example.sunilChawla.services.serviceImpls;

import org.example.sunilChawla.model.InputAction;
import org.example.sunilChawla.requests.ConsoleBasedOperationRequest;
import org.example.sunilChawla.requests.OperationRequest;
import org.example.sunilChawla.services.LMS;
import org.example.sunilChawla.services.OperationService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleBased implements OperationService {
    @Override
    public void performOperation(OperationRequest operationRequest) {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        ConsoleBasedOperationRequest consoleBasedOperationRequest = (ConsoleBasedOperationRequest) operationRequest;
        LMS lms = consoleBasedOperationRequest.getLms();

        try {
            // Ask for the operation from the console
            InputAction inputAction = consoleBasedOperationRequest.readLineAndGetAction(consoleReader);
            while (inputAction != null) {
                lms.performAction(inputAction);
                inputAction = consoleBasedOperationRequest.readLineAndGetAction(consoleReader);
            }
        } catch (Exception e) {
            System.out.println("Problem In Reading From Console And Performing OperationService.");
        }
    }
}

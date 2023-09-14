package org.example.sunilChawla;


import org.example.sunilChawla.requests.ConsoleBasedOperationRequest;
import org.example.sunilChawla.requests.FileBasedOperationRequest;
import org.example.sunilChawla.services.LMS;
import org.example.sunilChawla.services.OperationService;
import org.example.sunilChawla.services.serviceImpls.ConsoleBased;
import org.example.sunilChawla.services.serviceImpls.FileBased;


public class CourseSchedulingMain {
    public static void main(String[] args) {
        CourseSchedulingMain app = new CourseSchedulingMain();
        app.chooseOperationService(args);
    }

    private void chooseOperationService(String[] args) {
        LMS lms = new LMS();

        // Check for file-based operationService or console-based operationService
        OperationService operationService;

        if (args.length == 1) {

            operationService = new FileBased();

            FileBasedOperationRequest fileBasedOperationRequest = new FileBasedOperationRequest();
            fileBasedOperationRequest.setFilePath(args[0]);
            fileBasedOperationRequest.setLms(lms);

            operationService.performOperation(fileBasedOperationRequest);
        } else {

            operationService = new ConsoleBased();

            ConsoleBasedOperationRequest consoleBasedOperationRequest = new ConsoleBasedOperationRequest();
            consoleBasedOperationRequest.setLms(lms);
            operationService.performOperation(consoleBasedOperationRequest);
        }
    }
}
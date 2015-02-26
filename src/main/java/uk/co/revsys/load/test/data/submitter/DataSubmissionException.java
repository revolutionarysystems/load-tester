package uk.co.revsys.load.test.data.submitter;

public class DataSubmissionException extends Exception{

    public DataSubmissionException(String message) {
        super(message);
    }

    public DataSubmissionException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataSubmissionException(Throwable cause) {
        super(cause);
    }

}

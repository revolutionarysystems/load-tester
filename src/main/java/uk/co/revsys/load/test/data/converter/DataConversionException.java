package uk.co.revsys.load.test.data.converter;

public class DataConversionException extends Exception{

    public DataConversionException(String message) {
        super(message);
    }

    public DataConversionException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataConversionException(Throwable cause) {
        super(cause);
    }

}

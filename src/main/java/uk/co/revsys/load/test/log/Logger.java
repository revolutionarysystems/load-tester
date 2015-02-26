package uk.co.revsys.load.test.log;

public interface Logger<E extends LogEntry>{

    public E createEntry();
    
    public void log(E entry) throws LoggerException;
    
}

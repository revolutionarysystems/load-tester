package uk.co.revsys.load.test.log;

public abstract class AbstractLogger implements Logger{

    @Override
    public LogEntry createEntry() {
        return new LogEntry();
    }

}

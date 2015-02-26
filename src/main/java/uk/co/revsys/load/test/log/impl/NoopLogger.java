package uk.co.revsys.load.test.log.impl;

import uk.co.revsys.load.test.log.AbstractLogger;
import uk.co.revsys.load.test.log.LogEntry;
import uk.co.revsys.load.test.log.LoggerException;

public class NoopLogger extends AbstractLogger{

    @Override
    public void log(LogEntry entry) throws LoggerException {
        
    }

}

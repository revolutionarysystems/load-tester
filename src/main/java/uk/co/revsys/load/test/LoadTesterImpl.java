package uk.co.revsys.load.test;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.LoggerFactory;
import uk.co.revsys.load.test.data.converter.DataConversionException;
import uk.co.revsys.load.test.data.converter.DataConverter;
import uk.co.revsys.load.test.data.provider.DataProvider;
import uk.co.revsys.load.test.data.provider.DataProviderException;
import uk.co.revsys.load.test.data.submitter.DataSubmissionException;
import uk.co.revsys.load.test.data.submitter.DataSubmitter;
import uk.co.revsys.load.test.limit.RateLimiter;
import uk.co.revsys.load.test.log.LogEntry;
import uk.co.revsys.load.test.log.Logger;
import uk.co.revsys.load.test.log.LoggerException;

public class LoadTesterImpl implements LoadTester {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(LoadTesterImpl.class);

    private final RateLimiter rateLimiter;
    private final DataProvider dataProvider;
    private final DataSubmitter dataSubmitter;
    private final Logger logger;
    private final int threads;
    private final ExecutorService executorService;

    public LoadTesterImpl(RateLimiter rateLimiter, DataProvider dataProvider, DataSubmitter dataSubmitter, Logger logger, int threads) {
        this.rateLimiter = rateLimiter;
        this.dataProvider = dataProvider;
        this.dataSubmitter = dataSubmitter;
        this.logger = logger;
        this.threads = threads;
        this.executorService = Executors.newFixedThreadPool(threads);
    }

    @Override
    public void run() {
        for (int i = 0; i < threads; i++) {
            executorService.execute(new Runnable() {

                @Override
                public void run() {
                    while (true) {
                        try {
                            LOG.debug("Waiting...");
                            rateLimiter.block();
                            if (dataProvider.hasData()) {
                                LogEntry logEntry = logger.createEntry();
                                logEntry.setStartTime(new Date());
                                Object data = dataProvider.getData();
                                LOG.debug("Data: " + data);
                                logEntry.setData(data);
                                logEntry.setSubmissionStartTime(new Date());
                                Object result = dataSubmitter.submit(data);
                                LOG.debug("Result: " + result);
                                logEntry.setResult(result);
                                logEntry.setEndTime(new Date());
                                logger.log(logEntry);
                            } else {
                                LOG.debug("No data available");
                            }
                        } catch (DataProviderException ex) {
                            ex.printStackTrace();
                            LOG.error("Error retrieving data", ex);
                        } catch (DataSubmissionException ex) {
                            ex.printStackTrace();
                            LOG.error("Error submitting data", ex);
                        } catch (LoggerException ex) {
                            ex.printStackTrace();
                            LOG.error("Error logging result", ex);
                        }
                    }
                }
            });
        }
    }

}

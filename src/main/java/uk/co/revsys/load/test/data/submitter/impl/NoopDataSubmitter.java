package uk.co.revsys.load.test.data.submitter.impl;

import uk.co.revsys.load.test.data.submitter.DataSubmissionException;
import uk.co.revsys.load.test.data.submitter.DataSubmitter;

public class NoopDataSubmitter implements DataSubmitter<Object, Object>{

    @Override
    public Object submit(Object data) throws DataSubmissionException {
        return null;
    }

}

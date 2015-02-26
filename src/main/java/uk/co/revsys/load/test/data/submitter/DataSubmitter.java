package uk.co.revsys.load.test.data.submitter;

public interface DataSubmitter<D extends Object, R extends Object> {

    public R submit(D data) throws DataSubmissionException;
    
}

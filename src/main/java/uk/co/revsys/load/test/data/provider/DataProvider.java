package uk.co.revsys.load.test.data.provider;

public interface DataProvider<D extends Object> {

    public boolean hasData();
    
    public D getData() throws DataProviderException;
    
}

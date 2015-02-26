package uk.co.revsys.load.test.data.provider;

import uk.co.revsys.load.test.data.converter.DataConversionException;
import uk.co.revsys.load.test.data.converter.DataConverter;

public abstract class ConvertingDataProvider<D extends Object, R extends Object, C extends DataConverter> implements DataProvider<D>{

    private final C dataConverter;

    public ConvertingDataProvider(C dataConverter) {
        this.dataConverter = dataConverter;
    }
    
    @Override
    public D getData() throws DataProviderException {
        try {
            R rawData = getRawData();
            D data = (D) dataConverter.convert(rawData);
            return data;
        } catch (DataConversionException ex) {
            throw new DataProviderException(ex);
        }
    }
    
    public abstract R getRawData() throws DataProviderException;

}

package uk.co.revsys.load.test.data.converter;

public interface DataConverter<I extends Object, O extends Object> {

    public O convert(I data) throws DataConversionException;
    
}

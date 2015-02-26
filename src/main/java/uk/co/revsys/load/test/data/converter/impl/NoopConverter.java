package uk.co.revsys.load.test.data.converter.impl;

import uk.co.revsys.load.test.data.converter.DataConversionException;
import uk.co.revsys.load.test.data.converter.DataConverter;

public class NoopConverter implements DataConverter<Object, Object>{

    @Override
    public Object convert(Object data) throws DataConversionException {
        return data;
    }

}

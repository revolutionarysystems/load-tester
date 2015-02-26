package uk.co.revsys.load.test.data.converter.impl;

import org.json.JSONObject;
import uk.co.revsys.load.test.data.converter.DataConversionException;
import uk.co.revsys.load.test.data.provider.impl.CSVEntry;

public class CSVToJSONConverter extends CSVConverter<JSONObject>{

    public CSVToJSONConverter() {
    }

    @Override
    public JSONObject convert(CSVEntry data) throws DataConversionException {
        JSONObject json = new JSONObject(data);
        return json;
    }

}

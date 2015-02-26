package uk.co.revsys.load.test.data.provider.impl;

import java.util.LinkedHashMap;
import java.util.Map;

public class CSVEntry extends LinkedHashMap<String, String> {

    public CSVEntry() {
    }

    public CSVEntry(Map<String, String> m) {
        super(m);
    }

}

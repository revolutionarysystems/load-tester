package uk.co.revsys.load.test.data.provider.impl;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import uk.co.revsys.load.test.data.converter.impl.CSVConverter;
import uk.co.revsys.load.test.data.provider.DataProviderException;
import uk.co.revsys.resource.repository.ResourceRepository;
import uk.co.revsys.resource.repository.model.Resource;

public class CSVResourceDataProvider<D extends Object> extends ResourceRepositoryDataProvider<D, CSVEntry, CSVConverter> {

    private List<String> headers;

    public CSVResourceDataProvider(ResourceRepository resourceRepository, CSVConverter csvConverter) {
        super(resourceRepository, csvConverter);
    }

    @Override
    public CSVEntry getRawData(String line) throws DataProviderException {
        CSVEntry entry = new CSVEntry();
        String[] tokens = line.split(",");
        for(int i=0; i<headers.size(); i++){
            entry.put(headers.get(i), tokens[i].trim());
        }
        return entry;
    }

    @Override
    protected void filter(List<Resource> resources) {
        Iterator<Resource> iterator = resources.iterator();
        while (iterator.hasNext()) {
            Resource resource = iterator.next();
            if (!resource.getName().endsWith(".csv")) {
                iterator.remove();
            }
        }
    }

    @Override
    protected void readNextFile() throws IOException {
        super.readNextFile();
        if (lines != null) {
            headers = new LinkedList<String>();
            String headersString = lines.next();
            for (String header : headersString.split(",")) {
                headers.add(header.trim());
            }
        }
    }

}

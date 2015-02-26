package uk.co.revsys.load.test.data.provider.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.LineIterator;
import uk.co.revsys.load.test.data.converter.DataConverter;
import uk.co.revsys.load.test.data.provider.ConvertingDataProvider;
import uk.co.revsys.load.test.data.provider.DataProviderException;
import uk.co.revsys.resource.repository.ResourceRepository;
import uk.co.revsys.resource.repository.model.Resource;

public abstract class ResourceRepositoryDataProvider<D extends Object, R extends Object, C extends DataConverter> extends ConvertingDataProvider<D, R, C>{

    private final ResourceRepository resourceRepository;
    private final Iterator<Resource> resources;
    protected LineIterator lines;

    public ResourceRepositoryDataProvider(ResourceRepository resourceRepository, C dataConverter) {
        super(dataConverter);
        this.resourceRepository = resourceRepository;
        try {
            List<Resource> resourcesList = resourceRepository.listResources(".");
            filter(resourcesList);
            resources = resourcesList.iterator();
            readNextFile();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    protected void filter(List<Resource> resources) {
        
    }
    
    @Override
    public boolean hasData() {
        return lines != null && (lines.hasNext() || resources.hasNext());
    }

    @Override
    public R getRawData() throws DataProviderException {
        try {
            if(!hasData()){
                throw new DataProviderException("No data available");
            }
            if (!lines.hasNext()) {
                readNextFile();
            }
            String line = lines.next();
            return getRawData(line);
        } catch (IOException ex) {
            throw new DataProviderException(ex);
        }
    }
    
    public abstract R getRawData(String line) throws DataProviderException;
    
    protected void readNextFile() throws IOException {
        if (resources.hasNext()) {
            Resource resource = resources.next();
            InputStream resourceStream = resourceRepository.read(resource);
            lines = new LineIterator(new BufferedReader(new InputStreamReader(resourceStream)));
        } else {
            lines = null;
        }
    }

}

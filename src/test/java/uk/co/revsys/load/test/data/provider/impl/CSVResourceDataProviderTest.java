
package uk.co.revsys.load.test.data.provider.impl;

import java.io.File;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uk.co.revsys.load.test.data.converter.impl.CSVToJSONConverter;
import uk.co.revsys.resource.repository.LocalDiskResourceRepository;

public class CSVResourceDataProviderTest {

    public CSVResourceDataProviderTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test() throws Exception{
        File dir = new File("src/test/resources");
        CSVResourceDataProvider<JSONObject> dataProvider = new CSVResourceDataProvider(new LocalDiskResourceRepository(dir), new CSVToJSONConverter());
        assertEquals(true, dataProvider.hasData());
        JSONObject json = dataProvider.getData();
        assertEquals("v1", json.getString("p1"));
        assertEquals("v2", json.getString("p2"));
        assertEquals("v3", json.getString("p3"));
        assertEquals(false, dataProvider.hasData());
    }

}
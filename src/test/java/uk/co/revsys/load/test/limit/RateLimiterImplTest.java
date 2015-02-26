
package uk.co.revsys.load.test.limit;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RateLimiterImplTest {

    public RateLimiterImplTest() {
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
    public void testBlock() {
        RateLimiterImpl limiter = new RateLimiterImpl(1);
        long start = new Date().getTime();
        int count = 0;
        while(new Date().getTime() - start < 2000){
            limiter.block();
            count++;
        }
        assertTrue(count <= 3);
    }

}
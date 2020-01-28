package kz.zhanbolat.learn;

import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testLog4j2() {
        Logger logger = LogManager.getLogger(getClass());
        logger.info("INFO");
        logger.debug("DEBUG");
        logger.warn("WARN");
        logger.error("ERROR");
        logger.fatal("FATAL");
    }

}

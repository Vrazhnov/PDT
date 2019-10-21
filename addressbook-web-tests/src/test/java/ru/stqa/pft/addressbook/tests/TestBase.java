package ru.stqa.pft.addressbook.tests;

import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

public class TestBase {

    protected ApplicationManager app;
    protected Logger log = Logger.getLogger("TEST");

    @BeforeTest
    @Parameters({"configFile"})
    public void setUp(@Optional String configFile) throws Exception {
        if (configFile == null){
            configFile = System.getProperty("configFile");
        }
        if (configFile == null){
            configFile = System.getenv("configFile");
        }
        if (configFile == null){
            configFile = "application.properties";
        }
        Properties props = new Properties();
        props.load(new FileReader(configFile));
        log.info("SetUp start");
        app = ApplicationManager.getInstance(props);
        log.info("SetUp end");
        app = new ApplicationManager();
    }

/*    @AfterTest
    public void tearDown() throws Exception {
        log.info("tearDown start");
        ApplicationManager.getInstance(null).stop();
        log.info("tearDown end");
    }
*/
}
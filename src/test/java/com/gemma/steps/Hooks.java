package com.gemma.steps;


import com.gemma.pageObject.baseClass;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import static com.gemma.utils.browserConnection.setupDriver;


public class Hooks  extends baseClass {

    private static Logger logger = LoggerFactory.getLogger(Hooks.class);
    //private static Scenario scenario;


    @BeforeAll
    public static void initialization() {
        setupDriver();
    }


    @After
    public static void tearDown(Scenario scenario)  {
        List<String> tags = (ArrayList<String>) scenario.getSourceTagNames();
        logger.info("Tear down "+scenario.getName()+tags.toString());

        if (driver != null) {
            SessionId sessionId = ((RemoteWebDriver) driver).getSessionId();
            if (sessionId != null && scenario.isFailed()) {
                logger.info("Taking screenshot for failed scenario");
//                 Allure.addAttachment("Error screenshot",
//                        new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
                TakesScreenshot scrShot =((TakesScreenshot)driver);
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
                //File DestFile=new File("C:\\Users\\a803848\\TestAutomationGemma\\target\\screenshots\\screenshot.png");
                File DestFile = new File(System.getProperty("user.dir") + "/target/screenshots/" + "screenshot.png");

                try {
                    FileUtils.copyFile(SrcFile, DestFile);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
           if (sessionId != null && driver != null)
           {
               driver.close();
               driver.quit();
            }
        }
    }




}

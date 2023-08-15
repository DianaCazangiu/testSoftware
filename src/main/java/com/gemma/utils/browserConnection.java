package com.gemma.utils;

import com.gemma.pageObject.baseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static com.gemma.utils.PropertyFileReader.getWebsite;

public class browserConnection extends baseClass {

    private static Logger logger = LoggerFactory.getLogger(browserConnection.class);


    public Capabilities getChromeCapabilities() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized");
        DesiredCapabilities chrome = new DesiredCapabilities();
        chrome.setJavascriptEnabled(true);
        chrome.setCapability(ChromeOptions.CAPABILITY, option);
        return chrome;
    }


    public static void setupDriver() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ((RemoteWebDriver) driver).setLogLevel(Level.INFO);
        driver.manage().window().maximize();
        //driver.get(read.getProperty("gemmaURL"));
        driver.get(getWebsite());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

}

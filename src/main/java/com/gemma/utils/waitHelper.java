package com.gemma.utils;



import com.gemma.pageObject.baseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.gemma.utils.PropertyFileReader.getImplicitWait;

//import static com.gemma.utils.PropertyFileReader.getImplicitWait;


public class waitHelper extends baseClass {

    private static Logger logger = LoggerFactory.getLogger(waitHelper.class);


    public static void hardWait(int ms) {
        logger.info(String.valueOf(ms));
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void WaitForElement(WebElement element, long timeOutInSeconds) {
        logger.info("waiting for element visibilityOf..");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
        logger.info("element is visible..");


    }

    private static WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
        logger.debug("");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.pollingEvery(Duration.ofSeconds(timeOutInSeconds));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchFrameException.class);
        return wait;
    }

    public static void setImplicitWait(long timeout, TimeUnit unit) {
        logger.info(String.valueOf(timeout));
        driver
                .manage()
                .timeouts()
                .implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
    }

    public static void waitForElementVisible(By locator,int timeOutInSeconds,int pollingEveryInMiliSec) {
        logger.info(String.valueOf(locator));
        setImplicitWait(1, TimeUnit.SECONDS);
        WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        setImplicitWait(getImplicitWait(), TimeUnit.SECONDS);
    }


    public void waitForIframe(By locator,int timeOutInSeconds,int pollingEveryInMiliSec) {
        logger.info(String.valueOf(locator));
        setImplicitWait(1, TimeUnit.SECONDS);
        WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
        driver.switchTo().defaultContent();
        setImplicitWait(getImplicitWait(), TimeUnit.SECONDS);
    }
}

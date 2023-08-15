package com.gemma.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gemma.utils.waitHelper;
import java.util.Properties;
import static com.gemma.pageObject.callPage.getAccessUserMenu;
import static com.gemma.utils.PropertyFileReader.*;

public class operationPage extends baseClass{

    private static Logger logger = LoggerFactory.getLogger(operationPage.class);

    static Properties propertyRead;

    static {
        try {
            propertyRead = getPropertyLocatorsFile("generalLocators.properties");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void changeBackgroundColor() {

        waitHelper.hardWait(5000);
        driver.findElement(getAccessUserMenu()).click();
        waitHelper.hardWait(4000);
        Actions actTheme = new Actions(driver);
        //WebElement theme = driver.findElement(By.xpath(propertyRead.getProperty("x_changeThemeButton")));
        WebElement theme = driver.findElement(By.linkText("Change Theme"));
        actTheme.moveToElement(theme).perform();
        waitHelper.hardWait(4000);
        //driver.findElement(By.xpath(propertyRead.getProperty("x_lightModeTheme"))).click();
        driver.findElement(By.linkText("Light Theme")).click();

        logger.info("Theme changed to light mode");

        driver.findElement(getAccessUserMenu()).click();
        waitHelper.hardWait(4000);

        //WebElement theme1 =driver.findElement(By.xpath(propertyRead.getProperty("x_changeThemeButton")));
        WebElement theme1 = driver.findElement(By.linkText("Change Theme"));
        actTheme.moveToElement(theme1).perform();
        waitHelper.hardWait(4000);
        //driver.findElement(By.xpath(propertyRead.getProperty("x_darkModeTheme"))).click();
        driver.findElement(By.linkText("Dark Theme")).click();
        logger.info("Theme changed to dark mode");
    }









}

package com.gemma.pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gemma.utils.waitHelper;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static com.gemma.pageObject.callPage.getAccessUserMenu;
import static com.gemma.utils.PropertyFileReader.*;


public class loginPageTrainingTest extends baseClass{
  static Properties propertyReader;

  static {
    try {
      propertyReader = getPropertyFile("config.properties");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  static Properties propertyRead;

  static {
    try {
      propertyRead = getPropertyLocatorsFile("generalLocators.properties");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }


  private static Logger logger = LoggerFactory.getLogger(loginPageTrainingTest.class);

  public loginPageTrainingTest() throws Exception {
  }


  public static By getStartSession() {
    return By.xpath(propertyRead.getProperty("x_startSessionButton"));
  }

  public static By getTestSuperuserAndSuperviserRole() {
    return By.xpath(propertyRead.getProperty("x_testSuperuserAndSuperviserRole"));
  }

  public static By getLogonButton() {
    return By.xpath(propertyRead.getProperty("x_logonButton"));
  }




  public static void loginToGemmaTraining() {
    driver.quit();
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    ((RemoteWebDriver) driver).setLogLevel(Level.INFO);
    driver.manage().window().maximize();
    driver.get(getWebsite());
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }


  public static void accessGemmaAccount() {

    driver.findElement(By.xpath(propertyRead.getProperty("x_username"))).sendKeys(getUsername());
    logger.info("Username is correctly entered");
    driver.findElement(By.xpath(propertyRead.getProperty("x_password"))).sendKeys(getPassword());
    logger.info("Password is correctly entered");
    driver.findElement(getStartSession()).click();
    waitHelper.hardWait(1000);
    logger.info("Access requested");

    if (driver.findElement(By.xpath(propertyRead.getProperty("x_confirmationYesButton"))).isDisplayed()) {
      driver.findElement(By.xpath(propertyRead.getProperty("x_confirmationYesButton"))).click();
    }

  }

  public static void getGemmaRole() {
    driver.findElement(By.xpath(propertyRead.getProperty("x_roleArrow"))).click();
    //waitHelper.hardWait(1000);
    driver.findElement(getTestSuperuserAndSuperviserRole()).click();
    waitHelper.hardWait(1000);
    logger.info("User role selected");
    driver.findElement(getLogonButton()).click();
    logger.info("Access done");
    String actualTitle = driver.getTitle();
    String expectedTitle = "GEMMA Login";

    if (actualTitle.equals(expectedTitle)) {
      logger.info("The actual Title is " + actualTitle);
    }
  }

  public static void changeBackgroundColorTrainingTest() {

    waitHelper.hardWait(5000);
    driver.findElement(getAccessUserMenu()).click();
    waitHelper.hardWait(4000);
    Actions actTheme = new Actions(driver);
    WebElement theme = driver.findElement(By.linkText("Change Theme"));
    actTheme.moveToElement(theme).perform();
    waitHelper.hardWait(4000);
    driver.findElement(By.linkText("Light Theme")).click();
    logger.info("Theme changed to light mode");
    driver.findElement(getAccessUserMenu()).click();
    waitHelper.hardWait(4000);
    WebElement theme1 = driver.findElement(By.linkText("Change Theme"));
    actTheme.moveToElement(theme1).perform();
    waitHelper.hardWait(4000);
    driver.findElement(By.linkText("Dark Theme")).click();
    logger.info("Theme changed to dark mode");
  }




}

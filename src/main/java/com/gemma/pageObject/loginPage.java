package com.gemma.pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gemma.utils.waitHelper;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static com.gemma.utils.PropertyFileReader.*;
import static com.gemma.utils.encryptDecrypt.*;


public class loginPage  extends baseClass{

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


    private static Logger logger = LoggerFactory.getLogger(loginPage.class);

    public loginPage() throws Exception {
    }


    public static By getStartSession() {
        return By.xpath(propertyRead.getProperty("x_startSessionButton"));
    }

    public static By getTestSuperuserAndSuperviserRole() {
        return By.xpath(propertyRead.getProperty("x_testSuperuserAndSuperviserRole"));
    }

    public static By getDispecerRole() {
        return By.xpath(propertyRead.getProperty("x_dispecerRole"));
    }
    public static By getReceptorRole() {
        return By.xpath(propertyRead.getProperty("x_receptorRole"));
    }

    public static By getTestSuperuserNoSuperviserrRole() {
        return By.xpath(propertyRead.getProperty("x_testSuperuserNoSupervisorRole"));
    }
    public static By getLogonButton() {
        return By.xpath(propertyRead.getProperty("x_logonButton"));
    }


    public static void accessGemmaAccount() {

        //driver.findElement(By.xpath(propertyRead.getProperty("x_username"))).sendKeys(getUsername());
        driver.findElement(By.xpath(propertyRead.getProperty("x_username"))).sendKeys(getEncryptDecryptUsername(encryptedData1,decryptedData1));
        logger.info("Username is correctly entered");
        //driver.findElement(By.xpath(propertyRead.getProperty("x_password"))).sendKeys(getPassword());
        driver.findElement(By.xpath(propertyRead.getProperty("x_password"))).sendKeys(getEncryptDecryptPassword(encryptedData2,decryptedData2));
        logger.info("Password is correctly entered");
        driver.findElement(getStartSession()).click();
        waitHelper.hardWait(1000);
        logger.info("Access requested");

        if (driver.findElement(By.xpath(propertyRead.getProperty("x_confirmationYesButton"))).isDisplayed()) {
            driver.findElement(By.xpath(propertyRead.getProperty("x_confirmationYesButton"))).click();
        }

            driver.findElement(By.xpath(propertyRead.getProperty("x_roleArrow"))).click();
            waitHelper.hardWait(1000);
            driver.findElement(getTestSuperuserAndSuperviserRole()).click();
            waitHelper.hardWait(1000);
            logger.info("User role selected");
            //driver.findElement(By.xpath("/html/body/gemma-root/gemma-main-layout/div/div/article[1]/main/gemma-login-page/form/div/div[4]/button/span")).click();
            driver.findElement(getLogonButton()).click();
            logger.info("Access done");
            //System.out.println("Page title of parent window: "+ driver.getTitle());
            String actualTitle = driver.getTitle();
            String expectedTitle = "GEMMA Login";

            if (actualTitle.equals(expectedTitle)) {
                logger.info("The actual Title is " + actualTitle);
            }



    }

    public static void accessGemmaAccountForDifferentRoles(String role) {

        switch(role) {

            case "dispecer":
                //driver.findElement(By.xpath(propertyRead.getProperty("x_username"))).sendKeys(getUsername());
                driver.findElement(By.xpath(propertyRead.getProperty("x_username"))).sendKeys(getEncryptDecryptUsername(encryptedData1,decryptedData1));
                logger.info("Username is correctly entered");
                //driver.findElement(By.xpath(propertyRead.getProperty("x_password"))).sendKeys(getPassword());
                driver.findElement(By.xpath(propertyRead.getProperty("x_password"))).sendKeys(getEncryptDecryptPassword(encryptedData2,decryptedData2));
                logger.info("Password is correctly entered");
                driver.findElement(getStartSession()).click();
                waitHelper.hardWait(1000);
                logger.info("Access requested");

                if (driver.findElement(By.xpath(propertyRead.getProperty("x_confirmationYesButton"))).isDisplayed()) {
                    driver.findElement(By.xpath(propertyRead.getProperty("x_confirmationYesButton"))).click();
                }
                driver.findElement(By.xpath(propertyRead.getProperty("x_roleArrow"))).click();
                waitHelper.hardWait(1000);
                driver.findElement(getDispecerRole()).click();
                waitHelper.hardWait(1000);
                logger.info("User role selected");
                //driver.findElement(By.xpath("/html/body/gemma-root/gemma-main-layout/div/div/article[1]/main/gemma-login-page/form/div/div[4]/button/span")).click();
                driver.findElement(getLogonButton()).click();
                logger.info("Access done");
                //System.out.println("Page title of parent window: "+ driver.getTitle());
                String actualTitle = driver.getTitle();
                String expectedTitle = "GEMMA Login";

                if (actualTitle.equals(expectedTitle)) {
                    logger.info("The actual Title is " + actualTitle);
                }
                break;

            case "receptor":
                //driver.findElement(By.xpath(propertyRead.getProperty("x_username"))).sendKeys(getUsername());
                driver.findElement(By.xpath(propertyRead.getProperty("x_username"))).sendKeys(getEncryptDecryptUsername(encryptedData1,decryptedData1));
                logger.info("Username is correctly entered");
                //driver.findElement(By.xpath(propertyRead.getProperty("x_password"))).sendKeys(getPassword());
                driver.findElement(By.xpath(propertyRead.getProperty("x_password"))).sendKeys(getEncryptDecryptPassword(encryptedData2,decryptedData2));
                logger.info("Password is correctly entered");
                driver.findElement(getStartSession()).click();
                waitHelper.hardWait(1000);
                logger.info("Access requested");

                if (driver.findElement(By.xpath(propertyRead.getProperty("x_confirmationYesButton"))).isDisplayed()) {
                    driver.findElement(By.xpath(propertyRead.getProperty("x_confirmationYesButton"))).click();
                }
                driver.findElement(By.xpath(propertyRead.getProperty("x_roleArrow"))).click();
                waitHelper.hardWait(1000);
                driver.findElement(getReceptorRole()).click();
                waitHelper.hardWait(1000);
                logger.info("User role selected");
                //driver.findElement(By.xpath("/html/body/gemma-root/gemma-main-layout/div/div/article[1]/main/gemma-login-page/form/div/div[4]/button/span")).click();
                driver.findElement(getLogonButton()).click();
                logger.info("Access done");
                //System.out.println("Page title of parent window: "+ driver.getTitle());
                String actualTitle1 = driver.getTitle();
                String expectedTitle1 = "GEMMA Login";

                if (actualTitle1.equals(expectedTitle1)) {
                    logger.info("The actual Title is " + actualTitle1);
                }
                break;

            case "TestSuperuserNoSuperviser":
                //driver.findElement(By.xpath(propertyRead.getProperty("x_username"))).sendKeys(getUsername());
                driver.findElement(By.xpath(propertyRead.getProperty("x_username"))).sendKeys(getEncryptDecryptUsername(encryptedData1,decryptedData1));
                logger.info("Username is correctly entered");
                //driver.findElement(By.xpath(propertyRead.getProperty("x_password"))).sendKeys(getPassword());
                driver.findElement(By.xpath(propertyRead.getProperty("x_password"))).sendKeys(getEncryptDecryptPassword(encryptedData2,decryptedData2));
                logger.info("Password is correctly entered");
                driver.findElement(getStartSession()).click();
                waitHelper.hardWait(1000);
                logger.info("Access requested");

                if (driver.findElement(By.xpath(propertyRead.getProperty("x_confirmationYesButton"))).isDisplayed()) {
                    driver.findElement(By.xpath(propertyRead.getProperty("x_confirmationYesButton"))).click();
                }
                driver.findElement(By.xpath(propertyRead.getProperty("x_roleArrow"))).click();
                waitHelper.hardWait(1000);
                driver.findElement(getTestSuperuserNoSuperviserrRole()).click();
                waitHelper.hardWait(1000);
                logger.info("User role selected");
                //driver.findElement(By.xpath("/html/body/gemma-root/gemma-main-layout/div/div/article[1]/main/gemma-login-page/form/div/div[4]/button/span")).click();
                driver.findElement(getLogonButton()).click();
                logger.info("Access done");
                //System.out.println("Page title of parent window: "+ driver.getTitle());
                String actualTitle2 = driver.getTitle();
                String expectedTitle2 = "GEMMA Login";

                if (actualTitle2.equals(expectedTitle2)) {
                    logger.info("The actual Title is " + actualTitle2);
                }
                break;

            case "TestSuperuserAndSuperviser":
                //driver.findElement(By.xpath(propertyRead.getProperty("x_username"))).sendKeys(getUsername());
                driver.findElement(By.xpath(propertyRead.getProperty("x_username"))).sendKeys(getEncryptDecryptUsername(encryptedData1,decryptedData1));
                logger.info("Username is correctly entered");
                //driver.findElement(By.xpath(propertyRead.getProperty("x_password"))).sendKeys(getPassword());
                driver.findElement(By.xpath(propertyRead.getProperty("x_password"))).sendKeys(getEncryptDecryptPassword(encryptedData2,decryptedData2));
                logger.info("Password is correctly entered");
                driver.findElement(getStartSession()).click();
                waitHelper.hardWait(1000);
                logger.info("Access requested");

                if (driver.findElement(By.xpath(propertyRead.getProperty("x_confirmationYesButton"))).isDisplayed()) {
                    driver.findElement(By.xpath(propertyRead.getProperty("x_confirmationYesButton"))).click();
                }
                driver.findElement(By.xpath(propertyRead.getProperty("x_roleArrow"))).click();
                waitHelper.hardWait(1000);
                driver.findElement(getTestSuperuserAndSuperviserRole()).click();
                waitHelper.hardWait(1000);
                logger.info("User role selected");
                //driver.findElement(By.xpath("/html/body/gemma-root/gemma-main-layout/div/div/article[1]/main/gemma-login-page/form/div/div[4]/button/span")).click();
                driver.findElement(getLogonButton()).click();
                logger.info("Access done");
                //System.out.println("Page title of parent window: "+ driver.getTitle());
                String actualTitle3 = driver.getTitle();
                String expectedTitle3 = "GEMMA Login";

                if (actualTitle3.equals(expectedTitle3)) {
                    logger.info("The actual Title is " + actualTitle3);
                }
                break;
        }

    }

    public static void loginToGemma() {
        driver.quit();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ((RemoteWebDriver) driver).setLogLevel(Level.INFO);
        driver.manage().window().maximize();
        //driver.get(read.getProperty("gemmaURL"));
        driver.get(getWebsite());
        //driver.get("https://112-dc1.citrix.local/gemma/login/?app=main");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    public static void logoutGemma()  {
        waitHelper.hardWait(10000);
        driver.findElement(By.xpath("/html/body/app-root/div[1]/app-header/div/div[3]/div/div[3]/button/span[1]")).click();
        waitHelper.hardWait(1000);
        driver.findElement(By.xpath("/html/body/div[6]/p-contextmenusub/ul/li[17]")).click();
        waitHelper.hardWait(2000);
        logger.info("Logout requested");
        //driver.findElement(By.xpath("/html/body/div[38]/div/div[3]/p-footer/button[2]")).click();
        driver.findElement(By.xpath("/html/body/div[24]/div/div[3]/p-footer/button[2]")).click();
        waitHelper.hardWait(1000);
        logger.info("Logout done");
    }

    public static void getRequestAccessToGemmaNegativeTest() {


        driver.findElement(By.xpath(propertyRead.getProperty("x_username"))).sendKeys("Diana_c");
        logger.info("Username is correctly entered");
        //driver.findElement(By.xpath(propertyRead.getProperty("x_password"))).sendKeys(getPassword());
        driver.findElement(By.xpath(propertyRead.getProperty("x_password"))).sendKeys(getEncryptDecryptPassword(encryptedData2,decryptedData2));
        logger.info("Password is correctly entered");
        driver.findElement(getStartSession()).click();
        waitHelper.hardWait(1000);
        logger.info("Access requested");



//        String actualTitle3 = driver.getTitle();
//        String expectedTitle3 = "GEMMA Login";
//
//        if (actualTitle3.equals(expectedTitle3)) {
//            logger.info("The actual Title is " + actualTitle3);
//        }
    }

    public static void getErrorLoginMessage() {

        waitHelper.hardWait(1000);
        WebElement errorMessage = driver.findElement(By.xpath(propertyRead.getProperty("x_errorMessageLogin")));
        if (errorMessage.isDisplayed()) {
            String textErrorMessage = errorMessage.getText();
            logger.info(textErrorMessage);
            assert textErrorMessage.contains("Login unsuccessful due to technical issues");
        }
    }



}

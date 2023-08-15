package com.gemma.pageObject;

import com.gemma.utils.waitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

import static com.gemma.pageObject.callPage.*;
import static com.gemma.utils.PropertyFileReader.*;

public class incidentPage extends baseClass{

    private static Logger logger = LoggerFactory.getLogger(incidentPage.class);

    static Properties propertyRead;

    static {
        try {
            propertyRead = getPropertyLocatorsFile("generalLocators.properties");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static By getKeyDataTabIncident() {
        return By.xpath(propertyRead.getProperty("x_keyDataTabIncident"));
    }

    public static By getMoreInfoTabIncident() {
        return By.xpath(propertyRead.getProperty("x_moreInfoTabIncident"));
    }

    public static By getVictimsTabIncident() {
        return By.xpath(propertyRead.getProperty("x_victimsTabIncident"));
    }



    public static void getIncident() {
        waitHelper.hardWait(5000);
        driver.findElement(getAccessUserMenu()).click();
        waitHelper.hardWait(4000);
        Actions actTheme = new Actions(driver);
        WebElement callCreate = driver.findElement(getCreateMenu());
        actTheme.moveToElement(callCreate).perform();
        waitHelper.hardWait(4000);
        driver.findElement(By.xpath(propertyRead.getProperty("x_incidentOption"))).click();
        waitHelper.hardWait(500);
        logger.info("The incident case file is opened");

    }

    public static void getVictimDataIncident() {
        //select priority
        //waitHelper.waitForElementVisible(By.xpath(propertyRead.getProperty("x_generalTab")),10,2);
        waitHelper.hardWait(1000);
        //driver.findElement(getGeneralTab()).click();
        driver.findElement(By.xpath(propertyRead.getProperty("x_generalTabIncident"))).click();
        //waitHelper.hardWait(2000);
        driver.findElement(By.xpath(propertyRead.getProperty("x_priorityArrowIncident"))).click();
        //driver.findElement(By.xpath(reader.getProperty("x_priorityArro"))).click();
        waitHelper.hardWait(500);
        driver.findElement(By.xpath(propertyRead.getProperty("x_mediumPrioritySelectIncident"))).click();
        logger.info("Priority was selected");

        //select call type
        driver.findElement(By.xpath(propertyRead.getProperty("x_callTypeArrowIncident"))).click();
        waitHelper.hardWait(1000);
        driver.findElement(By.xpath(propertyRead.getProperty("x_callTypeOptionIncident"))).click();

        //enter phone number
        driver.findElement(By.xpath(propertyRead.getProperty("x_phoneNumberBoxInputIncident"))).sendKeys("0034675432110");

        logger.info("Phone number was correctly entered");

        //enter name
        waitHelper.hardWait(2000);
        driver.findElement(getKeyDataTabIncident()).click();
        driver.findElement(getMoreInfoTabIncident()).click();
        driver.findElement(By.xpath(propertyRead.getProperty("x_givenNameBoxInputIncident"))).sendKeys("Juana");
        driver.findElement(By.xpath(propertyRead.getProperty("x_familyNameBoxInputIncident"))).sendKeys("Ferrera");
        driver.findElement(By.xpath(propertyRead.getProperty("x_ageBoxInputIncident"))).sendKeys("31");
        driver.findElement(By.xpath(propertyRead.getProperty("x_ageUnitBoxArrowIncident"))).click();
        driver.findElement(By.xpath(propertyRead.getProperty("x_ageUnitSelectIncident"))).click();
        driver.findElement(By.xpath(propertyRead.getProperty("x_genderBoxArrowIncident"))).click();
        driver.findElement(By.xpath(propertyRead.getProperty("x_genderSelectFemaleIncident"))).click();
        logger.info("The victim data were properly entered");


        waitHelper.hardWait(1000);
        WebElement tab1 = driver.findElement(getManualAddressIntroductionTab());

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].scrollIntoView();", tab1);

        driver.findElement(getManualAddressIntroductionTab()).click();

        //enter address

        waitHelper.hardWait(1000);
        driver.findElement(By.xpath(propertyRead.getProperty("x_cityBoxArrow"))).click();
        driver.findElement(By.xpath(propertyRead.getProperty("x_cityBoxInput"))).sendKeys("Alba");
        driver.findElement(By.xpath(propertyRead.getProperty("x_citySelect"))).click();
        waitHelper.hardWait(1000);
        driver.findElement(By.xpath(propertyRead.getProperty("x_localityIncidentArrow"))).click();
        driver.findElement(By.xpath(propertyRead.getProperty("x_localityIncidentSelection"))).click();


        logger.info("The city was selected");

        driver.findElement(By.xpath(propertyRead.getProperty("x_streetBoxInput"))).sendKeys("Aviatorilor");
        driver.findElement(By.xpath(propertyRead.getProperty("x_streetNumberBoxInput"))).sendKeys("57");

        logger.info("The address is properly entered");

        waitHelper.hardWait(1000);

        driver.findElement(getManualAddressIntroductionTab()).click();

        //add victim details

        waitHelper.hardWait(1000);
        driver.findElement(getVictimsTabIncident()).click();
        driver.findElement(By.xpath(propertyRead.getProperty("x_addVictimTabIncident"))).click();
        waitHelper.hardWait(1000);
        driver.findElement(By.xpath(propertyRead.getProperty("x_victimGivenNameInputIncident"))).sendKeys("Pedro");
        //driver.findElement(By.xpath(reader.getProperty("x_victimFamilyNameInput"))).sendKeys("Mueller");
        driver.findElement(By.xpath(propertyRead.getProperty("x_severityBoxArrowIncident"))).click();
        waitHelper.hardWait(500);
        driver.findElement(By.xpath(propertyRead.getProperty("x_slightInjurySelectIncident"))).click();
        waitHelper.hardWait(1000);

        logger.info("The victim data were properly entered");
        driver.findElement(getKeyDataTabIncident()).click();
        waitHelper.hardWait(1000);

        WebElement tab2 = driver.findElement(By.xpath(propertyRead.getProperty("x_whatTab")));

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].scrollIntoView();", tab2);

        waitHelper.hardWait(1000);
        driver.findElement(By.xpath(propertyRead.getProperty("x_searchKey"))).click();

        driver.findElement(By.xpath(propertyRead.getProperty("x_testKey"))).click();
        //driver.findElement(By.xpath(reader.getProperty("x_selectKeyButton"))).click();

        driver.findElement(By.xpath(propertyRead.getProperty("x_acceptProtocolButton"))).click();

        logger.info("The incident case file is saved");



    }

    public static void getIncidentOpenCaseFile() {
        driver.findElement(By.xpath(propertyRead.getProperty("x_incidentCaseFile"))).click();
        waitHelper.hardWait(1000);

        logger.info("The incident case file is opened");


    }

    public static void getAssignResourceToIncident() {

        //waitHelper.waitForElementVisible(By.xpath(propertyRead.getProperty("x_actionsTab")),10,2);
        waitHelper.hardWait(1000);
        //driver.findElement(By.xpath(propertyRead.getProperty("x_actionsTab"))).click();
        driver.findElement(By.linkText("Actions")).click();
        driver.findElement(By.xpath(propertyRead.getProperty("x_ambulanceIcon"))).click();
        waitHelper.hardWait(500);
        driver.findElement(By.xpath(propertyRead.getProperty("x_closeButton"))).click();
        Actions actions = new Actions(driver);
        WebElement ambulanceOption = driver.findElement(By.xpath(propertyRead.getProperty("x_ambulanceOption")));
        actions.contextClick(ambulanceOption).perform();
        //waitHelper.hardWait(1000);
        //Actions action = new Actions(driver);
        WebElement assignAmbulanceOption = driver.findElement(By.xpath(propertyRead.getProperty("x_assignAmbResource")));
        actions.click(assignAmbulanceOption).perform();
        //driver.findElement(By.xpath(propertyRead.getProperty("x_assignAmbResource"))).click();

        logger.info("An ambulance resource was assigned");

        driver.findElement(By.xpath(propertyRead.getProperty("x_fireWorkIcon"))).click();
        Actions actionsP = new Actions(driver);
        WebElement fireworksOption = driver.findElement(By.xpath(propertyRead.getProperty("x_fireworksOption")));
        actionsP.contextClick(fireworksOption).perform();
        driver.findElement(By.xpath(propertyRead.getProperty("x_assignFireResource"))).click();

        logger.info("A fire and rescue resource was assigned");

        Actions actionsStatusChange = new Actions(driver);
        WebElement resourceStatus = driver.findElement(By.xpath(propertyRead.getProperty("x_resourceStatus")));
        actionsStatusChange.contextClick(resourceStatus).perform();
        driver.findElement(By.xpath(propertyRead.getProperty("x_resourceNextStatus"))).click();


    }

    public static void getLinkIncidentToIncident() {
        Actions actions = new Actions(driver);
        WebElement incidentSelectionFromList = driver.findElement(By.xpath(propertyRead.getProperty("x_incidentSelectionFromList")));
        actions.contextClick(incidentSelectionFromList).perform();
        driver.findElement(By.xpath(propertyRead.getProperty("x_linkIncidentToIncident"))).click();
        waitHelper.hardWait(1000);
        Actions actions1 = new Actions(driver);
        WebElement incidentReadyForAssociation = driver.findElement(By.xpath(propertyRead.getProperty("x_incidentReadyForAssociation")));
        actions1.contextClick(incidentReadyForAssociation).perform();
        driver.findElement(By.xpath(propertyRead.getProperty("x_associateIncident"))).click();
        //driver.findElement(By.xpath(reader.getProperty("x_incidentReadyForAssociation"))).click();
        waitHelper.hardWait(1000);
        driver.findElement(By.xpath(propertyRead.getProperty("x_confirmationLinkButton"))).click();

    }

}

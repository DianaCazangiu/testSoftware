package com.gemma.pageObject;

import com.gemma.utils.waitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Properties;
import java.util.Random;

import static com.gemma.utils.PropertyFileReader.getPropertyFile;


public class callPage extends baseClass{

    private static Logger logger = LoggerFactory.getLogger(callPage.class);

    static Properties propertyRead;

    static {
        try {
            propertyRead = getPropertyFile("generalLocators.properties");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static By getAccessUserMenu() {
        return By.xpath(propertyRead.getProperty("x_arrowButton"));
    }
    public static By getCreateMenu() {
        return By.xpath(propertyRead.getProperty("x_createButton"));
    }
    public static By getKeyDataTab() {
        return By.xpath(propertyRead.getProperty("x_keyDataTab"));
    }

    public static By getMoreInfoTab() {
        return By.xpath(propertyRead.getProperty("x_moreInfoTab"));
    }
    public static By getManualAddressIntroductionTab() {
        return By.xpath(propertyRead.getProperty("x_manualAddressIntroductionTab"));
    }
    public static By getVictimsTab() {
        return By.xpath(propertyRead.getProperty("x_victimsTab"));
    }

    public static By getAddVictimsTab() {
        return By.xpath(propertyRead.getProperty("x_addVictimTab"));
    }

    public static By getGeneralTab() {
        return By.xpath(propertyRead.getProperty("x_generalTab"));
    }



    public static void getCall() {
        waitHelper.hardWait(5000);
        driver.findElement(getAccessUserMenu()).click();
        waitHelper.hardWait(4000);
        Actions actTheme = new Actions(driver);
        WebElement callCreate = driver.findElement(getCreateMenu());
        actTheme.moveToElement(callCreate).perform();
        waitHelper.hardWait(4000);
        driver.findElement(By.xpath(propertyRead.getProperty("x_callButton"))).click();
        waitHelper.hardWait(5000);
        logger.info("The call file is opened");

    }

    public static void getVictimData(String data) {

        switch(data) {
            case "victim1":
                //select priority
                waitHelper.hardWait(1000);
                driver.findElement(By.xpath(propertyRead.getProperty("x_priorityArrow"))).click();
                waitHelper.hardWait(500);
                driver.findElement(By.xpath(propertyRead.getProperty("x_lowPriority"))).click();
                logger.info("Priority was selected");

                //select call type
                driver.findElement(By.xpath(propertyRead.getProperty("x_callTypeArrow"))).click();
                waitHelper.hardWait(1000);
                //waitHelper.waitForElementVisible(By.xpath(propertyRead.getProperty("x_callTypeButton")),5,5);
                driver.findElement(By.xpath(propertyRead.getProperty("x_callTypeButton"))).click();

                //enter phone number
                driver.findElement(By.xpath(propertyRead.getProperty("x_phoneNumberBoxInput"))).sendKeys("0723670123");

                logger.info("Phone number was correctly entered");

                //enter name
                waitHelper.hardWait(2000);
                driver.findElement(getKeyDataTab()).click();
                //driver.findElement(getMoreInfoTab()).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_givenNameBoxInput"))).sendKeys("Paul");
                driver.findElement(By.xpath(propertyRead.getProperty("x_familyNameBoxInput"))).sendKeys("Georgescu");
                driver.findElement(By.xpath(propertyRead.getProperty("x_ageBoxInput"))).sendKeys("74");
                driver.findElement(By.xpath(propertyRead.getProperty("x_ageUnitBoxArrow"))).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_ageUnitSelect"))).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_genderBoxArrow"))).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_genderSelect"))).click();

                logger.info("The victim data were properly entered");

                waitHelper.hardWait(1000);
                WebElement tab = driver.findElement(getManualAddressIntroductionTab());

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView();", tab);

                driver.findElement(getManualAddressIntroductionTab()).click();

                //enter address

                driver.findElement(By.xpath(propertyRead.getProperty("x_cityBoxArrow"))).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_cityBoxInput"))).sendKeys("Alba");
                driver.findElement(By.xpath(propertyRead.getProperty("x_citySelect"))).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_localitySelectorCall"))).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_localityBoxInput"))).sendKeys("Abrud");
                driver.findElement(By.xpath(propertyRead.getProperty("x_localityOption"))).click();

                logger.info("The city was selected");

                driver.findElement(By.xpath(propertyRead.getProperty("x_streetBoxInput"))).sendKeys("Independentei");
                driver.findElement(By.xpath(propertyRead.getProperty("x_streetNumberBoxInput"))).sendKeys("5");

                logger.info("The address is properly entered");


                //add victim
                driver.findElement(getVictimsTab()).click();
                driver.findElement(getAddVictimsTab()).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_victimGivenNameInput"))).sendKeys("Raymond");
                driver.findElement(By.xpath(propertyRead.getProperty("x_victimFamilyNameInput"))).sendKeys("Georgescu");
                driver.findElement(By.xpath(propertyRead.getProperty("x_severityBoxArrow"))).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_slightInjurySelect"))).click();
                waitHelper.hardWait(1000);

                logger.info("The call file is saved");
                break;

            case "victim2":

                //select priority

                waitHelper.hardWait(2000);
                driver.findElement(By.xpath(propertyRead.getProperty("x_priorityArrow"))).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_mediumPrioritySelect"))).click();
                logger.info("Priority was selected");

                //select call type
                driver.findElement(By.xpath(propertyRead.getProperty("x_callTypeArrow"))).click();
                waitHelper.hardWait(1000);
                driver.findElement(By.xpath(propertyRead.getProperty("x_callTypeButton"))).click();

                //enter phone number
                driver.findElement(By.xpath(propertyRead.getProperty("x_phoneNumberBoxInput"))).sendKeys("0784556002");

                logger.info("Phone number was correctly entered");

                //enter name
                waitHelper.hardWait(2000);
                driver.findElement(getKeyDataTab()).click();
                //driver.findElement(getMoreInfoTab()).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_givenNameBoxInput"))).sendKeys("Mariana");
                driver.findElement(By.xpath(propertyRead.getProperty("x_familyNameBoxInput"))).sendKeys("Ionescu");
                driver.findElement(By.xpath(propertyRead.getProperty("x_ageBoxInput"))).sendKeys("35");
                driver.findElement(By.xpath(propertyRead.getProperty("x_ageUnitBoxArrow"))).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_ageUnitSelect"))).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_genderBoxArrow"))).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_genderFemaleSelect"))).click();
                logger.info("The victim data were properly entered");


                waitHelper.hardWait(1000);
                WebElement tab1 = driver.findElement(getManualAddressIntroductionTab());

                JavascriptExecutor js1 = (JavascriptExecutor) driver;
                js1.executeScript("arguments[0].scrollIntoView();", tab1);

                driver.findElement(getManualAddressIntroductionTab()).click();

                //enter address

                driver.findElement(By.xpath(propertyRead.getProperty("x_cityBoxArrow"))).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_cityBoxInput"))).sendKeys("Brasov");
                driver.findElement(By.xpath(propertyRead.getProperty("x_citySelect"))).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_localitySelectorCall"))).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_localityBoxInput"))).sendKeys("Brasov");
                driver.findElement(By.xpath(propertyRead.getProperty("x_localityOption"))).click();

                logger.info("The city was selected");

                driver.findElement(By.xpath(propertyRead.getProperty("x_streetBoxInput"))).sendKeys("Carpatilor");
                driver.findElement(By.xpath(propertyRead.getProperty("x_streetNumberBoxInput"))).sendKeys("20");

                logger.info("The address is properly entered");


                //add victim
                driver.findElement(getVictimsTab()).click();
                driver.findElement(getAddVictimsTab()).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_victimGivenNameInput"))).sendKeys("Silviu");
                driver.findElement(By.xpath(propertyRead.getProperty("x_victimFamilyNameInput"))).sendKeys("Ionescu");
                driver.findElement(By.xpath(propertyRead.getProperty("x_severityBoxArrow"))).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_uninjuredOption"))).click();
                waitHelper.hardWait(1000);

                logger.info("The call file is saved");
                break;

            case "victim3":

                //select priority
                waitHelper.hardWait(2000);
                driver.findElement(By.xpath(propertyRead.getProperty("x_priorityArrow"))).click();
                waitHelper.hardWait(500);
                driver.findElement(By.xpath(propertyRead.getProperty("x_highPrioritySelect"))).click();
                logger.info("Priority was selected");

                //select call type
                driver.findElement(By.xpath(propertyRead.getProperty("x_callTypeArrow"))).click();
                waitHelper.hardWait(500);
                driver.findElement(By.xpath(propertyRead.getProperty("x_llamadaSalienteCallType"))).click();

                //enter phone number
                driver.findElement(By.xpath(propertyRead.getProperty("x_phoneNumberBoxInput"))).sendKeys("0743689213");

                logger.info("Phone number was correctly entered");

                //enter name
                waitHelper.hardWait(2000);
                driver.findElement(getKeyDataTab()).click();

                waitHelper.hardWait(1000);
                WebElement tabWho = driver.findElement(By.xpath(propertyRead.getProperty("x_WhoTab")));

                JavascriptExecutor js3 = (JavascriptExecutor) driver;
                //js.executeScript(Script,Arguments);
                js3.executeScript("arguments[0].scrollIntoView();", tabWho);

                //driver.findElement(By.xpath(propertyRead.getProperty("x_DataTab"))).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_givenNameBoxInput"))).sendKeys("Oliver");
                driver.findElement(By.xpath(propertyRead.getProperty("x_familyNameBoxInput"))).sendKeys("Weimer");
                driver.findElement(By.xpath(propertyRead.getProperty("x_ageBoxInput"))).sendKeys("58");
                driver.findElement(By.xpath(propertyRead.getProperty("x_ageUnitBoxArrow"))).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_ageUnitSelect"))).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_genderBoxArrow"))).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_genderSelect"))).click();
                logger.info("The victim data were properly entered");


                waitHelper.hardWait(1000);
                WebElement tab2 = driver.findElement(getManualAddressIntroductionTab());

                JavascriptExecutor js2 = (JavascriptExecutor) driver;
                //js.executeScript(Script,Arguments);
                js2.executeScript("arguments[0].scrollIntoView();", tab2);

                driver.findElement(getManualAddressIntroductionTab()).click();

                //enter address

                driver.findElement(By.xpath(propertyRead.getProperty("x_cityBoxArrow"))).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_cityBoxInput"))).sendKeys("Alba");
                driver.findElement(By.xpath(propertyRead.getProperty("x_citySelect"))).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_localitySelectorCall"))).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_localityBoxInput"))).sendKeys("Abrud");
                driver.findElement(By.xpath(propertyRead.getProperty("x_localityOption"))).click();

                logger.info("The city was selected");

                driver.findElement(By.xpath(propertyRead.getProperty("x_streetBoxInput"))).sendKeys("Iuliu Maniu");
                driver.findElement(By.xpath(propertyRead.getProperty("x_streetNumberBoxInput"))).sendKeys("35");

                logger.info("The address is properly entered");


                //add victim
                waitHelper.hardWait(1000);
                driver.findElement(getVictimsTab()).click();
                driver.findElement(getAddVictimsTab()).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_victimGivenNameInput"))).sendKeys("Helga");
                driver.findElement(By.xpath(propertyRead.getProperty("x_victimFamilyNameInput"))).sendKeys("Mueller");
                driver.findElement(By.xpath(propertyRead.getProperty("x_severityBoxArrow"))).click();
                driver.findElement(By.xpath(propertyRead.getProperty("x_severeWoundedInjury"))).click();
                waitHelper.hardWait(1000);

                logger.info("The call file is saved");

        }


    }

    public static void getCallOpenCaseFile() {
        driver.findElement(By.xpath(propertyRead.getProperty("x_callCaseFile"))).click();
        waitHelper.hardWait(1000);

        logger.info("The call case file is opened");


    }

    public static void getAddClassifToCall() {

        driver.findElement(getKeyDataTab()).click();
        //driver.findElement(getMoreInfoTab()).click();
        //driver.findElement(By.xpath(reader.getProperty("x_closeBottomButton"))).click();
        waitHelper.hardWait(2000);
        WebElement tab2 = driver.findElement(By.xpath(propertyRead.getProperty("x_whatTabCall")));

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].scrollIntoView();", tab2);

        waitHelper.hardWait(1000);

        driver.findElement(By.xpath(propertyRead.getProperty("x_classificationArrow"))).click();
        driver.findElement(By.xpath(propertyRead.getProperty("x_ClassificationCallOption"))).click();
        driver.findElement(By.xpath(propertyRead.getProperty("x_acceptProtocolCall"))).click();

        logger.info("The classification was properly added");

    }

    public static void getCallsList() {
        waitHelper.hardWait(1000);
        driver.findElement(By.xpath(propertyRead.getProperty("x_allCallsList"))).click();
        waitHelper.hardWait(1000);
        driver.findElement(By.xpath(propertyRead.getProperty("x_calendarCallSelection"))).click();
        driver.findElement(By.xpath(propertyRead.getProperty("x_clearDateButton"))).click();

        driver.findElement(By.xpath(propertyRead.getProperty("x_priorityBoxAllList"))).click();
        driver.findElement(By.xpath(propertyRead.getProperty("x_mediumPriorityCheckBox"))).click();
        driver.findElement(By.xpath(propertyRead.getProperty("x_priorityBox"))).click();



    }

    public static void getFollowExistentCall() {
        Actions actions = new Actions(driver);
        WebElement mediumPriorityCall = driver.findElement(By.xpath(propertyRead.getProperty("x_mediumPriorityCall")));
        actions.contextClick(mediumPriorityCall).perform();
        driver.findElement(By.xpath(propertyRead.getProperty("x_followButton"))).click();
    }

    public static int getPhoneNumber() {
        Random objGenerator = new Random();
        //int phoneNumber = objGenerator.nextInt(90000000);
        int finalPhoneNumber = Integer.parseInt("07" + objGenerator.nextInt(90000000));
        System.out.println("Random No : " + finalPhoneNumber);
        return finalPhoneNumber;
    }








}

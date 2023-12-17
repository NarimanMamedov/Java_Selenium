package seleniumTests;

import base.BaseTest;
import gui.models.ContactInformationTestData;
import gui.steps.ContactDetailsSteps;
import gui.utils.JsonFileReader;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UpdateContactInformationTest extends BaseTest {
    private static final Logger LOG = Logger.getLogger(String.valueOf(UpdateContactInformationTest.class));
    private ContactDetailsSteps contactDetailsSteps;
    private ContactInformationTestData testData = JsonFileReader.readJsonFile("src/test/java/configFiles/ContactInformationTestData.json", ContactInformationTestData.class);

    @Test
    public void checkThatNewContactDataSaved() throws InterruptedException {
        LOG.info("Start Update Contact Information Test");
        // -------  Arrange -------
        contactDetailsSteps = new ContactDetailsSteps();

        // --------  Act -------

        contactDetailsSteps.openContactDetailsPage(testData.getUserName(), testData.getUserPassword());
        LOG.info("Contact Details Page is opened");
        contactDetailsSteps.setStreet2TextFieldValue(testData.getStreet2Value());
        contactDetailsSteps.setStateProvinceTextFieldValue(testData.getStateProvinceValue());
        contactDetailsSteps.setCountryInDropdown(testData.getCountry());
        contactDetailsSteps.setHomeTextFieldValue(testData.getHomeValue());
        LOG.info("Test Data from Config file is added");
        contactDetailsSteps.saveChangesAndRefreshPage();
        LOG.info("Data was Saved and page was refreshed");

//            JavascriptExecutor j = (JavascriptExecutor)driver;
//            String fieldStreet2Value = (String) j.executeScript("arguments[0].value='';", fieldStreet2);

        // -------  Assert -------
        Assertions.assertEquals(testData.getStreet2Value(), contactDetailsSteps.getFieldStreet2Value());
        LOG.info("assertEquals(testData.getStreet2Value(), contactDetailsSteps.getFieldStreet2Value()), is Successful - "
                + testData.getStreet2Value().equals(contactDetailsSteps.getFieldStreet2Value()));
        Assertions.assertEquals(testData.getStateProvinceValue(), contactDetailsSteps.getFieldStateProvinceValue());
        LOG.info("assertEquals(testData.getStateProvinceValue(), contactDetailsSteps.getFieldStateProvinceValue()), is Successful - "
                + testData.getStateProvinceValue().equals(contactDetailsSteps.getFieldStateProvinceValue()));
        Assertions.assertEquals(testData.getHomeValue(), contactDetailsSteps.getFieldHomeValue());
        LOG.info("assertEquals(testData.getHomeValue(), contactDetailsSteps.getFieldHomeValue()), is Successful - "
                + testData.getHomeValue().equals(contactDetailsSteps.getFieldHomeValue()));
    }
}

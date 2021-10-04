package maximo.stepdefinations;

import org.testng.Assert;
import cucumber.api.java.en.*;
import maximo.basepage.SupperClass;
import maximo.elements.page.MasterPageFactoryPage;
import maximo.utility.CommonUtility;

public class MaximoStepDef extends SupperClass {

	MasterPageFactoryPage pf;

	@Given("^user alredy in home page & verify the Page Title is \"([^\"]*)\"$")
	public void user_alredy_in_home_page_verify_the_Page_Title_is(String title) {

		pf = new MasterPageFactoryPage();

		logger.info("******** user enter a valid username, password and click the Sign in button *********");
		CommonUtility.isElementPresent(pf.getMaxLoginApplication(), driver, 20);
		pf.getMaxLoginApplication();

		Assert.assertEquals(title, driver.getTitle());
		System.out.println("My page title is: " + driver.getTitle());

	}

	@When("^user navigates to location page from go to button$")
	public void user_navigates_to_location_page_from_go_to_button() {
		logger.info("******** user navigates to location page from go to button *********");

		CommonUtility.getExplicitWait(pf.getMaxSelectSearchBox(), driver, 30);
		CommonUtility.highLighterMethod(driver, pf.getMaxSelectSearchBox());

		pf.getMaxSelectSearchBox().sendKeys(prop.getProperty("searchKey"));

		CommonUtility.getExplicitWait(pf.getMaxSearchLocation(), driver, 30);
		CommonUtility.highLighterMethod(driver, pf.getMaxSearchLocation());

		pf.getMaxSearchLocation().click();
	}

	@When("^user navigate to Common Actions and click on create new location button$")
	public void user_navigate_to_Common_Actions_and_click_on_create_new_location_button() {
		logger.info("******** user navigate to Common Actions and click on create new location button *********");
		CommonUtility.getExplicitWait(pf.getMaxClcikOnCreateLocation(), driver, 30);
		CommonUtility.highLighterMethod(driver, pf.getMaxClcikOnCreateLocation());
		pf.getMaxClcikOnCreateLocation().click();
	}

	@When("^user type and capture a new location name as \"([^\"]*)\" into location field$")
	public void user_type_and_capture_a_new_location_name_as_into_location_field(String location) {
		logger.info("******** user type and capture a new location name as Location into location field *********");
		CommonUtility.getExplicitWait(pf.getMaxEnterLocationName(), driver, 30);
		CommonUtility.highLighterMethod(driver, pf.getMaxEnterLocationName());
		pf.getMaxEnterLocationName().sendKeys(location);
	}

	@When("^user enter \"([^\"]*)\" into the Location description field$")
	public void user_enter_into_the_Location_description_field(String description) {
		logger.info("******** user enter text into the Location description field *********");
		CommonUtility.getExplicitWait(pf.getMaxEnterDescription(), driver, 30);
		pf.getMaxEnterDescription().sendKeys(description);
	}

	@When("^user click on magnifying glass icon adjacent to Type text box under Location Field$")
	public void user_click_on_magnifying_glass_icon_adjacent_to_Type_text_box_under_Location_Field() {
		logger.info(
				"******** user click on magnifying glass icon adjacent to Type text box under Location Field *********");
		CommonUtility.getExplicitWait(pf.getMaxclickOnMagnifying(), driver, 30);
		pf.getMaxclickOnMagnifying().click();

	}

	@Then("^user select \"([^\"]*)\" from the Type dialog box for Location$")
	public void user_select_from_the_Type_dialog_box_for_Location(String actual) {
		logger.info("******** user select operating from the Type dialog box for Location *********");
		CommonUtility.getExplicitWait(pf.getMaxSelectOperatingLink(), driver, 30);
		String expected = pf.getMaxSelectOperatingLink().getText();
		Assert.assertEquals(actual, expected);
		pf.getMaxSelectOperatingLink().click();

	}

	@Then("^user left mouse click on disk icon for Save Location within Maximo tool bar$")
	public void user_left_mouse_click_on_disk_icon_for_Save_Location_within_Maximo_tool_bar() {
		logger.info("******** user left mouse click on disk icon for Save Location within Maximo tool bar *********");
		CommonUtility.getExplicitWait(pf.getMaxClickOnSaveButton(), driver, 30);
		pf.getMaxClickOnSaveButton().click();
	}

	@Then("^user verify \"([^\"]*)\" message appears$")
	public void user_verify_message_appears(String successMassage) {
		logger.info("******** user verify Massage message appears *********");
		if (driver.getPageSource().contains(successMassage)) {
		} else {
			driver.getPageSource().contains("Login was unsuccessful.");
			System.out.println("Location alredy exists");
			Assert.assertTrue(false);

		}

	}

}
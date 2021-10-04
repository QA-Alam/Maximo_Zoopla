package maximo.stepdefinations;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import cucumber.api.java.en.*;
import maximo.basepage.SupperClass;
import maximo.elements.page.MasterPageFactoryPage;
import maximo.utility.CommonUtility;

public class ZooplaStepDef extends SupperClass {
	MasterPageFactoryPage pf;
	String clcikProperty;

	@Given("^Users able to verify successfully login & verify the homepage title as \"([^\"]*)\"$")
	public void users_able_to_verify_successfully_login_verify_the_homepage_title_as(String title) {

		pf = new MasterPageFactoryPage();
		
		
		pf.getZooplaLoginApplication();
		Assert.assertEquals(title, driver.getTitle());

	}

	@When("^Users can mouse hover left corner top on the page for sale under the for sale & select UK property for sale$")
	public void users_can_mouse_hover_left_corner_top_on_the_page_for_sale_under_the_for_sale_select_UK_property_for_sale() {
		CommonUtility.getExplicitWait(pf.getZooplaZooplaForSale(), driver, 30);
		CommonUtility.highLighterMethod(driver, pf.getZooplaZooplaForSale());
		pf.getZooplaZooplaForSale().click();

	}

	@When("^Users able to  enter location as  \"([^\"]*)\" in text box$")
	public void users_able_to_enter_location_as_in_text_box(String location) {
		CommonUtility.getExplicitWait(pf.getZooplaZooplaTextBox(), driver, 30);
		CommonUtility.highLighterMethod(driver, pf.getZooplaZooplaTextBox());
		pf.getZooplaZooplaTextBox().sendKeys(location);
		pf.getZooplaZooplaTextBox().sendKeys(Keys.ENTER);

	}

	@When("^Users can search the property & verify the price$")
	public void users_can_search_the_property_verify_the_price() {
		// CommonUtility.waitforElements(pf.getPropertyPrice(), driver);
		pf.getPropertyPrice();
	}

	@When("^Users able to print all property value/price in consule and click on thard property$")
	public void users_able_to_print_all_property_value_price_in_consule_and_click_on_thard_property() {
		pf.selectProperties();

	}

	@When("^Users click on the fifth number of property & print out the property address$")
	public void users_click_on_the_fifth_number_of_property_print_out_the_property_address() {
		CommonUtility.getExplicitWait(pf.getZooplaVerifyDetails(), driver, 30);
		CommonUtility.highLighterMethod(driver, pf.getZooplaVerifyDetails());
		System.out.println("property details : " + pf.getZooplaVerifyDetails().getText());
	}

	@Then("^Users can Verify the price of the property$")
	public void users_can_Verify_the_price_of_the_property() {
		CommonUtility.getExplicitWait(pf.getClickingPrice(), driver, 30);
		CommonUtility.highLighterMethod(driver, pf.getClickingPrice());
		String expected = pf.getClickingPrice().getText();
		Assert.assertEquals(MasterPageFactoryPage.actual, expected);
		System.out.println("User selecting property price is : " + pf.getClickingPrice().getText());

	}
}

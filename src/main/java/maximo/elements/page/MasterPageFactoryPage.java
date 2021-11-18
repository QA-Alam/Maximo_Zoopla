package maximo.elements.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import maximo.basepage.SupperClass;
import maximo.utility.CommonUtility;

public class MasterPageFactoryPage extends SupperClass {
	public static String actual;

	public MasterPageFactoryPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='username']")
	@CacheLookup
	private WebElement MaxuserName;

	public WebElement getMaxEnterUserName() {
		return MaxuserName;
	}

	@FindBy(xpath = "//*[@id='password']")
	@CacheLookup
	private WebElement Maxpassword;

	public WebElement getMaxEnterPassword() {
		return Maxpassword;
	}

	@FindBy(xpath = "//*[@id='loginbutton']")
	@CacheLookup
	private WebElement MaxsigninBTN;

	public WebElement getMaxClickingSigninBTN() {
		return MaxsigninBTN;
	}

	@FindBy(id = "nav_search_fld")
	@CacheLookup
	private WebElement MaxselectSearchBox;

	public WebElement getMaxSelectSearchBox() {
		return MaxselectSearchBox;
	}

	@FindBy(id = "nav_search_fld_menu_navSearchItemm7f8f3e49_ns_menu_ASSET_MODULE_sub_changeapp_LOCATION_a_a")
	@CacheLookup
	private WebElement MaxselectSearchLocation;

	public WebElement getMaxSearchLocation() {
		return MaxselectSearchLocation;
	}

	@FindBy(xpath = "//*[text()='New Location']")
	@CacheLookup
	private WebElement MaxcreateLocation;

	public WebElement getMaxClcikOnCreateLocation() {
		return MaxcreateLocation;
	}

	@FindBy(xpath = "//*[@id='m8ee1358-tb']")
	@CacheLookup
	private WebElement MaxenterLocationName;

	public WebElement getMaxEnterLocationName() {
		return MaxenterLocationName;
	}

	@FindBy(xpath = "//*[@id='m8ee1358-tb2']")
	@CacheLookup
	private WebElement Maxdescription;

	public WebElement getMaxEnterDescription() {
		return Maxdescription;
	}

	@FindBy(xpath = "//*[@id='m91e742e2-img']")
	@CacheLookup
	private WebElement MaxclickOnMagnifying;

	public WebElement getMaxclickOnMagnifying() {
		return MaxclickOnMagnifying;
	}

	@FindBy(xpath = "//*[@id='lookup_page1_tdrow_[C:0]_ttxt-lb[R:3]']")
	@CacheLookup
	private WebElement MaxselectOperatingLink;

	public WebElement getMaxSelectOperatingLink() {
		return MaxselectOperatingLink;
	}

	@FindBy(xpath = "//*[@id='md86fe08f_ns_menu_SAVE_OPTION_a_tnode']")
	@CacheLookup
	private WebElement MaxclickOnSaveButton;

	public WebElement getMaxClickOnSaveButton() {
		return MaxclickOnSaveButton;
	}

	public WebElement getMaxLoginApplication() {
		WebElement login = null;
		try {
			MaxuserName.sendKeys(prop.getProperty("MaxuserName"));
			CommonUtility.highLighterMethod(driver, MaxuserName);
			Thread.sleep(3000);
			CommonUtility.highLighterMethod(driver, Maxpassword);
			Maxpassword.sendKeys(prop.getProperty("MaxtextPassword"));
			Thread.sleep(3000);
			CommonUtility.highLighterMethod(driver, MaxsigninBTN);
			MaxsigninBTN.click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return login;
	}
//############################## Below Zoopla Elements##########################

	@FindBy(xpath = "//*[@id='input-email-address']")
	@CacheLookup
	private WebElement ZooplauserName;

	public WebElement getZooplaEnterUserName() {
		return ZooplauserName;
	}

	@FindBy(xpath = "//*[@id='input-password']")
	@CacheLookup
	private WebElement Zooplapassword;

	public WebElement getZooplaEnterPassword() {
		return Zooplapassword;
	}

	@FindBy(xpath = "(//*[text()='Sign in'])[5]")
	@CacheLookup
	private WebElement ZooplasigninBTN;

	public WebElement getZooplaClickingSigninBTN() {
		return ZooplasigninBTN;
	}

	@FindBy(xpath = "(//*[text()='For sale'])[1]")
	@CacheLookup
	private WebElement ZooplaForSale;

	public WebElement getZooplaZooplaForSale() {
		return ZooplaForSale;
	}

	@FindBy(xpath = "(//*[text()='Sign in'])[2]")
	@CacheLookup
	private WebElement ZooplaclickOnSignButton;

	public WebElement getZooplaclickOnSignButton() {
		return ZooplaclickOnSignButton;
	}

	@FindBy(xpath = "//*[@id='search-input-location']")
	@CacheLookup
	private WebElement ZooplaTextBox;

	public WebElement getZooplaZooplaTextBox() {
		return ZooplaTextBox;
	}

	@FindBy(xpath = "//*[@id='search-input-location']")
	@CacheLookup
	private WebElement ZooplaSearchButton;

	public WebElement getZooplaSearchButton() {
		return ZooplaSearchButton;
	}

	@FindBy(xpath = "//*[@class='css-1or8lzn-BodyContainer ep4jli7']")
	@CacheLookup
	private WebElement ZooplaVerifyDetails;

	public WebElement getZooplaVerifyDetails() {
		return ZooplaVerifyDetails;
	}

	@FindBy(xpath = "//*[@data-testid='price']")
	@CacheLookup
	private WebElement price;

	public WebElement getClickingPrice() {
		return price;
	}

	public WebElement getPropertyPrice() {
		WebElement ele = null;
		List<WebElement> price = driver.findElements(By.xpath("//*[@size='6']"));
		System.out.println("Total property counting Num : " + price.size());
		for (WebElement value : price) {
			String priceValue = value.getText(); // getAttribute(); getText();
			System.out.println("Property Price List : " + priceValue);
		}
		return ele;
		
	}

	public String selectProperties() {
		String store = "";
		List<WebElement> element = driver.findElements(By.xpath("//*[@size='6']"));
		for (int i = 0; i < element.size(); i++) {
			if (i > 5) {
				actual = element.get(i).getText();
				System.out.println("Selected property number is :: " + i);
				System.out.println("Selected property price is :: " + actual);
				element.get(i).click();
				break;
			}
		}
		return store;

	}

	@SuppressWarnings("unused")
	public String selectElementProperties() {
		String store = "";
		
		List<WebElement> element = driver.findElements(By.xpath("//*[@size='6']"));
		for (WebElement ele : element) {
			for (int i = 0; i < element.size(); i++) {
				if (ele.equals(i))
					if (i > 5)

						System.out.println("Selected property number : " + i + "is " + ele);
				element.get(element.size()).click();
				break;
			}
		}
		
		return store;

	}

	public WebElement getZooplaLoginApplication() {
		WebElement login = null;
		try {
			CommonUtility.highLighterMethod(driver, ZooplaclickOnSignButton);
			ZooplaclickOnSignButton.click();
			Thread.sleep(300);
			ZooplauserName.sendKeys(prop.getProperty("ZooplauserName"));
			CommonUtility.highLighterMethod(driver, ZooplauserName);
			Thread.sleep(300);
			CommonUtility.highLighterMethod(driver, Zooplapassword);
			Zooplapassword.sendKeys(prop.getProperty("ZooplatextPassword"));
			Thread.sleep(300);
			CommonUtility.highLighterMethod(driver, ZooplasigninBTN);
			ZooplasigninBTN.click();
			Thread.sleep(300);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return login;
	}

}
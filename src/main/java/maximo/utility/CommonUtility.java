package maximo.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import maximo.basepage.SupperClass;

public class CommonUtility extends SupperClass {

	static WebDriver driver;

	public static boolean isElementPresent(WebElement element, WebDriver driver, long timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	


	public static void highLighterMethod(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
}

	public static WebElement getExplicitWait(WebElement elem, WebDriver driver, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elem));
		return element;

	}

	public static void drawBorder(WebElement webelement, String color) {
		WebElement element_node = webelement;
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='3px solid " + color + "'", element_node);

	}

	public static String captureScreenShot(WebDriver driver, String ScreenShotName) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		String dateTime = dateFormat.format(date.getTime());
		String destination = currentDir + "//Screen Shot//" + dateTime + "//" + ScreenShotName + ".png";
		FileUtils.copyFile(source, new File(destination));
		System.out.println("Screen shot taken");
		return destination;
	}

	public static void WindowHandle() throws Throwable {
		String MainWindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			System.out.println(driver.getTitle());
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);

				// Closing the Child Window.
				driver.close();
			}
		}
		driver.switchTo().window(MainWindow);
	}

	public static Actions getAction() {
		Actions action = new Actions(driver);
		return action;
	}

	public static void customClick(WebDriver driver, By by) {
		try {
			(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(by));
			driver.findElement(by).click();
		} catch (StaleElementReferenceException sere) {
			// simply retry finding the element in the refreshed DOM
			driver.findElement(by).click();
		}
	}

	public static boolean retryingFindClick(By by) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.findElement(by).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public static void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	}

	public static void scrollView(String Element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}

	public static void jsClick(String locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", locator);
	}
	
	public static void acctionClick(By element ) {
		WebElement elementLocator = driver.findElement(element);
		Actions actions = new Actions(driver);
		actions.moveToElement(elementLocator).click().build().perform();
	}

	public static String threeDaysBefore() {
		String threeDaysBefore = "";
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, -3);
		Date before = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		threeDaysBefore = formatter.format(before);
		return threeDaysBefore;
	}

	public static WebElement getWebElClickable(String xpath, int waitSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait = new WebDriverWait(driver, waitSeconds);
		return wait.ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(xpath))));
	}





}

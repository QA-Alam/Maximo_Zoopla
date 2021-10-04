package maximo.basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SupperClass {

	public static Logger logger;
	public static WebDriver driver;
	public static Properties prop;


	public SupperClass() {
		logger = Logger.getLogger("Maximo"); // Added logger
		PropertyConfigurator.configure("Log4j.properties");// Added logger

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/maximo/config/Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initializationMaximo() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			logger.info("******** I am a chrome browser*********");
			System.setProperty("webdriver.chrome.driver", prop.getProperty("mac"));
			driver = new ChromeDriver();

		} else if (browserName.equals("browser")) {
			logger.info("******** I am a chrome browser*********");
			System.setProperty("webdriver.chrome.driver", prop.getProperty("windows"));
			driver = new ChromeDriver();

		} else if (browserName.equals("headless")) {
			logger.info("******** I am a headless mode chrome browser*********");
			String chromeDriverPath = prop.getProperty("mac");
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200",
					"--ignore-certificate-errors", "--silent");
			driver = new ChromeDriver(options);

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.geckodriver.driver", prop.getProperty("mac"));
			driver = new FirefoxDriver();
		}

		else if (browserName.equals("safari")) {
			driver = new SafariDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("MaxURL"));

	}

	public void initializationZoopla() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			logger.info("******** I am a chrome browser*********");
			System.setProperty("webdriver.chrome.driver", prop.getProperty("mac"));
			driver = new ChromeDriver();

		} else if (browserName.equals("browser")) {
			logger.info("******** I am a chrome browser*********");
			System.setProperty("webdriver.chrome.driver", prop.getProperty("windows"));
			driver = new ChromeDriver();

		} else if (browserName.equals("headless")) {
			logger.info("******** I am a headless mode chrome browser*********");
			String chromeDriverPath = prop.getProperty("mac");
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200",
					"--ignore-certificate-errors", "--silent");
			driver = new ChromeDriver(options);

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.geckodriver.driver", prop.getProperty("mac"));
			driver = new FirefoxDriver();
		}

		else if (browserName.equals("safari")) {
			driver = new SafariDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("ZooplaURL"));
		

	}

}
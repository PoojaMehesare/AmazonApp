package management;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseHRMCLass {
	public static Properties prop = new Properties();
	public static WebDriver driver;
	

	public BaseHRMCLass() {
		try {
			FileInputStream file = new FileInputStream(
					"C:\\Users\\win\\eclipse-workspace\\HRManagement\\src\\test\\java\\environmentvariables\\Configue.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException a) {

			a.printStackTrace();
		}
	}

	public void initiate() {
		String browsername = prop.getProperty("browser");
		if (browsername.equals("ChromeDriver")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("ChromeDriver")) {
			System.setProperty("webdriver.gecko.driver", "G:\\geckodriver-v0.33.0-win32");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(prop.getProperty("url"));

	}

	public static void Screenshots(String Filename) {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file,
					new File("C:\\Users\\win\\eclipse-workspace\\HRManagement\\src\\test\\java\\screenshot\\Screenshots"
							+ Filename + ".jpg"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}}


package testlayer;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import management.BaseHRMCLass;
import pompackage.PomLogin;
import testdata.Excelsheet;

public class LoginTest extends BaseHRMCLass {
	PomLogin log;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void initsetup() {
		initiate();
		log = new PomLogin();
		Screenshots("Login");
	}

	@Test(priority = 1)
	public void Title() {
		String actual = log.Display();

	}

	@DataProvider
	public Object[][] Details() {
		Object result[][] = Excelsheet.readdata("Sheet1");
		return result;
	}

	@Test(priority = 2, dataProvider = "Details")
	public void Login(String email, String password) throws InterruptedException  {
		
		log.ClickonSignin();
		log.typeemail(prop.getProperty("email"));
		log.ClickonContinue();
		Thread.sleep(5000);
		log.typepassword(prop.getProperty("password"));
		log.submit();
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}

package pompackage;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import management.BaseHRMCLass;

public class PomLogin extends BaseHRMCLass {

	@FindBy(id = "nav-link-accountList-nav-line-1")
	WebElement signin;
	@FindBy(id = "ap_email")
	WebElement email;
	@FindBy(id = "continue")
	WebElement continuebutton;
	@FindBy(id = "ap_password")
	WebElement password;
	@FindBy(id = "signInSubmit")
	WebElement submitbutton;

	public PomLogin() {

		PageFactory.initElements(driver, this);
	}

	public void mousehoveronHello() {
		Actions action = new Actions(driver);
		action.moveToElement(signin).build().perform();
	}

	public void ClickonSignin() {
		signin.click();
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
//			wait.until(ExpectedConditions.alertIsPresent());
//			Alert a = driver.switchTo().alert();
//			a.accept();
//		} catch (TimeoutException e) {
//			System.out.println("No alert present. Proceed with registration.");
//		}
	}

	public void typeemail(String Email) {

		email.sendKeys(Email);

	}

	public void ClickonContinue() {
		continuebutton.click();
	}

	public void typepassword(String Password) {
		password.sendKeys(Password);

	}

	public void submit() {
		password.click();

	}

	public String Display() {
		return driver.getTitle();

	}
}

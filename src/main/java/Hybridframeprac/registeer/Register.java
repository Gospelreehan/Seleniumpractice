package Hybridframeprac.registeer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register {
	WebDriver driver;

	// comstructor
	public Register(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// locator

	@FindBy(id = "input-firstname")
	WebElement fname;

	@FindBy(id = "input-lastname")
	WebElement lname;

	@FindBy(id = "input-email")
	WebElement email;

	@FindBy(id = "input-telephone")
	WebElement tele;

	@FindBy(id = "input-password")
	WebElement password;

	@FindBy(id = "input-confirm")
	WebElement confpass;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement terms;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement enter;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement cnfmmsg;

	// action
	public void firstname(String fnames) {
		fname.sendKeys(fnames);
	}

	public void lastname(String lnames) {
		lname.sendKeys(lnames);
	}

	public void email(String emails) {
		email.sendKeys(emails);
	}

	public void telephone(String telephones) {
		tele.sendKeys(telephones);
	}

	public void password(String pass) {
		password.sendKeys(pass);
	}

	public void confirmPassword(String pass) {
		confpass.sendKeys(pass);
	}

	public void agreeTerms() {
		terms.click();
	}

	public void clickContinue() {
		enter.click();
	}
	public String cnfmsg() {
		try{
		  	return cnfmmsg.getText();
		}
		catch (Exception e) {
			// TODO: handle exception
			return e.getMessage();		}
		
	}
}

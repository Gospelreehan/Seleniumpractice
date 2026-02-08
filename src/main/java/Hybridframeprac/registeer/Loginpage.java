package Hybridframeprac.registeer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;
public Loginpage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements( driver,this);
}
//locator
@FindBy(id="input-email")WebElement email;
@FindBy(id="input-password")WebElement pass;
@FindBy(xpath="//input[@value='Login']")WebElement Click;
//action
public void setemail(String emails) {
	email.sendKeys(emails);
}

public void setpass(String passs) {
	pass.sendKeys(passs);
}

public void clicks() {
	Click.click();
}

}

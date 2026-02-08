package Hybridframeprac.registeer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
WebDriver driver;
//comstructor
public Homepage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements( driver,this);
}
//locator
@FindBy(xpath = "//a[@title='My Account']")
WebElement home;
@FindBy(xpath = "//a[normalize-space()='Register']")
WebElement reg;
@FindBy(xpath = "//a[normalize-space()='Login']")
WebElement login;

//ACTION
public void clicks() {
	home.click();
	
}
public void ree() {
	reg.click();
	
}
public void log() {
	login.click();
	
}

}

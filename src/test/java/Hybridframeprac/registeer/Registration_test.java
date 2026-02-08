package Hybridframeprac.registeer;

import org.testng.Assert;
import org.testng.annotations.Test;

import reusable.Repetitive_values;

public class Registration_test extends Repetitive_values{
    

    @Test
    public void reg() throws InterruptedException {
    	hp.clicks();
    	hp.ree();
        // Fill in registration form
//    	String pass=getRandomnumber()+getRandomString();
        registerPage.firstname(getRandomString());
        registerPage.lastname(getRandomString());
        registerPage.email("reehan" + getRandomString()+ "@gmail.com"); // unique email
        registerPage.telephone(getRandomnumber());
        String pass=getRandomalphanumeric()+getRandomString(); 
        registerPage.password(pass);
        registerPage.confirmPassword(pass);
        registerPage.agreeTerms();
        registerPage.clickContinue();
        Thread.sleep(3000l);
        // Validate confirmation message
        String actualMsg = registerPage.cnfmsg();
        Assert.assertEquals(actualMsg, "Your Account Has Been Created!",
                "Registration confirmation message mismatch!");
    }
  
}

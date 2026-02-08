package Hybridframeprac.registeer;

import java.sql.Driver;

import org.testng.annotations.Test;

import reusable.Repetitive_values;

public class Login extends Repetitive_values {
	@Test
	public void login() {
		hp.clicks();
		hp.log();
		lp.setemail(prop.getProperty("email"));
		lp.setpass(prop.getProperty("pass"));
		lp.clicks();
		
	}

}

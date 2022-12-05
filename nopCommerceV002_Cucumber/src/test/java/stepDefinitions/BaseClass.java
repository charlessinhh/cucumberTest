package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addCust;

	// random alphanumeric generation
	public static String generteRandomString() {
		String generatedString = RandomStringUtils.randomAlphanumeric(10);
		return (generatedString);
	}

}

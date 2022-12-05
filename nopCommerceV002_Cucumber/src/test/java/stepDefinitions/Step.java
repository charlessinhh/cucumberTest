package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class Step extends BaseClass {

	@Given("User Launch chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers/chromedriver.exe");
		driver = new ChromeDriver();

		lp = new LoginPage(driver);
	}

	@When("User opens url {string}")
	public void user_opens_url(String string) {
		driver.get(string);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String mail, String pwd) throws InterruptedException {
		lp.setUserName(mail);
		lp.setPassword(pwd);
//		Thread.sleep(5000);
	}

	@When("Click on Login")
	public void click_on_login() {
		lp.clickLogin();
//		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}
//		Thread.sleep(5000);
//		Assert.assertEquals(title, driver.getTitle());
	}

	@When("User Click on Log Out button")
	public void user_click_on_log_out_button() throws InterruptedException {
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		Thread.sleep(5000);
		lp.clickLogOut();
	}

	@Then("Close the browser")
	public void close_the_browser() {
		driver.quit();
	}

	// customer feature step definitions

	@Then("User can View Dashboard")
	public void user_can_view_dashboard() {

		addCust = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}

	@When("User click on Customers menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickCustMenu();
	}

	@When("User click on Customers menu Item")
	public void user_click_on_customers_menu_item() {
		addCust.clickCustMenuList();
	}

	@When("User click on Add new button")
	public void user_click_on_add_new_button() throws InterruptedException {
		addCust.clickAddNew();
		Thread.sleep(2000);
	}

	@Then("user can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		String email = generteRandomString() + "@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("password123");
		addCust.setFirstName("charles");
		addCust.setLasttName("Singh");
		addCust.selectGender("Male");
		addCust.setDOB("04/08/1999");
		addCust.setCompanyName("Atos");
		addCust.checkTaxExempt("Yes");
		addCust.setAdminContent("This is test add customer");
	}

	@When("click on Save button")
	public void click_on_save_button() throws InterruptedException {
		addCust.saveCustomer();
		Thread.sleep(3000);
	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(msg));
	}

}

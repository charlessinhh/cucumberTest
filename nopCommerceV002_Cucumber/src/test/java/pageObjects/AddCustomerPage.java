package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	public WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	By custMenu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By custMenuList = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	By btnAddNewCust = By.xpath("//a[@class='btn btn-primary']");

	By txtEmail = By.xpath("//input[@id='Email']");
	By txtPassword = By.xpath("//input[@id='Password']");
	By txtFirstName = By.xpath("//input[@id='FirstName']");
	By txtLastName = By.xpath("//input[@id='LastName']");
	By rBtnMale = By.id("Gender_Male");
	By rBtnFemale = By.id("Gender_Female");
	By txtDoB = By.id("DateOfBirth");

	By txtCompany = By.id("Company");
	By checkTaxExempt = By.id("IsTaxExempt");

	By custRoles = By.xpath("(//div[@role='listbox'])[2]");
	By listItemAdmin = By.xpath("//li[@id='f84bf205-5e2f-418c-a7cd-26d679c15a90']");
	By listItemForum = By.xpath("//li[normalize-space()='Forum Moderators']");
	By listItemGuest = By.xpath("//li[normalize-space()='Guests']");
	By listItemReg = By.xpath("//li[normalize-space()='Registered']");
	By listItemVendor = By.xpath("//li[contains(text(),'Vendors')]");

	By adminContent = By.xpath("//textarea[@id='AdminComment']");

	By btnSaveCust = By.xpath("//button[@name='save']");

	// Actions
	public String getPageTitle() {
		return ldriver.getTitle();
	}

	public void clickCustMenu() {
		ldriver.findElement(custMenu).click();
	}

	public void clickCustMenuList() {
		ldriver.findElement(custMenuList).click();
	}

	public void clickAddNew() {
		ldriver.findElement(btnAddNewCust).click();
	}

	public void setEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}

	public void setPassword(String pass) {
		ldriver.findElement(txtPassword).sendKeys(pass);
	}

	public void setFirstName(String fname) {
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}

	public void setLasttName(String lname) {
		ldriver.findElement(txtLastName).sendKeys(lname);
	}

	public void selectGender(String gender) {
		if (gender.equals("Male")) {
			ldriver.findElement(rBtnMale).click();
		} else if (gender.equals("Female")) {
			ldriver.findElement(rBtnFemale).click();
		} else {
			ldriver.findElement(rBtnMale).click(); // by default
		}
	}

	public void setDOB(String dob) {
		ldriver.findElement(txtDoB).sendKeys(dob);

	}

	public void setCompanyName(String name) {
		ldriver.findElement(txtCompany).sendKeys(name);
	}

	public void checkTaxExempt(String check) {
		if (check.equals("Yes")) {
			ldriver.findElement(checkTaxExempt).click();
		}
	}

	public void setCustRoles(String role) throws InterruptedException {
		ldriver.findElement(custRoles).click();
		Thread.sleep(1000);
//		ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement listItem;

		if (role.equals("Administrators")) {
			listItem = ldriver.findElement(listItemAdmin);
		} else if (role.equals("Forum Moderators")) {
			listItem = ldriver.findElement(listItemForum);
		} else if (role.equals("Guests")) {
			listItem = ldriver.findElement(listItemGuest);
		} else if (role.equals("Registered")) {
			listItem = ldriver.findElement(listItemReg);
		} else {
			listItem = ldriver.findElement(listItemVendor);
		}

		listItem.click();
//		JavascriptExecutor js = (JavascriptExecutor) ldriver;
//		js.executeScript("arguments[0].click();", listItem);

	}

	public void setAdminContent(String content) {
		ldriver.findElement(adminContent).sendKeys(content);
	}

	public void saveCustomer() {
		ldriver.findElement(btnSaveCust).click();
	}
}

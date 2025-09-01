package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001 {

	public static void main(String[] args)
	{
		System.out.println("HEllo");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.get("https://www.google.com/");
		System.out.println("Title is:"+driver.getTitle());
		WebElement search=driver.findElement(By.id("APjFqb"));
		search.sendKeys("Automation Testing Tools");
		search.submit();
		 driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");

	        // 5. Verify heading 'Register Account'
	        WebElement heading = driver.findElement(By.xpath("//h1[text()='Register Account']"));
	        if (heading.isDisplayed()) {
	            System.out.println("Heading verification PASSED: " + heading.getText());
	        } else {
	            System.out.println("Heading verification FAILED");
	        }

	        // 6. Click 'Continue' without filling form
	        driver.findElement(By.xpath("//input[@value='Continue']")).click();

	        // 7. Verify warning message
	        WebElement warning = driver.findElement(By.xpath("//div[contains(text(),'Warning: You must agree to the Privacy Policy!')]"));
	        if (warning.isDisplayed()) {
	            System.out.println("Warning verification PASSED: " + warning.getText());
	        } else {
	            System.out.println("Warning verification FAILED");
	        }
	     // ===============================
	        // Your Personal Details Section
	        // ===============================

	        // 8. Enter First Name
	        WebElement firstName = driver.findElement(By.id("input-firstname"));
	        firstName.clear();
	        firstName.sendKeys("AutomationTester");

	        // 9. Verify 33 characters in First Name
	        firstName.clear();
	        String longFirstName = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFG"; // 33 chars
	        firstName.sendKeys(longFirstName);
	        driver.findElement(By.xpath("//input[@value='Continue']")).click();

	        WebElement firstNameError = driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]"));
	        if (firstNameError.isDisplayed()) {
	            System.out.println("First Name length validation PASSED: " + firstNameError.getText());
	        }

	        // 10. Enter Last Name
	        WebElement lastName = driver.findElement(By.id("input-lastname"));
	        lastName.clear();
	        lastName.sendKeys("TesterLastName");

	        // 11. Verify 33 characters in Last Name
	        lastName.clear();
	        String longLastName = "QRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX"; // 33 chars
	        lastName.sendKeys(longLastName);
	        driver.findElement(By.xpath("//input[@value='Continue']")).click();

	        WebElement lastNameError = driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]"));
	        if (lastNameError.isDisplayed()) {
	            System.out.println("Last Name length validation PASSED: " + lastNameError.getText());
	        }

	        // 12. Enter valid Email
	        WebElement email = driver.findElement(By.id("input-email"));
	        email.clear();
	        email.sendKeys("testautomation123@gmail.com");

	        // 13. Enter Telephone (<3 chars to test error)
	        WebElement telephone = driver.findElement(By.id("input-telephone"));
	        telephone.clear();
	        telephone.sendKeys("12");
	        driver.findElement(By.xpath("//input[@value='Continue']")).click();

	        WebElement telErrorMin = driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]"));
	        if (telErrorMin.isDisplayed()) {
	            System.out.println("Telephone min length validation PASSED: " + telErrorMin.getText());
	        }

	        // 14. Enter Telephone (>32 chars to test error)
	        telephone.clear();
	        telephone.sendKeys("123456789012345678901234567890123"); // 33 chars
	        driver.findElement(By.xpath("//input[@value='Continue']")).click();

	        WebElement telErrorMax = driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]"));
	        if (telErrorMax.isDisplayed()) {
	            System.out.println("Telephone max length validation PASSED: " + telErrorMax.getText());
	        }

	        // 15. Enter valid Telephone
	        telephone.clear();
	        telephone.sendKeys("9876543210");
	        // -------------------------------
	        // YOUR ADDRESS SECTION
	        // -------------------------------

	        // 1. Address 1 (invalid <3 chars)
	        WebElement address1 = driver.findElement(By.id("input-address-1"));
	        address1.clear();
	        address1.sendKeys("AB");
	        driver.findElement(By.xpath("//input[@value='Continue']")).click();

	        WebElement addrError = driver.findElement(By.xpath("//div[contains(text(),'Address 1 must be between 3 and 128 characters!')]"));
	        if (addrError.isDisplayed()) {
	            System.out.println("Address length validation PASSED: " + addrError.getText());
	        }

	        // Enter valid Address 1
	        address1.clear();
	        address1.sendKeys("123 Main Street, Automation City");

	        // 2. City (invalid <2 chars)
	        WebElement city = driver.findElement(By.id("input-city"));
	        city.clear();
	        city.sendKeys("A");
	        driver.findElement(By.xpath("//input[@value='Continue']")).click();

	        WebElement cityError = driver.findElement(By.xpath("//div[contains(text(),'City must be between 2 and 128 characters!')]"));
	        if (cityError.isDisplayed()) {
	            System.out.println("City length validation PASSED: " + cityError.getText());
	        }

	        // Enter valid City
	        city.clear();
	        city.sendKeys("Automationville");

	        // 3. Post Code (invalid <2 chars)
	        WebElement postcode = driver.findElement(By.id("input-postcode"));
	        postcode.clear();
	        postcode.sendKeys("1");
	        driver.findElement(By.xpath("//input[@value='Continue']")).click();

	        WebElement postError = driver.findElement(By.xpath("//div[contains(text(),'Postcode must be between 2 and 10 characters!')]"));
	        if (postError.isDisplayed()) {
	            System.out.println("Postcode length validation PASSED: " + postError.getText());
	        }

	        // Enter valid Postcode
	        postcode.clear();
	        postcode.sendKeys("600001");

	        // 4. Select Country
	        WebElement countryDropdown = driver.findElement(By.id("input-country"));
	        Select country = new Select(countryDropdown);
	        country.selectByVisibleText("India");
	        System.out.println("Country selected: India");

	        // 5. Select Region/State
	        WebElement stateDropdown = driver.findElement(By.id("input-zone"));
	        Select state = new Select(stateDropdown);
	        state.selectByVisibleText("Tamil Nadu");  // you can choose any state
	        System.out.println("Region/State selected: Tamil Nadu");
	     // -------------------------------
	        // PASSWORD SECTION
	        // -------------------------------

	        // 1. Password invalid (<4 chars)
	        WebElement password = driver.findElement(By.id("input-password"));
	        password.clear();
	        password.sendKeys("123"); // only 3 chars
	        WebElement confirmPassword = driver.findElement(By.id("input-confirm"));
	        confirmPassword.clear();
	        confirmPassword.sendKeys("123");
	        driver.findElement(By.xpath("//input[@value='Continue']")).click();

	        WebElement passError = driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]"));
	        if (passError.isDisplayed()) {
	            System.out.println("Password min length validation PASSED: " + passError.getText());
	        }

	        // 2. Password invalid (>20 chars)
	        password.clear();
	        confirmPassword.clear();
	        String longPassword = "abcdefghijklmnopqrstuvwxyz"; // 26 chars
	        password.sendKeys(longPassword);
	        confirmPassword.sendKeys(longPassword);
	        driver.findElement(By.xpath("//input[@value='Continue']")).click();

	        WebElement passError2 = driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]"));
	        if (passError2.isDisplayed()) {
	            System.out.println("Password max length validation PASSED: " + passError2.getText());
	        }

	        // 3. Enter valid password and confirm password
	        password.clear();
	        confirmPassword.clear();
	        password.sendKeys("Test@1234");
	        confirmPassword.sendKeys("Test@1234");

	        System.out.println("Password and Confirm Password entered successfully.");
	     // =========================
	        // NEWSLETTER SECTION
	        // =========================

	        // 1. Click on 'Yes' Radio button
	        WebElement newsletterYes = driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']"));
	        newsletterYes.click();
	        System.out.println("Newsletter: YES selected");

	        // 2. Click on checkbox for 'I have read and agree to the Privacy Policy'.
	        WebElement privacyPolicy = driver.findElement(By.name("agree"));
	        privacyPolicy.click();
	        System.out.println("Privacy Policy checkbox selected");

	        // 3. Click on 'Continue' button
	        driver.findElement(By.xpath("//input[@value='Continue']")).click();

	        // 4. Verify message 'Your Account Has Been Created!'
	        WebElement successMsg = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
	        if (successMsg.isDisplayed()) {
	            System.out.println("Registration SUCCESS: " + successMsg.getText());
	        }

	        // 5. Click on 'Continue'
	        driver.findElement(By.linkText("Continue")).click();

	        // 6. Click on link 'View your order history' under 'My Orders'
	        driver.findElement(By.linkText("View your order history")).click();
	        System.out.println("Navigated to: View your order history page");


	    

	        // 8. Close browser
	        
	        driver.quit();
	    
		
	}
}
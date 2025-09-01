package pack1;



	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Lab5 {
	    public static void main(String[] args) throws InterruptedException {

	        WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        // Launch
	        driver.get("https://tutorialsninja.com/demo/index.php");
	        driver.findElement(By.linkText("My Account")).click();
	        driver.findElement(By.linkText("Register")).click();

	        // ---------------- Field Validations ----------------

	        // First Name - Enter more than 33 characters
	        driver.findElement(By.id("input-firstname")).sendKeys("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	        driver.findElement(By.cssSelector("input[value='Continue']")).click();
	        try {
	            WebElement fnError = driver.findElement(By.cssSelector("#input-firstname + div.text-danger"));
	            System.out.println("First Name Error: " + fnError.getText());
	        } catch (Exception e) {
	            System.out.println("No error for First Name field.");
	        }

	        // Last Name - Enter more than 33 characters
	        driver.findElement(By.id("input-lastname")).sendKeys("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
	        driver.findElement(By.cssSelector("input[value='Continue']")).click();
	        try {
	            WebElement lnError = driver.findElement(By.cssSelector("#input-lastname + div.text-danger"));
	            System.out.println("Last Name Error: " + lnError.getText());
	        } catch (Exception e) {
	            System.out.println("No error for Last Name field.");
	        }

	        // E-mail - Invalid format
	        driver.findElement(By.id("input-email")).sendKeys("invalidEmail");
	        driver.findElement(By.cssSelector("input[value='Continue']")).click();
	        try {
	            WebElement emailError = driver.findElement(By.cssSelector("#input-email + div.text-danger"));
	            System.out.println("Email Error: " + emailError.getText());
	        } catch (Exception e) {
	            System.out.println("No error for Email field.");
	        }

	        // Telephone - Less than 3 characters
	        driver.findElement(By.id("input-telephone")).sendKeys("12");
	        driver.findElement(By.cssSelector("input[value='Continue']")).click();
	        try {
	            WebElement telError = driver.findElement(By.cssSelector("#input-telephone + div.text-danger"));
	            System.out.println("Telephone Error: " + telError.getText());
	        } catch (Exception e) {
	            System.out.println("No error for Telephone field.");
	        }

	        // Password - Less than 4 characters
	        driver.findElement(By.id("input-password")).sendKeys("123");
	        driver.findElement(By.id("input-confirm")).sendKeys("123");
	        driver.findElement(By.cssSelector("input[value='Continue']")).click();
	        try {
	            WebElement passError = driver.findElement(By.cssSelector("#input-password + div.text-danger"));
	            System.out.println("Password Error: " + passError.getText());
	        } catch (Exception e) {
	            System.out.println("No error for Password field.");
	        }

	        // ---------------- Successful Registration ----------------
	        // Clear and enter valid data
	        driver.findElement(By.id("input-firstname")).clear();
	        driver.findElement(By.id("input-firstname")).sendKeys("John");

	        driver.findElement(By.id("input-lastname")).clear();
	        driver.findElement(By.id("input-lastname")).sendKeys("Smith");

	        driver.findElement(By.id("input-email")).clear();
	        driver.findElement(By.id("input-email")).sendKeys("johnsmith" + System.currentTimeMillis() + "@gmail.com");

	        driver.findElement(By.id("input-telephone")).clear();
	        driver.findElement(By.id("input-telephone")).sendKeys("9876543210");

	        driver.findElement(By.id("input-password")).clear();
	        driver.findElement(By.id("input-password")).sendKeys("password123");

	        driver.findElement(By.id("input-confirm")).clear();
	        driver.findElement(By.id("input-confirm")).sendKeys("password123");

	        // Newsletter = Yes
	        driver.findElement(By.cssSelector("input[name='newsletter'][value='1']")).click();

	        // Privacy Policy checkbox
	        driver.findElement(By.name("agree")).click();

	        // Continue button
	        driver.findElement(By.cssSelector("input[value='Continue']")).click();

	        // Verify success message
	        WebElement successMsg = driver.findElement(By.cssSelector("#content h1"));
	        if (successMsg.getText().equals("Your Account Has Been Created!")) {
	            System.out.println("✅ Registration Successful: " + successMsg.getText());
	        } else {
	            System.out.println("❌ Registration Failed!");
	        }

	        // Continue after success
	        driver.findElement(By.linkText("Continue")).click();

	        // Navigate to "View your order history"
	        driver.findElement(By.linkText("View your order history")).click();
	        System.out.println("Navigated to: " + driver.getTitle());

	        driver.quit();
	    }
	}



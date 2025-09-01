package pack1;

	import io.github.bonigarcia.wdm.WebDriverManager;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class Lab6{
	public static void main(String args[]) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		// 1. Login with credentials created in Lab 1
	    driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
	    Thread.sleep(2000);
	    driver.findElement(By.id("input-email")).sendKeys("aashraja305@gmail.com");
	    driver.findElement(By.id("input-password")).sendKeys("Aasharaja@2468");
	    driver.findElement(By.cssSelector("input[value='Login']")).click();
	    Thread.sleep(2000);
	    
	    // 2. Go to 'Components' tab and click
	    driver.findElement(By.linkText("Components")).click();
	    Thread.sleep(1000);

	    // 3. Select Monitors
	    driver.findElement(By.linkText("Monitors (2)")).click();
	    Thread.sleep(2000);

	 // 4. Select 25 from 'Show' dropdown
	    driver.findElement(By.id("input-limit")).sendKeys("25");
	    Thread.sleep(1000);

	    
	 // 5. Click on 'Add to cart' for the first item
	    driver.findElement(By.xpath("//*[@id='content']/div[3]/div[1]/div/div[2]/div[2]/button[1]")).click();
	    Thread.sleep(2000);
	    
	 // 6. Click on 'Specification' tab
	    driver.findElement(By.xpath("//a[text()='Specification']")).click();
	    Thread.sleep(2000);
	    
	    // 7. Verify details present on the page
	    WebElement specTable = driver.findElement(By.id("tab-specification"));
	    if (specTable.isDisplayed()) {
	        System.out.println("Specification details are displayed");
	    }
	    
	 // 8. Click on 'Add to Wish list' button
	    driver.findElement(By.xpath("(//button[@data-original-title='Add to Wish List'])[1]")).click();
	    Thread.sleep(2000);
	    
	 // 9. Verify message
	    WebElement wishlistMsg = driver.findElement(By.cssSelector(".alert-success"));
	    if (wishlistMsg.getText().contains("Success: You have added Apple Cinema 30\" to your wish list!")) {
	        System.out.println("Wishlist success message verified");
	    }
	    
	 // 10. Enter 'Mobile' in 'Search' text box
	    driver.findElement(By.name("search")).sendKeys("Mobile");

	 // 11. Click on 'Search' button
	    driver.findElement(By.xpath("//*[@id='search']/span/button")).click();
	    Thread.sleep(2000);

	    // 12. Click on 'Search in product descriptions' check box
	    driver.findElement(By.name("description")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("button-search")).click();

	    // 13. Click on link 'HTC Touch HD'
	    driver.findElement(By.linkText("HTC Touch HD")).click();
	    Thread.sleep(2000);

	    // 14. Clear '1' from 'Qty' and enter '3'
	    WebElement qty = driver.findElement(By.id("input-quantity"));
	    qty.clear();
	    qty.sendKeys("3");

	    // 15. Click on 'Add to Cart' button
	    driver.findElement(By.xpath("//*[@id='button-cart']")).click();
	    Thread.sleep(2000);

	    // 16. Verify success message
	    WebElement cartMsg = driver.findElement(By.cssSelector(".alert-success"));
	    if (cartMsg.getText().contains("Success: You have added HTC Touch HD to your shopping cart!")) {
	        System.out.println("Cart success message verified");
	    }

	    // 17. Click on View cart button 
	    driver.findElement(By.xpath("//span[text()='Shopping Cart']")).click();
	    Thread.sleep(2000);

	    // 18. Verify Mobile name added to the cart
	    if (driver.findElement(By.linkText("HTC Touch HD")).isDisplayed()) {
	        System.out.println("HTC Touch HD is present in the cart");
	    }

	    // 19. Click on 'Checkout' button
	    driver.findElement(By.linkText("Checkout")).click();
	    Thread.sleep(2000);

	    // 20. Click on 'My Account' dropdown
	    driver.findElement(By.xpath("//span[text()='My Account']")).click();

	    // 21. Select 'Logout' from dropdown
	    driver.findElement(By.linkText("Logout")).click();
	    Thread.sleep(2000);

	    // 22. Verify 'Account Logout' heading
	    WebElement logoutHeader = driver.findElement(By.xpath("//h1[text()='Account Logout']"));
	    if (logoutHeader.isDisplayed()) {
	        System.out.println("Logout successful, 'Account Logout' heading is visible");
	    }

	    // 23. Click on 'Continue'
	    driver.findElement(By.linkText("Continue")).click();

	    // Close browser
	    Thread.sleep(2000);
	    driver.quit();
	}	
	}



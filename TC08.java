package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC08 {
	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();

		driver.get("https://tutorialsninja.com/demo/index.php");
		System.out.println("Title is: " + driver.getTitle());
		driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("testautomation123@gmail.com"); 
        driver.findElement(By.id("input-password")).sendKeys("Test@1234");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        System.out.println("Login successful");
        driver.findElement(By.linkText("Components")).click();
        driver.findElement(By.linkText("Monitors(2)")).click();
        System.out.println("Componets navigated to Monitors(2) page");
        Select showDropdown = new Select(driver.findElement(By.id("input-limit")));
        showDropdown.selectByVisibleText("25");
        System.out.println("Show selected = 25");
        driver.findElement(By.id("button-cart")).click();


        
		
	}

}

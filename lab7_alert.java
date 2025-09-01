package pack1;


	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class lab7_alert{

		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://letcode.in/alert");
			driver.findElement(By.id("accept")).click();
			Alert simplealert = driver.switchTo().alert();
			System.out.println("Alert message:"+simplealert.getText());
			simplealert.accept();
			driver.findElement(By.id("confirm")).click();
			Alert confirmalert=driver.switchTo().alert();
			System.out.println("Alert message:"+confirmalert.getText());
			confirmalert.accept();
			driver.findElement(By.id("prompt")).click();
			Alert promptalert=driver.switchTo().alert();
			System.out.println("Alert message:"+promptalert.getText());
			promptalert.sendKeys("Asha");
			promptalert.accept();
			/*Since alerts are outside the DOM, Selenium provides a special interface:
			 1.switchTo().alert() tells Selenium to shift control to the alert box.
			 Once switched, you can:
			   a.alert.getText() → read the message inside the alert.
			   b.alert.accept() → click OK.
			   c.alert.dismiss() → click Cancel (only for confirmation alerts).
			   d.alert.sendKeys("text") → type into prompt alerts.*/
		}

	}


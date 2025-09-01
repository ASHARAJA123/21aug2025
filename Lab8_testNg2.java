package pack1;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Lab8_testNg2{
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        Reporter.log("Opened TutorialNinja Demo site", true);
    }

    @Test
    public void testLab4Flow() {
        Reporter.log("Starting Lab 4 Flow", true);

        // Verify title
        Assert.assertEquals(driver.getTitle(), "Your Store", "Title mismatch");
        Reporter.log("Verified title: Your Store", true);

        // Go to Desktops → Mac
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Mac (1)")).click();
        Reporter.log("Navigated to Desktops > Mac", true);

        // Verify Mac heading
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Mac']")).isDisplayed(), "Mac heading not visible");

        // Sort by Name (A-Z)
        WebElement sort = driver.findElement(By.id("input-sort"));
        sort.sendKeys("Name (A - Z)");
        Reporter.log("Sorted products by Name (A-Z)", true);

        // Click Add to Cart
        driver.findElement(By.xpath("//*[@id='content']/div[2]/div/div/div[2]/div[2]/button[1]/span")).click();
        Reporter.log("Clicked Add to Cart", true);

        // Verify success message
        WebElement success = driver.findElement(By.cssSelector(".alert-success"));
        Assert.assertTrue(success.isDisplayed(), "Product not added to cart!");
        Reporter.log("Verified product added to cart", true);

        // Search for Mobile
        driver.findElement(By.name("search")).sendKeys("Mobile");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        Reporter.log("Searched for Mobile", true);

        // Clear & search for Monitors
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        searchBox.sendKeys("Monitors");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        Reporter.log("Searched for Monitors", true);

        // Check description box and search again
        driver.findElement(By.name("description")).click();
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        Reporter.log("Checked description box and searched again", true);

        // Verify results displayed
        Assert.assertTrue(driver.findElement(By.id("content")).isDisplayed(), "Results not displayed");
        Reporter.log("Verified search results are displayed", true);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        Reporter.log("Closed the browser", true);
    }
}

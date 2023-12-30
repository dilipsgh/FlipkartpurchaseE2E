package Flipkartpractise.Test;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FlipkartOrderAction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String productname="Sansui Chetak Speed 400 mm 3 Blade Pedestal Fan";
		System.setProperty("webdriver.chrome.driver","D:/Selenium Automation/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		//driver.findElement(By.cssSelector("span[role='button']")).click();
		WebElement sr=driver.findElement(By.cssSelector("input[class='Pke_EE']"));
		sr.click();
		sr.sendKeys("fan",Keys.ENTER);
		//Sansui Chetak Speed 400 mm 3 Blade Pedestal Fan  (Blue and White, Pack of 1)
                
	WebElement first=driver.findElement(By.xpath("//div[normalize-space(text())='BAJAJ Crest Neo 1200 mm Ultra High Speed 3 Blade Ceiling Fan']"));
	//WebElement second=driver.findElement(By.xpath("//div[normalize-space(text())='Sansui Chetak Speed 400 mm 3 Blade Pedestal Fan']"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,350)", ""); 	//Scroll down 
	Thread.sleep(3000);

    Actions at=new Actions(driver);
  //  at.keyDown(Keys.CONTROL).moveToElement(first).click().build().perform();
    at.contextClick(first).build().perform();
    // at.moveToElement(first).sendKeys(Keys.CONTROL).click().build().perform();

    
    
	}
	
}

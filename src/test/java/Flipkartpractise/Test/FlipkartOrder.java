package Flipkartpractise.Test;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FlipkartOrder {

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
    
    Actions at=new Actions(driver);
  //  at.keyDown(Keys.CONTROL).moveToElement(first).click().build().perform();
    at.moveToElement(first).contextClick(first).sendKeys(Keys.ENTER).build().perform();

 //   at.moveToElement(first).sendKeys(first,Keys.CONTROL).build().perform();

		Set<String> handle=driver.getWindowHandles();
		ArrayList<String>  wd=new ArrayList<String>(handle);
		int count=wd.size();
		System.out.println(wd.size());
	    //switch to active tab
	    driver.switchTo().window(wd.get(1));
	    Thread.sleep(3000);
	    boolean chk=driver.findElement(By.cssSelector("[class='_2KpZ6l _2U9uOA _3v1-ww']")).isEnabled();	    
	       Assert.assertTrue(chk); 
	       	  System.out.println ("Add to cart button Enable");
	    	  Thread.sleep(2000);
	    	  driver.findElement(By.cssSelector("[class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
	    	    driver.switchTo().window(wd.get(1)).close();
	     
	    //switch to parent tab
    	  Thread.sleep(3000);
	    driver.switchTo().window(wd.get(0));
	    
	    //Searching for another proudct and clicking on it
		driver.findElement(By.xpath("//div[normalize-space(text())='Sansui Chetak Speed 400 mm 3 Blade Pedestal Fan']")).click();
		Thread.sleep(2000);
		//Finding the open tab in the browser
		Set<String> handle1=driver.getWindowHandles();
		ArrayList<String>  wd1=new ArrayList<String>(handle1);
	    driver.switchTo().window(wd1.get(1));
	  // System.out.println("The current title is"  +  driver.switchTo().window(wd.get(0)).getTitle());
	  //  boolean chk1=driver.findElement(By.cssSelector("[class='_2KpZ6l _2U9uOA _3v1-ww']")).isEnabled();
	  //  Assert.assertTrue(chk1);	    
	   //  System.out.println ("Add to cart button Enable[");
    	//  Thread.sleep(3000);
		
	//	 WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	//	 wait.until(ExpectedConditions.presenceOfElementLocated((By) driver.findElement(By.cssSelector("[class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']"))));
		
			 	  driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click(); //Adding the product to cart
			 	  
	  
	   //Go to cart page
	      //Checking the product if its available in the cart 
	   	      
	    List<WebElement> items=driver.findElements(By.cssSelector("[class='_2Kn22P gBNbID']"));
	    Boolean match = items.stream().anyMatch(item -> item.getText().equalsIgnoreCase(productname));
	    if (match==true)
	    {
	    	System.out.println("Product Available");
	    	
	    }
	    else
	    {
	    	System.out.println("Product not Available");
	    }
        Assert.assertTrue(match);
        driver.findElement(By.cssSelector("[class='_2KpZ6l _2ObVJD _3AWRsL']")).click();
        
	      

	}

}

package Flipkartpractise.Test;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FlipkartOrderIterator {

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

		driver.findElement(By.xpath("//div[normalize-space(text())='BAJAJ Crest Neo 1200 mm Ultra High Speed 3 Blade Ceiling Fan']")).click();
		//Thread.sleep(3000);
  	   

		
		String parentwindow=driver.getWindowHandle();
		Set<String> allWindowHandles=driver.getWindowHandles();

		java.util.Iterator<String> it=allWindowHandles.iterator();
		
	/*	while(it.hasNext())		
			
		{
		//	String child_window=it.next();
			
		//	if (!parent.equals(child_window))
		//	{
				
		      // driver.switchTo().window("0");
				System.out.println("The Title of Child window : " + driver.getTitle());
				  Thread.sleep(2000);
				  driver.switchTo().window(it.next());
		    	  driver.findElement(By.cssSelector("[class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		    	  driver.close();	    	  		
				
		//}  */
		    	  
		while(it.hasNext())			
        {		
			
			driver.switchTo().window(parentwindow);
            String ChildWindow=it.next();		
            		
            if(!parentwindow.equalsIgnoreCase(ChildWindow))			
            {    		
                 
                    // Switching to Child window
                    driver.switchTo().window(ChildWindow);	
                    driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
                   // driver.findElement(By.name("emailid"))
                  //  .sendKeys("gaurav.3n@gmail.com");                			
                    
                  //  driver.findElement(By.name("btnLogin")).click();			
                                 
			// Closing the Child Window.
                        driver.close();		
                 driver.switchTo().window(parentwindow);	
        
                        
            }		
        }		
        // Switching to Parent window i.e Main Window.
            driver.switchTo().window(parentwindow);	
	
		 
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
	




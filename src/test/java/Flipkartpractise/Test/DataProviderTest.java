package Flipkartpractise.Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

   @Test (dataProvider="data-provider")
		public void MyTest(String val)
		
		{
	   
	   System.out.println("The Name is: "  + val);
	   
	   System.out.println("This is the for Test");

	       
		}
   
   
   
   @DataProvider (name = "data-provider")
	public String[][] MyTest1()
	
	{
	  String[][] test= new String[][] {  {"My name is Test"},{"My Name is Best"},{"My name is Rest"},{"My name is Rahul"}};
	  return test;
	    
	   	   
      
	}
	
		
		
		
	}



package packagesinkeys;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmailmethods 
{
	public WebDriver driver;
	public String launch(String o,String d,String c) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","E:\\testing\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(d);
		Thread.sleep(5000);
		return ("Done");		
	}
	public String fill(String o,String d,String c) throws Exception
	{
		driver.findElement(By.xpath(o)).sendKeys(d);
		Thread.sleep(5000);
		return ("Done");
		
	}
	public String click(String o,String d,String c) throws Exception
	{
		driver.findElement(By.xpath(o)).click();
		Thread.sleep(5000);
		return ("Done");
		
	}
	public String validateuserid(String o,String d,String c) throws Exception
	{
		try
		{
			if(c.equals("valid") && driver.findElement(By.name("password")).isDisplayed())
			{
				return ("test passed");
			}
			else if(c.equals("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'find your Google') or contains(text(),'Enter an email')])[2]")).isDisplayed())
			{
				return ("test passed");
			}
			else
			{
				return ("test failed");
			}
			
		}
		catch(Exception e)
		{
			return ("test interrupted");
		}
				
	}
	public String close(String o,String d,String c)throws Exception
	{
		driver.close();
		Thread.sleep(5000);
		return ("Done");
		
	}


}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Loginpage 
{
	public WebDriver driver;
	public By pwd=By.name("password");
	public By pwderr=By.xpath("//*[text()='Enter a password' or contains(text(),'Wrong password')]");
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void fillpwd(String p)
	{
		driver.findElement(pwd).sendKeys(p,Keys.ENTER);
	}

}

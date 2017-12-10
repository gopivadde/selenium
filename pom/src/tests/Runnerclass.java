package tests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import pages.Homepage;
import pages.Loginpage;

import jxl.Sheet;
import jxl.Workbook;

import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Runnerclass 
{

	
	public static void main(String[] args) throws Exception, IOException 
	{
		//Open excel file for reading
				File f=new File("F:\\page.xls");
				Workbook rwb=Workbook.getWorkbook(f);
				Sheet rsh=rwb.getSheet(0);
				int nour=rsh.getRows();
				int nouc=rsh.getColumns();
				//Open excel for writing 
				WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
				WritableSheet wsh=wwb.getSheet(0);
				//Data driven testing from 2nd row
				//1st have names of columns
				for(int i=1;i<nour;i++)
				{
					String u=rsh.getCell(0,i).getContents();
					String uc=rsh.getCell(1,i).getContents();
					String p=rsh.getCell(2,i).getContents();
					String pc=rsh.getCell(3,i).getContents();
					//Launch site
					System.setProperty("webdriver.chrome.driver","F:\\selenium888\\chromedriver.exe");
					WebDriver driver=new ChromeDriver();
					driver.get("http://www.gmail.com");
					driver.manage().window().maximize();
					Thread.sleep(5000);
					//Create objs. to page classes
					Homepage hp= new Homepage(driver);
					Loginpage lp=new Loginpage(driver);
					//Enter user id & validations
					hp.filluid(u);
					Thread.sleep(5000);
					try
					{
						if(uc.equals("valid") && driver.findElement(lp.pwd).isDisplayed())
						{
							//Enter password & validations
							lp.fillpwd(p);
							Thread.sleep(5000);
							if(pc.equals("valid") && driver.findElement(By.xpath("(//*[contains(text(),'Inbox')])[3]")).isDisplayed())
							{
								Label l=new Label(nouc,i,"pwd test passed");
								wsh.addCell(l);
							}
							else if(pc.equals("invalid") && driver.findElement(lp.pwderr).isDisplayed())
							{
								Label l=new Label(nouc,i,"pwd test passed");
								wsh.addCell(l);
							}
							else
							{
								Label l=new Label(nouc,i,"pwd test failed");
								wsh.addCell(l);
							}
						}
						else if(uc.equals("invalid") && driver.findElement(hp.uiderr).isDisplayed())
						{
							Label l=new Label(nouc,i,"uid test passed");
							wsh.addCell(l);
						}
						else
						{
							Label l=new Label(nouc,i,"uid test failed");
							wsh.addCell(l);
						}
						
					}
					catch(Exception e)
					{
						Label l=new Label(nouc,i,"login test interrupted");
						wsh.addCell(l);
					}
					//Close site
					driver.close();
					
				}
				//Save and close Excel file
				wwb.write();
				rwb.close();
				wwb.close();

	}

}

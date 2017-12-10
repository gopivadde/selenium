package gmailmethods;

public class Mycode 
{
	public WebDriver driver;
	public Scenario s;
	@Before
	public void method1(Scenario x)
	{
		this.s=
	}
	@Given("^lanuch gmail site$")
	public void method2()throws Exception
	{
		System.setProperty("webdriver.chrome.driver","F:\\selenium888\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
	}
	@Then("^title is \"(.*)\"$")
	public void method3(String et)
	{
		String=driver.getTitle();
		try{
			if(at.equals(et))
			{
				s.write("test passed");
			}
			else
			{
				s.write("test failed");
			}
		}
		catch(Exception e)
		{
			s.write("test interupted");
		}
		@And("^close site$")
		public void method4()
		{
			driver.close();
		}
		@When("^enter userid as \"(.*)\"$")
		public void method5(String u)
		{
			driver.findElement(By.name("identifier")).sendKeys(u);
			Thread.sleep(5000);
		}
		@And("^click next button$")
		public void method6()throws Exception
		{
			driver.findElement(By.id("identifierNext")).click();
			Thread.sleep(5000);
		}
		@Then("^validate userid with\"(.*)\"$")
		public void method7(String c)
		{
			try
			{
				if(c.equals("valid") && driver.findElement(By.name("password")).isDisplayed())
				{
					s.write("test passed");
				}
				else if(c.equals("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'Enter an email') or contains(text(),'find your Google')])[2]")).isDisplayed())
				{
					s.write("test passed");
				}
				else
				{
					s.write("test failled");
				}
			}
			catch(Exception e)
			{
				
			
				{
					s.write("test interrupted");
				}
			}
			@After
			public void mwethod8()
			{
				s.write("test scenario completed");
			}
			}
		}
		
	}
	

}

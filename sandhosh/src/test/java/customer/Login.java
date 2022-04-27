package customer;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
public class Login {
  public static  WebDriver driver;
	@BeforeSuite
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","src/main/java/testresource/chromedriver.exe");
		ChromeOptions opt =new ChromeOptions();
		opt.setExperimentalOption("excludeSwitches",Arrays.asList("enable-automation"));
		driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("http://medeilhq.medeil.io/medeilhq/#/userlogin/login");
		driver.manage().timeouts().pageLoadTimeout(1000,TimeUnit.MILLISECONDS);
	}
	@Test
	public void a_login() throws InterruptedException  {
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.findElement(By.name("username")).sendKeys("venkateshtitaniumhq@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("Medeil");
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		Thread.sleep(7000);
		System.out.println(driver.getTitle());
	}
	@Test
	public void b_addemployee() throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(By.xpath("//label[contains(text(),'Account Payable')]//following::em[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='HRMS']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Employee Register'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Add Employee']")).click();
		Thread.sleep(2000);
		WebElement e_Title=driver.findElement(By.name("select"));
		Select sel=new Select(e_Title);
		Thread.sleep(2000);
		sel.selectByVisibleText("Mr.");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[contains(text(),'First')]//following::input[1]")).sendKeys("pandi");
		driver.findElement(By.xpath("//label[contains(text(),'First')]//following::input[2]")).sendKeys("pandi");
		WebElement gender=driver.findElement(By.xpath("//label[contains(text(),'First')]//following::input[3]"));
		gender.click();
		System.out.println(gender.isEnabled());
		WebElement e_Mode=driver.findElement(By.xpath("(//select[@name='select'])[2]"));
		Select sel1=new Select(e_Mode);
		Thread.sleep(3000);
		sel1.selectByVisibleText("Permanent");
		WebElement e_Type=driver.findElement(By.xpath("(//select[@name='select'])[3]"));
		Select sel2=new Select(e_Type);
		Thread.sleep(3000);
		sel2.selectByVisibleText("Full Time Hourly");
		driver.findElement(By.xpath("(//select[@name='select'])[4]/option[contains(text(), 'sales')]")).click();
		Thread.sleep(4000);
		WebElement date=driver.findElement(By.xpath("(//label[contains(text(),'Date')])[1]//following::input[1]"));
		Actions act=new Actions(driver);
		Thread.sleep(2000);
		date.sendKeys("0301");
		act.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		date.sendKeys("2021");
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//label[contains(text(),'Date')])[1]//following::input[2]")).click();
		WebElement date1=driver.findElement(By.xpath("(//label[contains(text(),'Date')])[1]//following::input[4]"));
		Actions act1=new Actions(driver);
		Thread.sleep(2000);
		date1.sendKeys("0530");
		act1.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		date1.sendKeys("1995");
		driver.findElement(By.xpath("(//label[contains(text(),'Date')])[1]//following::input[5]")).sendKeys("7010911215");
		Thread.sleep(5000);
		driver.findElement(By.id("email")).sendKeys("santhosh@gmail.com");
		WebElement save= driver.findElement(By.xpath("(//button[contains(text(),'Save')])[1]"));
		Thread.sleep(5000);
		save.click();
		System.out.println(save.isDisplayed());
		Thread.sleep(4000);
	}

	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
}

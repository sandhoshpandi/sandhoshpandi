package MedeilLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Sales {
	WebDriver driver;
	@BeforeSuite
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","src/main/java/testresource/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://medeilhq.medeil.io/medeilplus/#/userlogin/login");

	}
	@Test
	public void a_login() throws java.lang.InterruptedException   {
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.findElement(By.name("username")).sendKeys("venkatplatitest@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("Medeil");
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		Thread.sleep(7000);
		System.out.println(driver.getTitle());
		Thread.sleep(7000);
		driver.findElement(By.xpath("//label[contains(text(),'Account Payable')]//following::em[1]")).click();
	}
	@Test 
	public void b_sales() throws InterruptedException {
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//span[text()='Sales']")).click();
		driver.findElement(By.xpath("(//span[text()='Sales Invoice'])[2]")).click();
		driver.findElement(By.xpath("(//span[text()='Sales Invoice'])[3]")).click();
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ng-select[@id='customfocus']")));
		driver.findElement(By.xpath("//ng-select[@id='customfocus']")).click();
		
		Thread.sleep(2000);
		WebElement cus=driver.findElement(By.xpath("//div[contains(text(),'Search')]/following::input[1]"));
		cus.sendKeys("s");
		Actions act=new Actions(driver);
		WebElement customer=driver.findElement(By.xpath("//span[contains(text(),'santhosh_7010911215')]"));
		act.moveToElement(customer).build().perform();
		customer.click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//option[text()='--Select Doctor--']/following::option[1]")).click();
		Thread.sleep(2000);
		WebElement drug=driver.findElement(By.id("drugfocus1"));
		drug.sendKeys("s");
		Actions act1=new Actions(driver);
		WebElement drug1=driver.findElement(By.xpath("//label[contains(text(),' Stalmox-Cl 625 500mg + 125mg Opth Drops ')]"));
		act1.moveToElement(drug1).build().perform();
		drug1.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Qty:']/following::input[1]")).sendKeys("1");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='width1'])[1]")).sendKeys("10");
		Thread.sleep(2000);
		WebElement amo=driver.findElement(By.xpath("//label[contains(text(),' Received')]/following::input[1]"));
		amo.click();
		amo.sendKeys(Keys.CONTROL+"a");
		amo.sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),' Received')]/following::input[1]")).sendKeys("4500");
		driver.findElement(By.xpath("//button[text()='Save & Print']")).click();
		System.out.println(driver.getCurrentUrl());
	}
}

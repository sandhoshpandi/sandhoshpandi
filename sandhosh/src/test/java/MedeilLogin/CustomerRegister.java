package MedeilLogin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.Testutility;

public class CustomerRegister {
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
		driver.findElement(By.name("username")).sendKeys("nithya@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("Medeil");
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		Thread.sleep(7000);
		System.out.println(driver.getTitle());
		Thread.sleep(7000);
		driver.findElement(By.xpath("//label[contains(text(),'Account Payable')]//following::em[1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'CRM')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[contains(text(),'Customer Registration')])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Add Customer')]")).click();
	}
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testdata=Testutility.getDataFromExcel();
		return testdata.iterator();
	}
	@Test(dataProvider="getTestData")
	public void b_customerRegister(String PatientFirstName,String PatientLastName,String VATGST,String Address1,String Address2,String PINCode,String Country,String State,String MobileNumber,String EmailId,String PhoneNumber) 
			throws InterruptedException {
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//input[@name='doctorName'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@name='doctorName'])[2]")).sendKeys(PatientFirstName);
		
		driver.findElement(By.id("docregistrationid")).clear();
		driver.findElement(By.id("docregistrationid")).sendKeys(PatientLastName);
		driver.findElement(By.xpath("(//input[@name='gender'])[1]")).click();
		WebElement date=driver.findElement(By.id("docphonenumber"));
		date.sendKeys("30May");
		Actions act=new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
		date.sendKeys("1995");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//label[contains(text(),'VAT / GST Number')]/following::input[1]")).clear();
		driver.findElement(By.xpath("//label[contains(text(),'VAT / GST Number')]/following::input[1]")).sendKeys(VATGST);
		//WebElement cat=driver.findElement(By.xpath("(//select[@name='select'])[1]/option[3] "));
		//Select cate=new Select(cat);
		//cate.selectByValue("34");
		driver.findElement(By.xpath("(//select[@name='select'])[1]/option[3] ")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'Select')])[1]/following::input[1]")).click();
		driver.findElement(By.xpath("(//input[@id='doc_address1'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@id='doc_address1'])[1]")).sendKeys(Address1);
		driver.findElement(By.xpath("(//input[@id='doc_address1'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@id='doc_address1'])[2]")).sendKeys(Address2);
		
		driver.findElement(By.id("docpincode")).clear();
		driver.findElement(By.id("docpincode")).sendKeys(PINCode);
		Thread.sleep(5000);
		WebElement country=driver.findElement(By.id("doccountry"));
		Select coun=new Select(country);
		country.clear();
		coun.selectByVisibleText(Country);
		//driver.findElement(By.xpath("(//select[@name='select'])[2]/option[contains(text(),'India')]")).click();
		Thread.sleep(5000);
		WebElement stat=driver.findElement(By.id("docstate"));
		Select state=new Select(stat);
		stat.clear();
		state.selectByVisibleText(State);
	    //driver.findElement(By.xpath("//select[@name='select'])[3]/option[contains(text(),'Tamilnadu')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//select[@id='docstate'])/option[contains(text(),'Chennai')] ")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("docmobile")).clear();
		driver.findElement(By.id("docmobile")).sendKeys(MobileNumber);
		driver.findElement(By.id("docemail")).clear();
		driver.findElement(By.id("docemail")).sendKeys(EmailId);
		driver.findElement(By.id("docphonenumber")).clear();
		driver.findElement(By.id("docphonenumber")).sendKeys(PhoneNumber);
		WebElement submit=driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		submit.click();
		System.out.println(submit.isDisplayed());
		//System.out.println(driver.getPageSource());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		//driver.navigate().to("http://medeilhq.medeil.io/medeilplus/#/CustomerRegistration/ViewCustomer");
		
	}
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}

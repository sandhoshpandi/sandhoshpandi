package customer;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.LoginTestutility;
import utility.Testutility;

public class CustomerRegister  {
	WebDriver driver;
	Logger logger;
	
	@BeforeSuite
	public void setUp() throws Exception {
		//System.setProperty("webdriver.chrome.driver","src/main/java/testresource/chromedriver.exe");
		WebDriverManager.chromedriver().setup(); 
		ChromeOptions opt=new ChromeOptions();
		opt.setExperimentalOption("excludeSwitches",Arrays.asList("enable-automation"));
		driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://medeilhq.medeil.io/medeilhq/#/userlogin/login");
		logger = Logger.getLogger("MedeilPlus");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("driver is loaded");
		System.out.println(opt.toJson());
	}
	@DataProvider
	public Iterator<Object[]> getTestData1() {
		ArrayList<Object[]> testdata1=LoginTestutility.getDataFromExcel1();
		return testdata1.iterator();
	}
	@Test(dataProvider = "getTestData1",priority = 0)
	public void loginPage(String username,String password) throws Exception   {
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		logger.info("username Entered");
		driver.findElement(By.name("username")).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys(password);
		logger.info("Password Entered");
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		Thread.sleep(7000);
		System.out.println(driver.getTitle());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[contains(text(),'Account Payable')]//following::em[1]")).click();
		takeSnapShot(driver, "E:\\MedeilAutomation\\MedeilLogin\\Screenshots\\userlogin.png");
     
	}
	@Test(priority = 1)
	public void addEmployee() throws InterruptedException {
		Thread.sleep(7000);
		//driver.findElement(By.xpath("//label[contains(text(),'Account Payable')]//following::em[1]")).click();
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
		//Actions act=new Actions(driver);
		Thread.sleep(2000);
		date.sendKeys("03012021");
		//act.sendKeys(Keys.TAB).build().perform();
		//Thread.sleep(2000);
		//date.sendKeys("2021");
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//label[contains(text(),'Date')])[1]//following::input[2]")).click();
		WebElement date1=driver.findElement(By.xpath("(//label[contains(text(),'Date')])[1]//following::input[4]"));
	//	Actions act1=new Actions(driver);
		Thread.sleep(2000);
		date1.sendKeys("05301995");
		//act1.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		//date1.sendKeys("1995");
		driver.findElement(By.xpath("(//label[contains(text(),'Date')])[1]//following::input[5]")).sendKeys("7010911215");
		Thread.sleep(5000);
		driver.findElement(By.id("email")).sendKeys("santhosh@gmail.com");
		WebElement save= driver.findElement(By.xpath("(//button[contains(text(),'Save')])[1]"));
		Thread.sleep(5000);
		save.click();
	    logger.info("Employee Added");
		System.out.println(save.isDisplayed());
		String s=driver.getTitle();
		//Assert.assertEquals(s, "Medeil Cloud |View Employee");
		Thread.sleep(4000);
	}
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testdata=Testutility.getDataFromExcel();
		return testdata.iterator();
	}
	@Test(dataProvider="getTestData",priority = 2)
	public void customerRegister(String PatientFirstName,String PatientLastName,String Gender,String dob,String VATGST,String Category,String patienttype,String Address1,String Address2,String PINCode,String Country,String State,String City,String MobileNumber,String EmailId,String PhoneNumber) 
			throws Exception {
		Thread.sleep(2000);
         WebDriverWait wait=new WebDriverWait(driver, 20);
	
	WebElement cli=	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),'CRM')])[1]")));
	cli.click();	
	Thread.sleep(2000);
		//driver.findElement(By.xpath("(//span[contains(text(),'CRM')])[1]")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'Customer Registration')])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Add Customer')]")).click();
		driver.findElement(By.xpath("(//input[@name='doctorName'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@name='doctorName'])[2]")).sendKeys(PatientFirstName);
		logger.info("Patient name firstname entered");
		driver.findElement(By.id("docregistrationid")).clear();
		driver.findElement(By.id("docregistrationid")).sendKeys(PatientLastName);
		logger.info("Patient lastname Entered");
		List RadioButton = driver.findElements(By.name("gender"));
        // selecting the Radio buttons by Name
        int Size = RadioButton.size();                // finding the number of Radio buttons

        for(int i=0; i < Size; i++)                      // starts the loop from first Radio button to the last one
       { 
     String val =((WebElement) RadioButton.get(i)).getAttribute("value");
 // Radio button name stored to the string variable, using 'Value' attribute

     if (val.equalsIgnoreCase(Gender))   // equalsIgnoreCase is ignore case(upper/lower)
              {                 // selecting the Radio button if its value is same as that we are looking for
     ((WebElement) RadioButton.get(i)).click();
     break;
         }
           }
        logger.info("Gender Selected");
		WebElement date=driver.findElement(By.id("docphonenumber"));
		Thread.sleep(2000);
		date.sendKeys(dob);
		//Actions act=new Actions(driver);
		//act.sendKeys(Keys.TAB).build().perform();
		//date.sendKeys(year);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//label[contains(text(),'VAT / GST Number')]/following::input[1]")).clear();
		driver.findElement(By.xpath("//label[contains(text(),'VAT / GST Number')]/following::input[1]")).sendKeys(VATGST.replaceAll("[^0-9]", ""));
		//WebElement cat=driver.findElement(By.xpath("(//select[@name='select'])[1]/option[3] "));
		//Select cate=new Select(cat);
		//cate.selectByValue("34");
		logger.info("Vat/Gst Number Entered");
        WebElement category=driver.findElement(By.xpath("(//select[@name='select'])[1]"));
        Select cat=new Select(category);
        cat.selectByVisibleText(Category);
        logger.info("Category Selected");
		//driver.findElement(By.xpath("(//select[@name='select'])[1]/option[3] ")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'Select')])[1]/following::input[1]")).click();
		List RadioButton1 = driver.findElements(By.name("patienttype"));
		logger.info("Patient type selected");
        // selecting the Radio buttons by Name
        int Size1 = RadioButton1.size();                
        for(int i=0; i < Size1; i++)                      
       { 
     String val1 =((WebElement) RadioButton1.get(i)).getAttribute("value");
   if (val1.equalsIgnoreCase(patienttype))  
              {                
     ((WebElement) RadioButton1.get(i)).click();
     break;
         }
           }
       // Alert ale=driver.switchTo().alert();
      //  ale.accept();
        //logger.warn("Alert is Accepted");
		driver.findElement(By.xpath("(//input[@id='doc_address1'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@id='doc_address1'])[1]")).sendKeys(Address1);
		logger.info("Address Entered");
		driver.findElement(By.xpath("(//input[@id='doc_address1'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@id='doc_address1'])[2]")).sendKeys(Address2);
		logger.info("Address2Entered");
		driver.findElement(By.id("docpincode")).clear();
		driver.findElement(By.id("docpincode")).sendKeys((PINCode.replaceAll("[^0-9]", "")));
		Thread.sleep(1000);
		WebElement country=driver.findElement(By.id("doccountry"));
		Select coun=new Select(country);
		//country.clear();
		coun.selectByVisibleText(Country);
		//driver.findElement(By.xpath("(//select[@name='select'])[2]/option[contains(text(),'India')]")).click();
		Thread.sleep(1000);
		WebElement stat=driver.findElement(By.id("docstate"));
		Select state=new Select(stat);
		//stat.clear();
		state.selectByVisibleText(State);
		//driver.findElement(By.xpath("//select[@name='select'])[3]/option[contains(text(),'Tamilnadu')]")).click();
		Thread.sleep(2000);
		WebElement city=driver.findElement(By.xpath("(//select[@id='docstate'])[2]"));
		Select cityy=new Select(city);
		cityy.selectByVisibleText(City);
		//driver.findElement(By.xpath("(//select[@id='docstate'])/option[contains(text(),'Chennai')] ")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='docmobile']")).clear();
		driver.findElement(By.xpath("//input[@id='docmobile']")).sendKeys((MobileNumber.replaceAll("[^0-9]", "")));
		Thread.sleep(2000);
		driver.findElement(By.id("docemail")).clear();
		driver.findElement(By.id("docemail")).sendKeys(EmailId);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='docphonenumber'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@id='docphonenumber'])[2]")).sendKeys((PhoneNumber.replaceAll("[^0-9]", "")));
		WebElement submit=driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		Thread.sleep(1000);
		submit.click();
		Thread.sleep(1000);
		logger.info("Submit button clicked");
		System.out.println(submit.isDisplayed());
		//System.out.println(driver.getPageSource());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		takeSnapShot(driver, "E:\\MedeilAutomation\\MedeilLogin\\Screenshots\\addcustomer.png");
		//driver.navigate().to("http://medeilhq.medeil.io/medeilplus/#/CustomerRegistration/ViewCustomer");

	}
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		}
}



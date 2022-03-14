package medeil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","src\\main\\java\\testresource\\chromedriver.exe");
		WebDriver driver=(WebDriver) new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://medeilhq.medeil.io/medeilhq/#/userlogin/login");
	}

}

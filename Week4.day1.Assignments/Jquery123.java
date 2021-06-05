package Week4.day1.Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Jquery123 {
	
//	https://jqueryui.com/sortable/

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		RemoteWebDriver driver = new ChromeDriver(options);
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.switchTo().frame(0);
		
	}

}

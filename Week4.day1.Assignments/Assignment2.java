package Week4.day1.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		 RemoteWebDriver driver = new ChromeDriver();
		 driver.get("http://leafground.com/pages/Calendar.html");
		 driver.manage().window().maximize();
		 
		  WebElement datePicker = driver.findElement(By.id("datepicker"));
		  datePicker.click();
		  WebElement SpecificDate = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tr[3]//td[2]"));
		  SpecificDate.click();
		 
		

	}

}

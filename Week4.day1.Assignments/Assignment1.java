package Week4.day1.Assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 RemoteWebDriver driver = new ChromeDriver();
		 driver.get("http://leafground.com/pages/table.html");
		 driver.manage().window().maximize();
		 
//		 Column Count - in Table
		 List<WebElement> columnCount = driver.findElements(By.xpath("//table[@id='table_id']//th"));
		 System.out.println("The Number of columns in the table are: "+ columnCount.size());
		 
//		 Row Count - in Table
		 List<WebElement> rowCount = driver.findElements(By.xpath("//table[@id='table_id']//tr"));
		 System.out.println("The Number of rows in the table are: "+ rowCount.size());
		 
//		 Progress Value of "Learn to interact with..."
		 String Progress = driver.findElement(By.xpath("//table[@id='table_id']//tr[3]/td[2]")).getText();
		 System.out.println("THe Progress on Learn to Interact with Elements is: " +Progress);
		 
 //		VItal task of the least completed progress..
		 WebElement VitalCheckBox = driver.findElement(By.xpath("//table[@id='table_id']//tr[4]//td[3]//input"));
		 VitalCheckBox.click();
		 
		 
	}

}

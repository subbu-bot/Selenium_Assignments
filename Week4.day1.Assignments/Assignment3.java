//incomplete

package Week4.day1.Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		RemoteWebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.lenskart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement ComputerGlasses = driver.findElement(By.xpath("//a[contains(text(),'Computer Glasses')]"));
		
		Actions builder = new Actions(driver);
		builder.moveToElement(ComputerGlasses).pause(1000).click(driver.findElement(By.xpath("//span[contains(text(),'PREMIUM RANGE')]"))).perform();
		
//		Clicking Round Shaped Frames
		driver.findElement(By.xpath("//span[@title='Round']")).click();
		
//		Click on Frame color with highest count
		driver.findElement(By.xpath("(//div[@class='dropdown'])[3]//li[1]//span")).click();

//		Confirm the count shown in the frame color matches the displayed results count
//		Print the size of the first product (Hint: Mouse hover on the prouct to get the size)
		
		
		
		
	}

}

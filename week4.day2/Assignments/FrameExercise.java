package Week4.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameExercise {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 RemoteWebDriver driver = new ChromeDriver();
		 driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		 driver.manage().window().maximize();
		 
//		 Switch to Frame and Click TryIt
		 driver.switchTo().frame("iframeResult");
		 driver.findElement(By.xpath("/html/body/button")).click();
//		 driver.switchTo().defaultContent();
		 
//		 Sending keys to the prompt box
		 Alert alerts = driver.switchTo().alert();
		 alerts.sendKeys("Subbu");
		 alerts.accept();
		 
		 String Text = driver.findElement(By.id("demo")).getText();
		 
		if(Text.contains("Subbu")) {
			System.out.println("Yes. The name subbu is present");
		}
		else {
			System.out.println("No name");
		}
		 
		 
	}

}

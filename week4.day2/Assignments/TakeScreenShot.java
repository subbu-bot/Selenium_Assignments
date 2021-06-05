package Week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenShot {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		 RemoteWebDriver driver = new ChromeDriver();
		 driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		 //Source file ./
		 File source = driver.getScreenshotAs(OutputType.FILE);
		 
		 //target file ./ represents root project name
		 File target = new File("./snaps/sampleImage.png");
		 
		//target file ./ represents root project name
		 FileUtils.copyDirectory(source, target);
	}

}

package Week4.day1.Assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class eRail {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		RemoteWebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://erail.in/");

		driver.findElementByXPath("//input[@id='chkSelectDateOnly']").click();

		WebElement Source = driver.findElementByXPath("//input[@id='txtStationFrom']");
		Source.clear();
		Source.sendKeys("MS");
		Source.sendKeys(Keys.TAB);

		WebElement Destination = driver.findElementByXPath("//input[@id='txtStationTo']");
		Destination.clear();
		Destination.sendKeys("DG");
		Destination.sendKeys(Keys.TAB);

		List<WebElement> TrainsList = driver
				.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr");
		ArrayList<String> TrainNameList = new ArrayList<String>();

		for (int i = 1; i <= TrainsList.size(); i++) {
			String TrainName = driver
					.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr[" + i + "]//td[2]")
					.getText();
			TrainNameList.add(TrainName);
			Collections.sort(TrainNameList);
		}
		System.out.println("Total No. of trains are: " + TrainsList.size());
		System.out.println("List of Trains using Array List");
		System.out.println("===============================");

		for (String EachTrain : TrainNameList) {
			System.out.println(EachTrain);
		}

		Set<String> TrainsSet = new LinkedHashSet<String>();

		for (String EachTrain : TrainNameList) {
			TrainsSet.add(EachTrain);

		}
		System.out.println("");
		System.out.println("(SETS) Total No. of trains are: " + TrainsSet.size());
		System.out.println("List of Trains using Sets");
		System.out.println("===============================");

		for (String EachTrain : TrainsSet) {
			System.out.println(EachTrain);

		}

		Thread.sleep(3000);
		driver.close();

	}
}

package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadModifyCompany {

	public static void main(String[] args) throws InterruptedException {
		
//		To Launch Browser and load the URL
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		
//		Main Form
//		============================================================================================================
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.id("label")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Wireless Electricity A");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Nikola SB");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Tesla SK");
		driver.findElement(By.id("createLeadForm_dataSourceId")).sendKeys("Other");
		WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dropdown = new Select(source);
		dropdown.selectByVisibleText("Direct Mail");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Nikki");
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Mr");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Great");
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("2400000");
		WebElement source2 = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select dropdown2 = new Select(source2);
		dropdown2.selectByValue("IND_HEALTH_CARE");
		driver.findElement(By.id("createLeadForm_ownershipEnumId")).sendKeys("Corporation");
		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("SI001");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Some random Text");
		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("Some random TextSome random Text");
		WebElement source3 = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select dropdown3 = new Select(source3);
		dropdown3.selectByIndex(2);
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("SI001");
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("03/09/86");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("DEPSI001");
		driver.findElement(By.id("createLeadForm_currencyUomId")).sendKeys("GBP");
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("1500");
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("GBPY");
		
//		Contact Information
//		============================================================================================================
		
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys("44");
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("122");
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("8506433");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("subbu.test0@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9566711609");
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("bababu");
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("www.google.com");
		
//		Primary Address
//		============================================================================================================
		
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Ian");
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Sachin");
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("Princes Street");
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("Near Town Centre");
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Ipswich");
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("IP1");
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("IP1 1RJ");
		driver.findElement(By.id("createLeadForm_generalCountryGeoId")).sendKeys("United Kingdom");
		driver.findElement(By.className("smallSubmit")).click();
		
//		Duplicate Lead
//		=============================================================================================================
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Tesla Green Energy");
		driver.findElement(By.className("smallSubmit")).click();
		
		WebElement newCompany = driver.findElement(By.id("viewLead_companyName_sp"));
		String cmpName = newCompany.getText();
		System.out.println(cmpName);
		
		if(cmpName.contains("Tesla Green Energy")) {
			System.out.println("New Lead has been Created, Company name has been Modified");
		} 
		
		else {
			System.out.println("There is some problem with the company name");
		}
	
		Thread.sleep(5000);
		driver.close();
	}

}

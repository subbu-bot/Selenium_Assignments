package week2.day2;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadUsingXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Step1******* Launch the Application
		// *****************************************************************************

		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();

		// Step2**********Enter UserName and Password Using Id
		// Locator*********************************************************

		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");

		// Step3**********Click on Login Button using Class
		// Locator*********************************************************

		driver.findElementByClassName("decorativeSubmit").click();
		String loadedURLTitle = driver.getTitle();
		System.out.println(loadedURLTitle);
		if (loadedURLTitle.equalsIgnoreCase("Leaftaps - TestLeaf Automation Platform"))
		{
			System.out.println("The Application title is verified successfully");

		}
		else {
			System.out.println("The Application title is not matching");

		}
		// Step4********** Click on CRM/SFA
		// Link******************************************************************************
//			driver.findElementByLinkText("CRM/SFA").click();
			driver.findElementByXPath("//div[@id='label']").click();

		// Step5*********** Click on Leads
		// Button*****************************************************************************

		driver.findElementByLinkText("Create Lead").click();

		// Step6a************************Enter all fields in the create lead
		// form*********************************************************************

		driver.findElementByXPath("//input[@id='createLeadForm_companyName']").sendKeys("Telecom");
		driver.findElementByXPath("//input[@id='createLeadForm_firstName']").sendKeys("Stan");
		driver.findElementByXPath("//input[@id='createLeadForm_lastName']").sendKeys("Warinka");
		Select selSource = new Select(driver.findElementByXPath("//select[@id='createLeadForm_dataSourceId']"));
		selSource.selectByVisibleText("Employee");
		driver.findElementByXPath("//input[@id='createLeadForm_firstNameLocal']").sendKeys("Stantheman");
		driver.findElementByXPath("//input[@id='createLeadForm_personalTitle']").sendKeys("Mr");
		driver.findElementByXPath("//input[@id='createLeadForm_generalProfTitle']").sendKeys("Automation QA");
		driver.findElementByXPath("//input[@id='createLeadForm_annualRevenue']").sendKeys("100K");
		Select selIndustry = new Select(driver.findElementByXPath("//select[@id='createLeadForm_industryEnumId']"));
		selIndustry.selectByVisibleText("Insurance");
		Select selOwnership = new Select(driver.findElementByXPath("//select[@id='createLeadForm_ownershipEnumId']"));
		selOwnership.selectByVisibleText("LLC/LLP");
		driver.findElementByXPath("//input[@id='createLeadForm_sicCode']").sendKeys("testSIC");
		driver.findElementByXPath("//textarea[@id='createLeadForm_description']").sendKeys("Test data-Desc1");
		driver.findElementByXPath("//textarea[@id='createLeadForm_importantNote']").sendKeys("testImportfield");
		Select SelMarketCamp = new Select(driver.findElementByXPath("//select[@id='createLeadForm_marketingCampaignId']"));
		SelMarketCamp.selectByVisibleText("Demo Marketing Campaign");

		driver.findElementByXPath("//input[@id='createLeadForm_lastNameLocal']").sendKeys("L");
		driver.findElementByXPath("//input[@id='createLeadForm_birthDate']").sendKeys("01/01/1995");

		driver.findElementByXPath("//input[@id='createLeadForm_departmentName']").sendKeys("Elect");

		Select selPreCurrency = new Select(driver.findElementByXPath("//select[@id='createLeadForm_currencyUomId']"));
		selPreCurrency.selectByVisibleText("BSD - Bahaman Dollar");

		driver.findElementByXPath("//input[@id='createLeadForm_numberEmployees']").sendKeys("25");
		driver.findElementByXPath("//input[@id='createLeadForm_tickerSymbol']").sendKeys("4");

		// Step6b*******************contact
		// information***************************************************************

		driver.findElementByXPath("//input[@id='createLeadForm_primaryPhoneCountryCode']").clear();
		driver.findElementByXPath("//input[@id='createLeadForm_primaryPhoneCountryCode']").sendKeys("+1");

		driver.findElementByXPath("//input[@id='createLeadForm_primaryPhoneAreaCode']").sendKeys("216");

		driver.findElementByXPath("//input[@id='createLeadForm_primaryPhoneExtension']").sendKeys("440");

		driver.findElementByXPath("//input[@id='createLeadForm_primaryEmail']").sendKeys("TestSam@gmail.com");

		driver.findElementByXPath("//input[@id='createLeadForm_primaryPhoneNumber']").sendKeys("1234567890");
		driver.findElementByXPath("//input[@id='createLeadForm_primaryPhoneAskForName']").sendKeys("SamAssistant");

		driver.findElementByXPath("//input[@id='createLeadForm_primaryWebUrl']").sendKeys("http://dummyurl.com");

		// Step6c*******************Primary
		// Addresss***************************************************************

		driver.findElementByXPath("//input[@id='createLeadForm_generalToName']").sendKeys("primarynametest");
		driver.findElementByXPath("//input[@name='generalAddress1']").sendKeys("ColumbusRoad");

		driver.findElementByXPath("//input[@id='createLeadForm_generalCity']").sendKeys("Naperville");

		driver.findElementByXPath("//input[@id='createLeadForm_generalPostalCode']").sendKeys("9999");

		driver.findElementByXPath("//input[@id='createLeadForm_generalPostalCodeExt']").sendKeys("8999");

		// driver.findElementByXPath("//input[@id='createLeadForm_annualRevenue']")
		// driver.findElementByXPath("//select[@id='createLeadForm_marketingCampaignId']")

		driver.findElementByXPath("//input[@id='createLeadForm_generalAttnName']").sendKeys("GenAtten");

		driver.findElementByXPath("//input[@id='createLeadForm_generalAddress2']").sendKeys("Address2");

		Select selState = new Select(driver.findElementById("createLeadForm_generalStateProvinceGeoId"));
		selState.selectByVisibleText("Arkansas");

		Select selCountry = new Select(driver.findElementById("createLeadForm_generalCountryGeoId"));
		selCountry.selectByVisibleText("United States");

		driver.findElementByClassName("smallSubmit").click();
		// Step7********************Duplicate Lead
		// button***************************************************************
		driver.findElementByLinkText("Duplicate Lead").click();

		String existingCompanyName = driver.findElementById("createLeadForm_companyName").getAttribute("value");

		System.out.println("Existing Company Name" + existingCompanyName);

		driver.findElementById("createLeadForm_companyName").clear();
		driver.findElementById("createLeadForm_companyName").sendKeys("Airtel");

		String modifiedCompanyname = driver.findElementById("createLeadForm_companyName").getAttribute("value");

		if (!existingCompanyName.equalsIgnoreCase("Verizon")) {

			System.out.println("Company name modified from " + "\t" + existingCompanyName + "\n"
					+ " to new company name" + "\t" + modifiedCompanyname);

			driver.findElementByClassName("smallSubmit").click();
			driver.close();

		}

		else
			System.out.println("Company name not modified");

	}

}

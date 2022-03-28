package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		/*
		 * http://leaftaps.com/opentaps/control/main
		 * 
		 * 1 Launch the browser 2 Enter the username 3 Enter the password 4 Click Login
		 * 5 Click crm/sfa link 6 Click Leads link 7 Click Find leads 8 Enter first name
		 * 9 Click Find leads button 10 Click on first resulting lead 11 Verify title of
		 * the page 12 Click Edit 13 Change the company name 14 Click Update 15 Confirm
		 * the changed name appears 16 Close the browser (Do not log out)
		 */

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		// driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(
				By.xpath("//label[text()='Lead ID:']/parent::div/following-sibling::div//input[@name='firstName']"))
				.sendKeys("narendran");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(
				"//table[contains(@class,'table')]//tr//div[contains(@class,'Id')]/a[contains(@href,'viewLead')]"))
				.click();
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.linkText("Edit")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		String changeCompName = "HelloWorld";
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(changeCompName);
		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(10000);
		String capturedCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (capturedCompanyName.contains(changeCompName)) {
			System.out.println("changed name appears");
		}
		driver.close();

	}

}

package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLeadNew {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		/*
		 * http://leaftaps.com/opentaps/control/main
		 * 
		 * 1 Launch the browser 2 Enter the username 3 Enter the password 4 Click Login
		 * 5 Click crm/sfa link 6 Click Leads link 7 Click Find leads 8 Click on Email 9
		 * Enter Email 10 Click find leads button 11 Capture name of First Resulting
		 * lead 12 Click First Resulting lead 13 Click Duplicate Lead 14 Verify the
		 * title as 'Duplicate Lead' 15 Click Create Lead 16 Confirm the duplicated lead
		 * name is same as captured name 17 Close the browser (Do not log out)
		 * 
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
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("narendranmurali@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(10000);
		String leadID = driver.findElement(By.xpath(
				"//table[contains(@class,'table')]//tr//div[contains(@class,'Id')]/a[contains(@href,'viewLead')]"))
				.getText();
		String leadName = driver.findElement(By.xpath(
				"//table[contains(@class,'table')]//tr//div[contains(@class,'firstName')]/a[contains(@href,'viewLead')]"))
				.getText();
		System.out.println(leadID);
		System.out.println(leadName);
		driver.findElement(By.xpath(
				"//table[contains(@class,'table')]//tr//div[contains(@class,'Id')]/a[contains(@href,'viewLead')]"))
				.click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		Thread.sleep(10000);
		String title = driver.getTitle();
		if (title.contains("Duplicate Lead")) {
			System.out.println(title);
		}
		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(10000);
		String capturedFirstName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if (capturedFirstName.equals(leadName)) {
			System.out.println("duplicated lead name is same as captured name");
		}
		driver.close();

	}

}

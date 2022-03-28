package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		/*
		 * Delete Lead: 1 Launch the browser 2 Enter the username 3 Enter the password 4
		 * Click Login 5 Click crm/sfa link 6 Click Leads link 7 Click Find leads 8
		 * Click on Phone 9 Enter phone number 10 Click find leads button 11 Capture
		 * lead ID of First Resulting lead 12 Click First Resulting lead 13 Click Delete
		 * 14 Click Find leads 15 Enter captured lead ID 16 Click find leads button 17
		 * Verify message "No records to display" in the Lead List. This message
		 * confirms the successful deletion 18 Close the browser (Do not log out)
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
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("1234567890");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(10000);
		String leadID = driver
				.findElement(By.xpath("//table[contains(@class,'table')]//tr//div[contains(@class,'Id')]/a[contains(@href,'viewLead')]"))
				.getText();
		System.out.println(leadID);
		driver.findElement(By.xpath("//table[contains(@class,'table')]//tr//div[contains(@class,'Id')]/a[contains(@href,'viewLead')]")).click();
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.name("id")).sendKeys(leadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(10000);
		String message = driver.findElement(By.className("x-paging-info")).getText();
		if (message.contains("No records to display")) {
			System.out.println("Message 01 - No records to display - is dispayed");

		}
		boolean isDisplayed = driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed();
		if (isDisplayed) {
			System.out.println("Message02 - No records to display - is dispayed");
		}
		driver.close();

	}

}

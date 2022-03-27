package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		// driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("NarendranTestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Narendran");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Murali");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("NarendranLocal");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("NarendranDepartment");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("NarendranDescription");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("NarendranMurali@gmail.com");
		WebElement ddElement = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select dd = new Select(ddElement);
		dd.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(5000);
		String title = driver.getTitle();
		System.out.println("Title is : " + title);
		driver.close();

	}

}

package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FaceBook {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Create New Account")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("firstname")).sendKeys("Narendran");
		driver.findElement(By.name("lastname")).sendKeys("Murali");
		driver.findElement(By.xpath("//div[text()='Mobile number or email address']/following-sibling::input"))
				.sendKeys("1234567890");
		driver.findElement(By.xpath("//div[text()='New password']/following-sibling::input")).sendKeys("AsdFgr2020@");

		WebElement dayWebElement = driver.findElement(By.name("birthday_day"));
		WebElement monthWebElement = driver.findElement(By.name("birthday_month"));
		WebElement yearWebElement = driver.findElement(By.name("birthday_year"));

		Select dayDropDown = new Select(dayWebElement);
		Select monthDropDown = new Select(monthWebElement);
		Select yearDropDown = new Select(yearWebElement);

		dayDropDown.selectByValue("27");
		monthDropDown.selectByIndex(9);
		yearDropDown.selectByValue("1989");

		driver.findElement(By.xpath("//label[text()='Female']/following-sibling::input")).click();

	}

}

package Automationexercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class RBIHoliday {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rbi.org.in/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
		//driver.findElement(By.id("CheckBox1")).click();
		driver.findElement(By.xpath("//button[text()='English']")).click();

		Actions act = new Actions(driver);
		WebElement holiday = driver.findElement(By.partialLinkText("Bank Holidays"));
		act.scrollToElement(holiday).perform();
		act.click(holiday).perform();
		
		Select s = new Select(driver.findElement(By.id("drRegionalOffice")));
		s.selectByVisibleText("Mumbai");
		
		Select s1 = new Select(driver.findElement(By.id("drMonth")));
		s.selectByValue("0");
		 driver.findElement(By.id("btnGo")).click();
		Thread.sleep(10000);
		
		
}

}

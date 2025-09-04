package Automationexercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RbiHolidayListMumbai {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		// Navigate to RBI Holiday Matrix page
		driver.get("https://www.rbi.org.in/Scripts/HolidayMatrixDisplay.aspx");

		Select s = new Select(driver.findElement(By.id("drRegionalOffice")));
		s.selectByVisibleText("Mumbai");

		Select s1 = new Select(driver.findElement(By.id("drMonth")));
		s1.selectByValue("0");
		driver.findElement(By.id("btnGo")).click();
		// Locate the holiday table
		WebElement holidayTable = driver.findElement(By.xpath("(//table[@role='presentation'])[2]/tbody"));

		List<WebElement> li = holidayTable.findElements(By.xpath("(//table[@role='presentation'])[2]/tbody/tr"));
        
		BufferedWriter writer = new BufferedWriter(new FileWriter("./RBI_Holiday_List.txt"));
		 System.out.println("Extracting RBI Holidays...");
		 writer.write("RBI Holidays (Mumbai, All Months)\n\n");
		System.out.println("============fest=================");
		for (WebElement mr :li) {
		System.out.println(mr.getText()+"\n");
		writer.write(mr.getText()+"\n");
		}
		writer.close();
		
				 
		  driver.quit();
	}
}
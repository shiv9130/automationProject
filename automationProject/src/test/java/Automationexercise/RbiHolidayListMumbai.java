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

		// Get all rows
		List<WebElement> rows = holidayTable.findElements(By.tagName("tr"));

		// Prepare file writer
		BufferedWriter writer = new BufferedWriter(new FileWriter("./RBI_Holiday_List.txt"));
		System.out.println("Extracting RBI Holidays...");
		writer.write("RBI Holidays (Mumbai, All Months)\n\n");

		for (WebElement row : rows) {
			// Check if row contains header cells (th)
			List<WebElement> headerCells = row.findElements(By.tagName("th"));

			if (!headerCells.isEmpty()) {
				String headerText = headerCells.get(0).getText().trim();
				System.out.println("\n " + headerText);
				writer.write("\n" + headerText + " \n");
				List<WebElement> cols = driver.findElements(By.tagName("td"));
				int colnum = cols.size();
				System.out.println(colnum);
				for (int mon = 1; mon <= headerCells.size() - 1; mon++) {
					if (!headerText.isEmpty()) {
						for (int i = 6; i <= colnum - 1; i++) {
							String columns = row.findElement(By.xpath("(//td)[" + i + "]")).getText();
							System.out.println(columns + " , " + mon);
						}
					}
				}

				/*
				 * if (columns.size() >= 3) { String dateFull = cols.get(0).getText().trim(); //
				 * e.g., "26 February 2025" String occasion = cols.get(1).getText().trim();
				 * //String occasion1 = cols.get(2).getText().trim();
				 * 
				 * 
				 * String formatted = headerText+" , "+dateFull + " , " + occasion;
				 * System.out.println(formatted); writer.write(formatted + "\n");
				 * 
				 * } }
				 */ }
		}

		writer.close();
		driver.quit();
	}
}

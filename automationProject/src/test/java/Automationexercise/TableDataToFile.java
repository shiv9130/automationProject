package Automationexercise;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class TableDataToFile {
    public static void main(String[] args) throws InterruptedException {
        // Set path to chromedriver
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();

        try {
            // Open the website
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
    		s1.selectByValue("0");
    		 driver.findElement(By.id("btnGo")).click();
    		Thread.sleep(10000);


            // Locate the table
            WebElement table = driver.findElement(By.xpath("//table[@width=\"70%\"]"));

            // Get all rows in the table
            List<WebElement> rows = table.findElements(By.tagName("tr"));

            String filePath = "./tableData.txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

                // Loop through each row
                for (WebElement row : rows) {
                    // Get all columns (cells) in each row
                    List<WebElement> cols = row.findElements(By.tagName("th"));
                    if (cols.isEmpty()) {
                        cols = row.findElements(By.tagName("td"));
                    }

                    // Combine cell texts with a separator (e.g., tab or comma)
                    StringBuilder rowText = new StringBuilder();
                    for (WebElement col : cols) {
                        rowText.append(col.getText()).append("\t");
                    }

                    // Write the row to the file
                    writer.write(rowText.toString().trim());
                    writer.newLine();
                }
            }

            System.out.println("Table data successfully written to " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

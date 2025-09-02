package Automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class DynamicTableToText {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
        	driver.manage().window().maximize();
    		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.get("https://www.w3schools.com/html/html_tables.asp");
            
            // Locate all rows of the table
            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));

            // Create a FileWriter
            FileWriter writer = new FileWriter("./table_output.txt");

            // Loop through rows
            for (int i = 1; i <= rows.size(); i++) {
                // Get all cells for current row
                List<WebElement> cells = driver.findElements(By.xpath("//table[@id='customers']//tr[" + i + "]//th | //table[@id='customers']//tr[" + i + "]//td"));

                for (WebElement cell : cells) {
                    writer.write(cell.getText() + "\t"); // Separate columns with tabs
                }
                writer.write("\n"); // New line after each row
            }

            writer.close();
            System.out.println("Table data extracted successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}


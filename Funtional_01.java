package testcases;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class Funtional_01 
	{
	    public static void main(String[] args) throws IOException {
	        // Set the path to the ChromeDriver executable
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

	        // Create a new instance of the Chrome driver
	        WebDriver driver = new ChromeDriver();
	        // Open the web application
	        try {
	        driver.get("https://demo.dealsdray.com/");

	        // Find the username and password fields and enter the login credentials
	        WebElement usernameField = driver.findElement(By.id("username"));
	        usernameField.sendKeys("your_username");
	        
	        WebElement passwordField = driver.findElement(By.id("password"));
	        passwordField.sendKeys("your_password");

	     // Click on the login button
            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
            loginButton.click();

            // Wait for the page to load after login
            Thread.sleep(2000);

            // Upload XLS file
            WebElement fileInput = driver.findElement(By.id("fileInput"));
            fileInput.sendKeys("path/to/demo-data.xlsx");

            // Perform validations on the page
            // (Add relevant validation steps based on your application)

            // Take a screenshot of the final output page
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("path/to/final_output_screenshot.png"));

         // Record a video of the entire process (You may use external tools for this)

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
	 }

}

package testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class Automation_01
{
	WebDriver driver;
	@Test()
	@Parameters("browser")
	public void Register(String browser) throws  IOException
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.manage().window().maximize();
		driver.get("https://www.getcalley.com/page-sitemap.xml");
		List<String> resolutions = Arrays.asList("1920x1080", "1366x768", "1536x864", "360x640", "414x896", "375x667");
		for (String resolution : resolutions) 
		{
	    // Set browser window size based on resolution
	    String[] dimensions = resolution.split("x");
	    int width = Integer.parseInt(dimensions[0]);
	    int height = Integer.parseInt(dimensions[1]);
	    driver.manage().window().setSize(new Dimension(width, height));
	    // Capture screenshot and save to the corresponding folder
	    //step 1 down casted
	    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    String folderPath = "path/to/screenshots/" + resolution + "/";
	    File folder = new File(folderPath);
	    folder.mkdirs();
	    String screenshotPath = folderPath + "Screenshot-" + LocalDateTime.now().toString().replace(":", "-") + ".png";
	    FileHandler.copy(screenshotFile, new File(screenshotPath));
		}
		// Close the browser
		driver.quit();				
	
	}
}

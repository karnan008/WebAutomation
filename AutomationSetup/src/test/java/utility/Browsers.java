package utility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Browsers {

	
	public static WebDriver startapplication(WebDriver driver,String browser, String URL) throws  IOException
	{
		if(browser.contains("chrome"))
		{
			WebDriverManager.chromedriver().setup();
            ChromeDriverService service = new ChromeDriverService.Builder()
                    .usingAnyFreePort().build();
            service.start();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--detach");
            driver = new ChromeDriver(service, options);

		}else
			if(browser.contains("firefox"))
			{
			//	System.setProperty("webdriver.","./Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}else
				if(browser.contains("Edge"))
				{
					System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
					driver = new EdgeDriver();
				}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);
		return driver;
	}
	
}

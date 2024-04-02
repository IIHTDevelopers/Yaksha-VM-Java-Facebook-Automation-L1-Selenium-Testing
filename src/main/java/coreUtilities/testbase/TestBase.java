package coreUtilities.testbase;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase 
{
	public WebDriver driver;
	
	public void initialize(Map<String, String> map) throws Exception
	{
		
			String browser = map.get("browser");
			if(browser.equalsIgnoreCase("Chrome"))
			{						

		        // Set system property to specify the location of ChromeDriver
		        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		        ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
		        options.addArguments("--disable-notifications");
				driver = new ChromeDriver(options);
			}
			else if(browser.equalsIgnoreCase("Firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("ChromeHeadless"))
			{
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("intl.accept_languages", "qps-ploc,en-us,en");
				prefs.put("download.default_directory", map.get("downloadlocation"));
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--headless=new");
				options.addArguments("--start-maximized");
				options.addArguments("--window-size=1920, 1080");
				options.addArguments("--test-type");
				options.addArguments("--disable-gpu");
				options.addArguments("--no-first-run");
				options.addArguments("--no-default-browser-check");
				options.addArguments("--ignore-certificate-errors");
				options.addArguments("--disable-extensions");
			    options.addArguments("--proxy-server='direct://'");
			    options.addArguments("--proxy-bypass-list=*");
				options.addArguments("--no-sandbox");
				options.addArguments("--allow-insecure-localhost");
				options.setCapability("acceptInsecureCerts", true);
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36");
				options.addArguments("enable-automation");
				options.addArguments("--dns-prefetch-disable");
				options.addArguments("--remote-allow-origins=*");//Allowing for remote access
				options.setPageLoadStrategy(PageLoadStrategy.EAGER);
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
			}
			else if(browser.equalsIgnoreCase("FirefoxHeadless"))
			{
				FirefoxOptions options = new FirefoxOptions();
				options.addPreference("intl.accept_languages", "qps-ploc,en-us,en");
				options.addArguments("--headless");
				options.addArguments("--disable-gpu");
				options.addArguments("--no-sandbox");
				options.addArguments("--allow-insecure-localhost");
				options.addArguments("--window-size=1440, 900");
				options.setCapability("acceptInsecureCerts", true);
				driver = WebDriverManager.firefoxdriver().capabilities(options).create();
			}
			else if(browser.equalsIgnoreCase("Safari"))
			{
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
			}
			else
				throw new Exception("Not a valid browser. Select a valid browser like Chrome, Firefox, ChromeHeadless");
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(map.get("url"));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(map.get("pageloadtimeout"))));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(map.get("implicitwaittime"))));
		}
		
	
	public void browserTearDown()
	{
		System.out.println("before closing the browser");
		driver.quit();
		System.out.println("after closing the browser");
	}
	
	
	private boolean isValidUrl(String url)
	{
		try
		{
			URL uri = new URL(url);
		    HttpURLConnection.setFollowRedirects(false);
		    HttpURLConnection httpURLConnection = (HttpURLConnection) uri.openConnection();
		    httpURLConnection.setRequestMethod("HEAD");
		    httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2 (.NET CLR 3.5.30729)");
		    int responseCode = httpURLConnection.getResponseCode();
		    return responseCode == HttpURLConnection.HTTP_OK;
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
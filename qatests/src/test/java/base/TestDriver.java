package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.Utils;


import org.testng.ITestResult;

public class TestDriver {
	public static WebDriver driver;
	public static Properties testdata = new Properties();
	public static FileInputStream fis, fis_testdata;
	public static WebDriverWait wait;
	
	public static String testname;
	public static ExtentReports report; // for Extent Report
	public static ExtentTest test;// for Extent Report
	private static final String DASHBOARDUI = "dash";
	public static String screenTaken = null;
	
	public DesiredCapabilities cap;
	
	
	@BeforeSuite(alwaysRun = true)
	public void setup() throws IOException {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

	    report = new ExtentReports(System.getProperty("user.dir") + "/reports/" + sdf.format(cal.getTime())+"_ui.html", true); // for Extent Report
		
				fis_testdata = new FileInputStream(
						System.getProperty("user.dir") + "//src//test//resources//properties//config.properties");
				testdata.load(fis_testdata);
    
	}


	@BeforeMethod(alwaysRun = true)
	public void checktestexcutable(Method method) throws Exception {
		
	
			 //import java.util.Locale;)	

		test = report.startTest(method.getName());
		ChromeOptions co = new ChromeOptions();
		 if(System.getProperty("os.name").toLowerCase().equals("linux")) {
			 co.addArguments("--headless");
			 co.addArguments("--disable-gpu");
			 co.addArguments("--no-sandbox");
			 co.addArguments("enable-logging");
		      co.addArguments("--start-fullscreen");
		      co.addArguments("--incognito");
		      System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
			 
	     
		 }else {
			 co.addArguments("enable-logging");
		      co.addArguments("--start-fullscreen");
		      co.addArguments("--incognito");
		      System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//chromedriver");
		      
		 }  
	      cap = DesiredCapabilities.chrome();
	      cap.setCapability(ChromeOptions.CAPABILITY, co);
		 driver = new ChromeDriver(co);
		
		wait = new WebDriverWait(driver, 15);
		driver.navigate().to(testdata.getProperty(DASHBOARDUI));
		driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);

	}

	@AfterMethod()
	public void teardown(ITestResult result) throws Exception {	
		String originalMessage = null;

		if (result.getStatus() == ITestResult.FAILURE) {
			
			
			Throwable throwable = result.getThrowable();
			
			originalMessage = throwable.getMessage();
		
			if(screenTaken != "Yes") {
              test.log(LogStatus.FAIL, originalMessage+test.addBase64ScreenShot(Utils.CaptureScreen(driver)));
			}else {
				test.log(LogStatus.FAIL, "");
			}
		} else {
			
			test.log(LogStatus.PASS, result.getName() + " Test is PASS ");
		}
		driver.quit();
	}

	@AfterSuite(alwaysRun = true)
	public void suit_end() throws Exception {
		
		report.endTest(test);
		report.flush();
	}

}

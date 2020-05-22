package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/Object.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	@BeforeTest
	public void init() throws IOException {
		//driver initialization using chrome browser
		driver = Browser.openBrowser("Chrome");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//launching web url which is defined in properties file
		driver.get(prop.getProperty("url"));

	}



	@AfterTest
	public void afterSuite() {
		if(null != driver) {
			driver.close();
			driver.quit();
		}
	}

}


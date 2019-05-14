package BaseClassPkg;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	public static WebDriver driver;

	public static Properties prop;

	public BaseClass() {
		prop=new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\Kumar kush ranjan\\git\\TestingPOC\\maven_test\\src\\test\\java\\Configuration\\config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*BaseClass b=new BaseClass();*/
	
	public  void startbrowse() {
		String brwserName = "chrome";
		if (brwserName.equals(prop.getProperty("Browser"))) {
			System.setProperty("webdriver.chrome.driver",
					"G:\\Selenium tutorial chennai\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(prop.getProperty("url"));

		} else {
			System.out.println("\n Did not match from config file");
		}
	}

}

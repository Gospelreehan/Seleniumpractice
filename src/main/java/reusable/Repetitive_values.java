package reusable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Hybridframeprac.registeer.Homepage;
import Hybridframeprac.registeer.Loginpage;
import Hybridframeprac.registeer.Register;

public class Repetitive_values {
	public Register registerPage;
	public Homepage hp;
	public Loginpage lp;

//	public Logger logger = LogManager.getLogger(Repetitive_values.class);
	public Properties prop;
	public FileInputStream fs;
	WebDriver driver;

	@BeforeTest
	@Parameters({ "browser" })
	public void setup(String browname) throws IOException {
		prop=new Properties();
		fs=new FileInputStream("./src//test//resources//data.properties");
		prop.load(fs);
		switch (browname.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "chromeheadless":
			ChromeOptions  options = new ChromeOptions();
			  options.addArguments("--headless"); // run without UI
			    options.addArguments("--window-size=1920,1080");
			    driver = new ChromeDriver(options);
			    break;

		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("soeem error");

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
//		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		driver.get(prop.getProperty("baseurl"));
		

		// Initialize Page Object
		registerPage = new Register(driver);
		hp=new Homepage(driver);
		lp=new Loginpage(driver);
	}

	public String getRandomString() {
		String name = RandomStringUtils.randomAlphabetic(4);
		System.out.println(name);
		return name;
	}

	public String getRandomnumber() {
		return RandomStringUtils.randomNumeric(10);

//		        return name;
	}

	public String getRandomalphanumeric() {
		String pass = RandomStringUtils.randomAlphanumeric(10);

		return pass;
	}

//	@AfterTest
//	public void tearDown() {
//		if (driver != null) {
//			driver.quit();
//		}
	 public String getScreenshot(String methodName) {
	        // generate timestamp
	        String currentTimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	        // capture screenshot
	        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	        // build target file path
	        String targetFilePath = System.getProperty("user.dir") 
	                                + "\\screenshots\\" 
	                                + methodName + "_" + currentTimeStamp + ".png";

	        File targetFile = new File(targetFilePath);

	        try {
	            FileUtils.copyFile(srcFile, targetFile);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        // return path so ExtentReports can attach it
	        return targetFilePath;
	    }

	}



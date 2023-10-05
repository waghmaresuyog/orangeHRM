package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pageLayer.LoginPage;

import java.time.Duration;

public class TestBase {
    public static WebDriver driver;
    public LoginPage loginPage;

    //Parameters annotation use to take value from xml file and pass to method
    @Parameters("browser")
    @BeforeMethod       // this annotation is use for run  before any test and start method use to open Browser
    public void start(String browser) {
        //String browser = "firefox";
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            //WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver", "C:/Users/Suyog.Waghmare/Desktop/Driver/chromedriver-win64/chromedriver.exe");
            // WebDriver driver = new ChromeDriver();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().deleteAllCookies();
        loginPage = new LoginPage(driver);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }

}

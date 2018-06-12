
import java.io.File;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class css01_LoginTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    public css01_LoginTest() {
     //   System.setProperty("webdriver.gecko.driver", "C:\\Program Files (x86)\\Gecko\\geckodriver-v0.17.0-win64\\geckodriver.exe");
          System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\ChromeDriver\\chromedriver.exe");
    }

//    @Before
//    public void setUp() throws Exception {
//        File pathBinary = new File("C:\\Program Files (x86)\\Mozilla Firefox 52.6.0\\firefox.exe");
//        FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
//        DesiredCapabilities desired = DesiredCapabilities.firefox();
//        FirefoxOptions options = new FirefoxOptions();
//        desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
//        driver = new FirefoxDriver(options);
//
//        //driver = new FirefoxDriver();
//        baseUrl = "http://localhost/";
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    }
     @Before
  public void setUp() throws Exception {
    driver = new ChromeDriver();
     baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
    

    @Test
    public void testCss01Login() throws Exception {
        driver.get(baseUrl + "/wordpress/wp-login.php");
        String login = "chrissi";
        String pass = "heutekommt";
        driver.findElement(By.cssSelector("#user_login")).clear();
        driver.findElement(By.cssSelector("#user_login")).sendKeys(login);
        driver.findElement(By.cssSelector("#user_pass")).clear();
        driver.findElement(By.cssSelector("#user_pass")).sendKeys(pass);
        driver.findElement(By.id("wp-submit")).click();
        //driver.findElement(By.id("wp-admin-bar-my-account")).click(); 
        Thread.sleep (1000);
        //driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
        driver.findElement(By.cssSelector("span.display-name")).click();
    }

    @After
    public void tearDown() throws Exception {
        //Browserfenster nicht schließen!!!
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}

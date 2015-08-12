import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class LoginTest {
    public static final String REG_EMAIL = "reg_email";
    public static final String EMAIL = "qwe1@ww.com";
    public static final String REG_PASSWORD = "reg_password";
    public static final String PASSWORD = "123qwe";
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        baseUrl = "http://luciana.integro.kiev.ua/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Setup completed");
    }

    @Test
    public void positiveLoginTest() throws Exception {
        driver.get(baseUrl + "/?page_id=9");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("a")).click();

        cleanAndType(REG_EMAIL, EMAIL);
        cleanAndType(REG_PASSWORD, PASSWORD);

        driver.findElement(By.name("register")).click();
    }

    private void cleanAndType(String id, String value) {
        driver.findElement(By.id(id)).clear();
        driver.findElement(By.id(id)).sendKeys(value);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }


}

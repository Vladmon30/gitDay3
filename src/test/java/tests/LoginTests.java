package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
// Login tests
//Witthout PAge object
public class LoginTests {
WebDriver driver;

@BeforeClass
public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
// Test 1 for loogin
@Test
    public void loginTest1(){
    driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ login.aspx");
    driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
    driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);

    Assert.assertEquals(driver.getTitle(), "Web Orders");
}
    @Test
    public void negativeLoginTest(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester2");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test2" + Keys.ENTER);

        String errorMsg = driver.findElement(By.id("ctl00_MainContent_status")).getText();
        Assert.assertEquals(errorMsg,"Invalid Login or Password.");
    }
// Test 2 for logout
@Test
    public void logOutTest()
{
    driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ login.aspx");
    driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
    driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);
}
// After method for closing browser
    @AfterMethod
    public void cleanUp(){
        driver.close();
        driver.quit();

    }
}

package automationexercises;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test07 {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Test Cases' button
    //5. Verify user is navigated to test cases page successfully
    WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationexercise.com");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {
//3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement gorunurMu = driver.findElement(By.cssSelector("html[lang='en']"));
        Assert.assertTrue(gorunurMu.isDisplayed());
//4. 'Test Durumları' düğmesine tıklayın
        driver.findElement(By.cssSelector("a[href='/test_cases']")).click();
//5. Kullanıcının test senaryoları sayfasına başarıyla yönlendirildiğini doğrulayın
        WebElement yonlendirildiMi = driver.findElement(By.cssSelector("div[class='row']"));
        Assert.assertTrue(yonlendirildiMi.isDisplayed());

    }
}
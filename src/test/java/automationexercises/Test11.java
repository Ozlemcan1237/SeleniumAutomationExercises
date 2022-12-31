package automationexercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test11 {
    WebDriver driver;
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        //3. Verify that home page is visible successfully
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement anaSayfa = driver.findElement(By.xpath("//*[@lang='en']"));
        Assert.assertTrue(anaSayfa.isDisplayed());

        //4. Click 'Cart' button
        //4. 'Sepet' düğmesine tıklayın
        driver.findElement(By.xpath("(//*[@href='/view_cart'])[1]")).click();

        //5. Scroll down to footer
        //5. Altbilgiye doğru aşağı kaydırın
        //WebElement footer = driver.findElement(By.xpath("//*[@class='footer-bottom']"));


//           JavascriptExecutor js = (JavascriptExecutor) driver; //javascript classi
//           js.executeScript("window.scroll(0,10000)"); //console

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.END);

        //6. Verify text 'SUBSCRIPTION'
        //6. 'ABONELİK' metnini doğrulayın
        WebElement abonelikMetni = driver.findElement(By.xpath("//*[text()='Subscription']"));
        Assert.assertTrue(abonelikMetni.isDisplayed());

        //7. Enter email address in input and click arrow button
        //7. Giriş alanına e-posta adresini girin ve ok düğmesine tıklayın
        driver.findElement(By.id("susbscribe_email")).sendKeys("abc123@gmail.com", Keys.ENTER);


        //8. Verify success message 'You have been successfully subscribed!' is visible
        //8. Başarı mesajını doğrulayın 'Başarılı bir şekilde abone oldunuz!' görünür
        WebElement expectedMesaj = driver.findElement(By.xpath("//*[@class='alert-success alert']"));
       Assert.assertTrue(expectedMesaj.isDisplayed());
        Thread.sleep(3000);
    }
}







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

public class Test10 {
    WebDriver driver;
    @Before
    public void setUp(){
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test01(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement anaSayfa = driver.findElement(By.cssSelector("html[lang='en']"));
        Assert.assertTrue(anaSayfa.isDisplayed());

        //4. Scroll down to footer


        //5. Verify text 'SUBSCRIPTION'
        WebElement abonelikYazisi = driver.findElement(By.xpath("//*[text()='Subscription']"));
        if (abonelikYazisi.isDisplayed()){
            System.out.println("Gorunuyor PASSED");
        }else System.out.println("Gorunmuyor FAILED");

        //6. Enter email address in input and click arrow button
        driver.findElement(By.xpath("//*[@id='susbscribe_email']")).sendKeys("ASD123@gmail.com");
        driver.findElement(By.cssSelector("i[class='fa fa-arrow-circle-o-right']")).click();

        //7. Verify success message 'You have been successfully subscribed!' is visible
        WebElement basariMesaji = driver.findElement(By.xpath("//*[@id='success-subscribe']"));
        if (basariMesaji.isDisplayed()){
            System.out.println("PASS");
        }else System.out.println("FAIL");

    }
}



//1. Tarayıcıyı başlatın
//2. 'http://automationexercise.com' URL'sine gidin
//3. Ana sayfanın başarıyla göründüğünü doğrulayın
//4. Altbilgiye doğru aşağı kaydırın
//5. 'ABONELİK' metnini doğrulayın
//6. Giriş alanına e-posta adresini girin ve ok düğmesine tıklayın
//7. Başarı mesajını doğrulayın 'Başarılı bir şekilde abone oldunuz!' görünür
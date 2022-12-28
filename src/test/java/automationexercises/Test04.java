package automationexercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.crypto.modes.KCCMBlockCipher;
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

public class Test04 {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }

    @Test
    public void test01() throws InterruptedException {
        //3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.cssSelector("html[lang='en']"));
        if (logo.isDisplayed()){
            System.out.println("Test PASS");
        }else System.out.println("Test FAIL");

        //4. Click on 'Signup / Login' button
        driver.findElement(By.cssSelector("a[href='/login']")).click();

        //5. Verify 'Login to your account' is visible
        WebElement loggedYazisi = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(loggedYazisi.isDisplayed());

        //6. Enter correct email address and password   //7. Click 'login' button
        driver.findElement(By.xpath("(//*[@type='email'])[1]")).sendKeys("sssss@gmail.com",  Keys.ENTER);
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("54321",Keys.ENTER,Keys.TAB,"login");

        //7. 'Giriş' düğmesine tıklayın
        //driver.findElement(By.xpath("//*[text()='Login']")).click();

        //8. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        WebElement actualLogin = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(actualLogin.isDisplayed());

        //9. 'Çıkış' düğmesini tıklayın
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@href='/logout']")).click();

        //10. Kullanıcının oturum açma sayfasına yönlendirildiğini doğrulayın
        Thread.sleep(2000);
        WebElement oturumAcmaSayfasi = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(oturumAcmaSayfasi.isDisplayed());
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
       driver.quit();
    }
}
//1. Tarayıcıyı başlatın
//2. 'http://automationexercise.com' URL'sine gidin
//3. Ana sayfanın başarıyla göründüğünü doğrulayın
//4. 'Kaydol / Giriş Yap' düğmesine tıklayın
//5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
//6. Doğru e-posta adresini ve şifreyi girin
//7. 'Giriş' düğmesine tıklayın
//8. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
//9. 'Çıkış' düğmesini tıklayın
//10. Kullanıcının oturum açma sayfasına yönlendirildiğini doğrulayın

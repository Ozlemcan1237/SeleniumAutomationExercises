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

public class Test02 {


    //1. Tarayıcıyı başlatın
    //2. 'http://automationexercise.com' URL'sine gidin
    //3. Ana sayfanın başarıyla göründüğünü doğrulayın
    //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
    //5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayınteam1234@gmail.com
    //6. Doğru e-posta adresini ve şifreyi girin
    //7. 'Giriş' düğmesine tıklayın
    //8. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
    //9. 'Hesabı Sil' düğmesini tıklayın
    //10. 'HESAP SİLİNDİ!' görünür
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com"); //2
        //driver.switchTo().alert().accept(); //reklamlari kapatmak icin
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test01() {

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement anaSayfa = driver.findElement(By.cssSelector("html[lang='en']"));
        if (anaSayfa.isDisplayed()) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");

        // 4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //5. 'Hesabınıza giriş yap' seçeneğinin görünür olduğunu doğrulayın
        WebElement hesabinizaGrsGorunurMu= driver.findElement(By.xpath("//*[@class='login-form']"));
        if (hesabinizaGrsGorunurMu.isDisplayed()){
            System.out.println("PASSED");
        }else System.out.println("FAILED");

        //6. Doğru e-posta adresini ve şifreyi girin
        driver.findElement(By.xpath("(//*[@placeholder='Email Address'])[1]")).sendKeys("ozlemmm@gmail.com", Keys.TAB,"1234567");

        // 7. 'Giriş yap' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@class='btn btn-default']")).click();

        //8. 'Kullanıcı adı olarak oturum açtınız' seçeneğinin görünür olduğunu doğrulayın
        WebElement loggedInAs = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        if (loggedInAs.isDisplayed()){
            System.out.println("PASSED");
        }else System.out.println("FAILED");

        // 9. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();

        //10. HESABIN silindiğini doğrulayın!' görünür
        WebElement hesapSilindiMi = driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
        if (hesapSilindiMi.isDisplayed()){
            System.out.println("PASSED");
        }else System.out.println("FAILED");
    }
}

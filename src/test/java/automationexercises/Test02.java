package automationexercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
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
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException { //3 Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement anaSayfa = driver.findElement(By.cssSelector("html[lang='en']"));
        Assert.assertTrue(anaSayfa.isDisplayed());

        //4 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //5 "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
        WebElement hesapGirisi = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(hesapGirisi.isDisplayed());

        //6 Doğru e-posta adresini ve şifreyi girin
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("team1234@gmail.com");
        WebElement pwd = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        pwd.sendKeys("123456");
//        WebElement name = driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
//        name.sendKeys("team");
//        WebElement email2 = driver.findElement(By.xpath("//*[@data-qa='signup-email']"));
//        email2.sendKeys("team123@gmail.com");

        //7 'Giriş' düğmesine tıklayın
        //Thread.sleep(3000);
        WebElement loginButton = driver.findElement(By.xpath("//*[@data-qa='login-button']"));
        loginButton.click();

        //8 "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        WebElement loggedInYazisi = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(loggedInYazisi.isDisplayed());

        //9 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();

        //10 'HESAP SİLİNDİ!' görünür
        WebElement hesapSilindiYazisi = driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
        Assert.assertTrue(hesapSilindiYazisi.isDisplayed());
    }
}

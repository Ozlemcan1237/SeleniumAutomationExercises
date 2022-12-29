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

public class Test05 {

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
    public void test01() {
        //3. Verify that home page is visible successfully
        WebElement anasayfa = driver.findElement(By.xpath("//*[@lang='en']"));
        Assert.assertTrue(anasayfa.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement yeniKullanici = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(yeniKullanici.isDisplayed());

        //6. Enter name and already registered email address //7. Click 'Signup' button
        driver.findElement(By.xpath("//*[@placeholder='Name']")).sendKeys("Ali", Keys.TAB,"team1234@gmail.com",Keys.ENTER);

        //8. 'E-posta Adresi zaten mevcut!' hatasını doğrulayın. görünür
        WebElement epostaKayıtlı = driver.findElement(By.xpath("//*[text()='Email Address already exist!']"));
        Assert.assertTrue(epostaKayıtlı.isDisplayed());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
//1. Tarayıcıyı başlatın
//2. 'http://automationexercise.com' URL'sine gidin
//3. Ana sayfanın başarıyla göründüğünü doğrulayın
//4. 'Kaydol / Giriş Yap' düğmesine tıklayın
//5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
//6. Adı ve kayıtlı e-posta adresini girin
//7. 'Kaydol' düğmesini tıklayın
//8. 'E-posta Adresi zaten mevcut!' hatasını doğrulayın. görünür
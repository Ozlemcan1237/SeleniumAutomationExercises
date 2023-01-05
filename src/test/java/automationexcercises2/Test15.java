package automationexcercises2;

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

public class Test15 {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
    }
    @Test
    public void test01() throws InterruptedException {
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement logo = driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logo.isDisplayed());

        //4. 'Kaydol / Giriş Yap' düğmesini tıklayın
        driver.findElement(By.cssSelector("a[href='/login']")).click();

        //5. Kaydol'daki tüm ayrıntıları doldurun ve hesap oluşturun
        driver.findElement(By.cssSelector("input[data-qa='signup-name']")).sendKeys("Kübra", Keys.ENTER);
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys("team07iyikivar@gmail.com", Keys.ENTER);
        driver.findElement(By.xpath("//form[@action='/signup']")).click();

        //6. 'HESAP OLUŞTURULDU!'nu doğrulayın. ve 'Devam Et' düğmesini tıklayın
        driver.findElement(By.cssSelector("input[id='id_gender2']")).click();
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("12345", Keys.TAB, "26", Keys.TAB, "December", Keys.TAB, "2021");
        driver.findElement(By.cssSelector("input[id='newsletter']")).click();
        driver.findElement(By.cssSelector("input[id='optin']")).click();
        driver.findElement(By.cssSelector("input[id='first_name']")).sendKeys("Kübra", Keys.TAB, "Durmuş", Keys.TAB, "TechPro", Keys.TAB, "Bursa", Keys.TAB, "Nilüfer");
        driver.findElement(By.cssSelector("select[id='country']")).sendKeys("Canada", Keys.TAB, "Osmangazi", Keys.TAB, "Bursa", Keys.TAB, "16", Keys.TAB, "05468");
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
        WebElement görünürMü = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(görünürMü.isDisplayed());
        driver.findElement(By.cssSelector("a[class='btn btn-primary']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[.='Continue']")).click();

        //7. Üstte "Kullanıcı adı olarak oturum açıldı"yı doğrulayın
        WebElement kulAdıAcıldıMı= driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(kulAdıAcıldıMı.isDisplayed());

        //8. Sepete ürün ekleyin
        driver.findElement(By.cssSelector("a[data-product-id='22']")).click();
        driver.findElement(By.cssSelector("button[class='btn btn-success close-modal btn-block']")).click();

        //9. 'Sepet' düğmesine tıklayın
        driver.findElement(By.cssSelector("a[href='/view_cart']")).click();

        //10. Sepet sayfasının görüntülendiğini doğrulayın
        WebElement sepetGörünürMü= driver.findElement(By.cssSelector("li[class='active']"));
        Assert.assertTrue(sepetGörünürMü.isDisplayed());

        //11. Ödeme İşlemine Devam Et'i tıklayın
        driver.findElement(By.cssSelector("a[class='btn btn-default check_out']")).click();

        //12. Adres Ayrıntılarını Doğrulayın ve
        String exceptedDeliveryAdress="YOUR DELIVERY ADDRESS\n" +
                "Mrs. Kübra Durmuş\n" +
                "TechPro\n" +
                "Bursa\n" +
                "Nilüfer\n" +
                "Bursa Osmangazi 16\n" +
                "Canada\n" +
                "05468";
        String actuallAdress=driver.findElement(By.xpath("//*[@class='col-xs-12 col-sm-6']//ul")).getText();
        Assert.assertEquals(actuallAdress,exceptedDeliveryAdress);
        String actuallBıllıngAdress=driver.findElement(By.xpath("(//*[@class='col-xs-12 col-sm-6'])[2]//ul")).getText();
        String exceptedBıllıngAdress="YOUR BILLING ADDRESS\n" +
                "Mrs. Kübra Durmuş\n" +
                "TechPro\n" +
                "Bursa\n" +
                "Nilüfer\n" +
                "Bursa Osmangazi 16\n" +
                "Canada\n" +
                "05468";
        Assert.assertEquals(actuallBıllıngAdress,exceptedBıllıngAdress);
        // Siparişiniz inceleyin
        String siparis= driver.findElement(By.cssSelector("table[class='table table-condensed']")).getText();
        String exceptedSiparis="Long Maxi Tulle Fancy Dress Up Outfits -Pink";
        Assert.assertTrue(siparis.contains(exceptedSiparis));

        //13. Açıklama metin alanına açıklamayı girin ve 'Sipariş Ver'i tıklayın
        driver.findElement(By.cssSelector("textarea[class='form-control']")).sendKeys("Güzel günlerde kullan tatlı kız :)");
        Thread.sleep(1500);
        driver.findElement(By.cssSelector("a[href='/payment']")).click();

        //14. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma Tarihi
        driver.findElement(By.cssSelector("input[class='form-control']")).sendKeys("Kübra Durmuş", Keys.TAB,"261014",Keys.TAB,"014",Keys.TAB,"07",Keys.TAB,"2030");

        //15. 'Öde ve Siparişi Onayla' düğmesine tıklayın
        driver.findElement(By.cssSelector("button[id='submit']")).click();

        //16. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
        String actualbasariMesaji = driver.findElement(By.xpath("//*[text()='Your order has been placed successfully!']")).getText();
        String expectedBasariMesaji = "Siparişiniz başarıyla verildi!";
        Assert.assertEquals(expectedBasariMesaji, actualbasariMesaji);
        Thread.sleep(3000);

        //17. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.cssSelector("a[href='/delete_account']")).click();

        //18. 'HESAP SİLİNDİ!' ve 'Devam Et' düğmesini tıklayın
        WebElement hesapSilindiMi= driver.findElement(By.xpath("//*[.='Account Deleted!']"));
        Assert.assertTrue(hesapSilindiMi.isDisplayed());
        driver.findElement(By.cssSelector("a[class='btn btn-primary']")).click();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
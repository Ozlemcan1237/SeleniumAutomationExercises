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

public class Test14 {

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
    public void test01(){
        //3. Verify that home page is visible successfully
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement anaSayfa = driver.findElement(By.xpath("(//html[@lang='en'])[1]"));
        Assert.assertTrue(anaSayfa.isDisplayed());

        //4. Add products to cart
        //4. Sepete ürün ekleyin
        driver.findElement(By.cssSelector("a[href='/product_details/38']")).sendKeys(Keys.ENTER);
        driver.navigate().refresh();
        driver.navigate().to("https://automationexercise.com/product_details/38");
        driver.findElement(By.xpath("//*[@class='btn btn-default cart']")).click();

        //5. Click 'Cart' button
        //5. 'Sepet' düğmesine tıklayın
        driver.findElement(By.xpath("(//*[@href='/view_cart'])[2]")).click();

        //6. Verify that cart page is displayed
        //6. Sepet sayfasının görüntülendiğini doğrulayın
        WebElement sepetGorunurMu = driver.findElement(By.xpath("//*[text()='Proceed To Checkout']"));
        Assert.assertTrue(sepetGorunurMu.isDisplayed());

        //7. Click Proceed To Checkout
        //7. Ödeme İşlemine Devam Et'i tıklayın
        driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")).click();

        //8. Click 'Register / Login' button
        //8. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("(//a[@href='/login'])[2]")).click();


        //9. Fill all details in Signup and create account
        //9. Kaydol'daki tüm ayrıntıları doldurun ve hesap oluşturun
        driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Hasan",Keys.TAB,"aa234@gmail.com",Keys.ENTER);


        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        //10. 'HESAP OLUŞTURULDU!'nu doğrulayın! ve 'Devam Et' düğmesini tıklayın
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("1234567",Keys.TAB,"1",Keys.TAB,"January",Keys.TAB,"2020");
        driver.findElement(By.id("newsletter")).sendKeys(Keys.ENTER,Keys.TAB,Keys.ENTER);
        driver.findElement(By.id("first_name")).sendKeys("aa",Keys.TAB,"aa",Keys.TAB,"aa",Keys.TAB,"aa",Keys.TAB,"aa",
                Keys.TAB,"Canada",Keys.TAB,"aa",Keys.TAB,"aa",Keys.TAB,"aa",Keys.TAB,"123456789");
        driver.findElement(By.xpath("//*[@data-qa='create-account']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

        //11. Verify ' Logged in as username' at top
        //11. Üstte "Kullanıcı adı olarak oturum açıldı"yı doğrulayın
        WebElement loggedYazisi = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(loggedYazisi.isDisplayed());

        //12.Click 'Cart' button
        //12.'Sepet' düğmesine tıklayın
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        //13. Click 'Proceed To Checkout' button
        //13. 'Ödeme İşlemine Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();

        //14. Verify Address Details and Review Your Order
        //14. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin


        //15. Enter description in comment text area and click 'Place Order'
        //15. Açıklama metin alanına açıklamayı girin ve 'Sipariş Ver'i tıklayın


        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //16. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma Tarihi


        //17. Click 'Pay and Confirm Order' button
        //17. 'Öde ve Siparişi Onayla' düğmesine tıklayın


        //18. Verify success message 'Your order has been placed successfully!'
        //18. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'


        //19. Click 'Delete Account' button
        //19. 'Hesabı Sil' düğmesini tıklayın


        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        //20. 'HESAP SİLİNDİ!' ve 'Devam Et' düğmesini tıklayın


    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
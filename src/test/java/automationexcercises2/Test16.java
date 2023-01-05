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

public class Test16 {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
    }

    @Test
    public void test01() throws InterruptedException {
//3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement actualDisplay = driver.findElement(By.xpath("(//*[@lang='en'])[1]"));
        Assert.assertTrue(actualDisplay.isDisplayed());

//4. 'Kaydol / Giriş Yap' düğmesini tıklayın(Click 'Signup / Login' button)
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        Thread.sleep(500);

//5. E-postayı, şifreyi doldurun ve 'Giriş' düğmesine tıklayın(Fill email, password and click 'Login'button)
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("gulizarssimsek@gmail.com", Keys.ENTER);
        driver.findElement(By.xpath("//*[@data-qa='login-password']")).sendKeys("123.456.78");
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();
        Thread.sleep(300);

//6. En üstte 'Kullanıcı adı olarak oturum açıldı'yı doğrulayın(Verify 'Logged in as username' at top)
        WebElement loggedInAsUsername = driver.findElement(By.xpath("//*[@class='fa fa-user']"));
        Assert.assertTrue(loggedInAsUsername.isDisplayed());
        //7. Sepete ürün ekleyin(Add products to cart)
        driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click();
        driver.findElement(By.xpath("//*[text()='Your product has been added to cart.']")).click();
        Thread.sleep(300);

//8. 'Sepet' düğmesine tıklayın(Click 'Cart' button)
        WebElement cartButton = driver.findElement(By.xpath("(//*[@href='/view_cart'])[2]"));
        cartButton.click();
        Thread.sleep(3000);

        //9. Sepet sayfasının görüntülendiğini doğrulayın
        WebElement cartPage = driver.findElement(By.xpath("//*[@id='cart_info']"));
        Assert.assertTrue(cartPage.isDisplayed());

//10. Ödeme İşlemine Devam Et'i tıklayın( Click Proceed To Checkout)
        driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")).click();

//11. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
        WebElement adres = driver.findElement(By.xpath("//*[text()='Address Details']"));
        Assert.assertTrue(adres.isDisplayed());
        WebElement siparis = driver.findElement(By.xpath("//*[text()='Review Your Order']"));
        Assert.assertTrue(siparis.isDisplayed());

//12. Açıklama metin alanına açıklamayı girin ve 'Sipariş Ver'i tıklayın
// Verify Address Details and Review Your Order
        driver.findElement(By.xpath("//*[@name='message']")).sendKeys("Basarili bir site degilsiniz");
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();

//13. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma Tarihi
// Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//*[@data-qa='name-on-card']")).sendKeys("Gulizar Sahin");
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("123456789");
        driver.findElement(By.xpath("//input[@placeholder='ex. 311']")).sendKeys("103");
        driver.findElement(By.xpath("//input[@placeholder='MM']")).sendKeys("25");
        driver.findElement(By.xpath("//input[@placeholder='YYYY']")).sendKeys("324");

//14. 'Öde ve Siparişi Onayla' düğmesine tıklayın(Click 'Pay and Confirm Order' button)
        driver.findElement(By.xpath("//*[@id='submit']")).click();

        //15. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!
//( Verify success message 'Your order has been placed successf //15. Verify success message 'Your order has been placed successfully!
        WebElement success = driver.findElement(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']"));
        Assert.assertTrue(success.isDisplayed());

        //16. 'Hesabı Sil' düğmesini tıklayın(Click 'Delete Account' button)
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();

//17. 'HESAP SİLİNDİ!' ve 'Devam Et' düğmesini tıklayın
//( 17. Verify 'ACCOUNT DELETED!' and click 'Continue' button)
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

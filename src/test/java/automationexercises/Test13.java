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

public class Test13 {
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
        WebElement anaSayfa = driver.findElement(By.xpath("(//html[@lang='en'])[1]"));
        Assert.assertTrue(anaSayfa.isDisplayed());

        //4. Click 'View Product' for any product on home page
        driver.findElement(By.cssSelector("a[href='/product_details/38']")).sendKeys(Keys.ENTER);
        driver.navigate().refresh();
        driver.navigate().to("https://automationexercise.com/product_details/38");

        //5. Verify product detail is opened
        WebElement urunDetayi = driver.findElement(By.cssSelector("div[class='product-information']"));
        Assert.assertTrue(urunDetayi.isDisplayed());

        //6. Increase quantity to 4
        driver.findElement(By.id("quantity")).clear();
        driver.findElement(By.id("quantity")).sendKeys("4",Keys.ENTER);

        //7. Click 'Add to cart' button
        driver.findElement(By.xpath("//*[@class='btn btn-default cart']")).click();

        //8. Click 'View Cart' button
        driver.findElement(By.xpath("(//*[@href='/view_cart'])[2]")).click();

        //9. Verify that product is displayed in cart page with exact quantity
//        String actualFiyat = driver.findElement(By.xpath("//*[@class='cart_total_price']")).getText();
//        String expectedFiyat = "Rs. 9200";
//        Assert.assertEquals(expectedFiyat,actualFiyat);

        WebElement miktarKontrol = driver.findElement(By.cssSelector("button[class='disabled']"));
        String ss = miktarKontrol.getText();
        int ssint =Integer.parseInt(ss);
        Assert.assertEquals(ssint,4);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
//1. Tarayıcıyı başlatın
//2. 'http://automationexercise.com' URL'sine gidin
//3. Ana sayfanın başarıyla göründüğünü doğrulayın
//4. Ana sayfadaki herhangi bir ürün için 'Ürünü Görüntüle'ye tıklayın
//5. Ürün detayının açıldığını doğrulayın
//6. Miktarı 4'e yükseltin
//7. 'Sepete ekle' düğmesini tıklayın
//8. 'Sepeti Görüntüle' düğmesini tıklayın
//9. Sepet sayfasında ürünün tam miktar ile görüntülendiğini doğrulayın.
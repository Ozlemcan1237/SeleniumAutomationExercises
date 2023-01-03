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
import java.util.List;

public class Test12 {
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
        WebElement anaSayfa = driver.findElement(By.xpath("(//*[@lang='en'])[1]"));
        Assert.assertTrue(anaSayfa.isDisplayed());

        //4. Click 'Products' button
        driver.findElement(By.xpath("//*[@href='/products']")).click();
        driver.navigate().refresh();
        driver.navigate().to("https://automationexercise.com/products");

        //5. Hover over first product and click 'Add to cart'
        driver.findElement(By.cssSelector("a[href='/product_details/1']")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("button[type='button']")).click();

        //6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();

        //7. Hover over second product and click 'Add to cart'
        driver.navigate().back();
        driver.findElement(By.cssSelector("a[href='/product_details/2']")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("button[type='button']")).click();
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();

        //8. Click 'View Cart' button
        driver.findElement(By.cssSelector("a[href='/view_cart']")).click();

        //9. Verify both products are added to Cart
        List<WebElement> sepettekiUrunler = driver.findElements(By.xpath("//*[@class='product_image']"));
            int urunSayisi = sepettekiUrunler.size();
        System.out.println("urunSayisi = " + urunSayisi);

        //10. Verify their prices, quantity and total price
        //prices
        String actualFiyat =driver.findElement(By.xpath("(//*[@class='cart_total_price'])[1]")).getText();
        String expectedFiyat="Rs. 500";
        Assert.assertEquals(expectedFiyat,actualFiyat);

        String actualFiyat2 = driver.findElement(By.xpath("(//*[@class='cart_total_price'])[2]")).getText();
        String expectedFiyat2 = "Rs. 400";
        Assert.assertEquals(expectedFiyat2,actualFiyat2);

        //quantity
        List<WebElement> urunSayisiDogrulama = driver.findElements(By.xpath("//*[@class='disabled']"));
        int dogruUrunSayisi = urunSayisiDogrulama.size();
        System.out.println("dogruUrunSayisi = " + dogruUrunSayisi);

        //total price
       String fiyat1 = expectedFiyat.replaceAll("\\D","");
       int fiyat2 = Integer.parseInt(fiyat1);


        String guncelfuyat1 = expectedFiyat2.replaceAll("\\D","");
        int fiyatguncel = Integer.parseInt(guncelfuyat1);

        System.out.println(fiyat2+fiyatguncel);
    }
    @After
    public void tearDown(){
       driver.quit();
    }
}
//         5. İlk ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın
//         //6. 'Alışverişe Devam Et' düğmesini tıklayın
//         //7. Fareyle ikinci ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın
//         //8. 'Sepeti Görüntüle' düğmesini tıklayın
//         //9. Her iki ürünün de Sepete eklendiğini doğrulayın
//         //10. Fiyatlarını, miktarlarını ve toplam fiyatlarını doğrulayın
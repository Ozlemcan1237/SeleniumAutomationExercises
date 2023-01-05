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

public class Test17 {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void Test17() throws InterruptedException {
        //1. Launch browser ----> Tarayıcıyı başlatın
        //2. Navigate to url 'http://automationexercise.com' --->bu url ye gidin.
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully ---->Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement homepage = driver.findElement(By.xpath("//*[@lang='en']"));
        Assert.assertTrue(homepage.isDisplayed());

        //4. Add products to cart  ----> Sepete urun ekleyin
        driver.findElement(By.xpath("//*[@href='/product_details/2']")).sendKeys(Keys.ENTER);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@href='/product_details/2']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='btn btn-default cart']")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();

        //5. Click 'Cart' button  --------> Sepet' düğmesini tıklayın
        driver.findElement(By.cssSelector("a[href='/view_cart']")).click();

//        //6. Verify that cart page is displayed --------->Sepet sayfasının görüntülendiğini doğrulayın
        WebElement sepet = driver.findElement(By.xpath("//*[@id='cart_info']"));
        Assert.assertTrue(sepet.isDisplayed());
        Thread.sleep(2000);

//        //7. Click 'X' button corresponding to particular product ----->Belirli bir ürüne karşılık gelen 'X' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@class='cart_quantity_delete']")).click();

//        //8. Verify that product is removed from the cart ---->Ürünün sepetten kaldırıldığını doğrulayın
        WebElement removedbutton = driver.findElement(By.xpath("//*[@style='display: block;']"));
        Assert.assertTrue(removedbutton.isDisplayed());
    }
}

package automationexcercises2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test19 {

    /**
     * 1. Tarayıcıyı başlat
     * 2. URL'ye git 'http://automationexercise.com '
     * 3. 'Ürünler' düğmesine tıklayın
     * 4. Markaların sol taraftaki çubukta görünür olduğunu doğrulayın
     * 5. Herhangi bir marka adına tıklayın
     * 6. Kullanıcının marka sayfasına yönlendirildiğini ve marka ürünlerinin görüntülendiğini doğrulayın
     * 7. Sol taraftaki çubukta, başka bir marka bağlantısına tıklayın
     * 8. Kullanıcının o marka sayfasına yönlendirildiğini ve ürünleri görebildiğini doğrulayın
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        //1. Tarayıcıyı başlat
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        //2. URL'ye git 'http://automationexercise.com '
        driver.get("http://automationexercise.com");

        //3. 'Ürünler' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/products']")).click();

        //4. Markaların sol taraftaki çubukta görünür olduğunu doğrulayın
        WebElement brands = driver.findElement(By.xpath("//*[@class='left-sidebar']"));
        Assert.assertTrue(brands.isDisplayed());
        Thread.sleep(2000);

        //5. Herhangi bir marka adına tıklayın
        WebElement markaTikla = driver.findElement(By.xpath("//*[@href='/brand_products/Madame']"));
        markaTikla.click();

        //6. Kullanıcının marka sayfasına yönlendirildiğini ve marka ürünlerinin görüntülendiğini doğrulayın
        WebElement markaGorunurMu = driver.findElement(By.xpath("//*[@class='features_items']"));
        Assert.assertTrue(markaGorunurMu.isDisplayed());
        Thread.sleep(2000);

        //7. Sol taraftaki çubukta, başka bir marka bağlantısına tıklayın
        driver.findElement(By.xpath("//*[@href='/brand_products/H&M']")).click();
        Thread.sleep(2000);

        //8. Kullanıcının o marka sayfasına yönlendirildiğini ve ürünleri görebildiğini doğrulayın
        WebElement markaGorunurMu2 = driver.findElement(By.xpath("//*[.='Brand - H&M Products']"));
        Assert.assertTrue(markaGorunurMu2.isDisplayed());
    }
}

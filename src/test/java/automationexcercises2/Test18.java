package automationexcercises2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test18 {

    /**
     * 1. Launch browser
     * 2. Navigate to url 'http://automationexercise.com'
     * 3. Verify that categories are visible on left side bar
     * 4. Click on 'Women' category
     * 5. Click on any category link under 'Women' category, for example: Dress
     * 6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
     * 7. On left side bar, click on any sub-category link of 'Men' category
     * 8. Verify that user is navigated to that category page
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        //1. Tarayıcıyı başlatın("Launch browser")
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @Test
    public void Test1() throws InterruptedException {


        //2. 'http://automationexercise.com' URL'sine gidin("Navigate to url 'http://automationexercise.com'")
        driver.get("http://automationexercise.com");

        JavascriptExecutor js = (JavascriptExecutor) driver; //javascript classi
        js.executeScript("window.scroll(0,500)"); //console

        //3. Kategorilerin sol taraftaki çubukta göründüğünü doğrulayın("Verify that categories are visible on left side bar")
        WebElement verifycategories = driver.findElement(By.xpath("//h2[1]"));
        Assert.assertTrue(verifycategories.isDisplayed());
        Thread.sleep(1000);


    }

    @Test
    public void Test2() throws InterruptedException {
        //4. 'Kadınlar' kategorisine tıklayın("Click on 'Women' category")
        driver.findElement(By.xpath("//*[@class='fa fa-plus'][1]")).click();

        //5. "Kadınlar" kategorisi altındaki herhangi bir kategori bağlantısına tıklayın, örneğin: Elbise("Click on any category link under 'Women' category, for example: Dress")
        driver.findElement(By.xpath("//*[@href='/category_products/1']")).click();
        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@class='fa fa-plus'][1]")).click();
        driver.findElement(By.xpath("//*[@href='/category_products/1']")).click();


        //6. Kategori sayfasının görüntülendiğini doğrulayın ve 'KADIN - TOPS ÜRÜNLERİ' metnini onaylayın("Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'")
        WebElement verifycategorypage = driver.findElement(By.xpath("//*[text()='Women - Dress Products']"));
        Assert.assertTrue(verifycategorypage.isDisplayed());

    }

    @Test
    public void Test3() throws InterruptedException {
        //7. Sol taraftaki çubukta, 'Erkekler' kategorisinin herhangi bir alt kategori bağlantısına tıklayın("On left side bar, click on any sub-category link of 'Men' category")
        driver.findElement(By.xpath("(//*[@class='fa fa-plus'])[2]")).click();
        driver.findElement(By.xpath("//*[text()='Tshirts ']")).click();

        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//*[@class='fa fa-plus'])[2]")).click();
        driver.findElement(By.xpath("//*[text()='Tshirts ']")).click();


        //8. Kullanıcının o kategori sayfasına yönlendirildiğini doğrulayın"Verify that user is navigated to that category page"
        WebElement verifyusernavigate = driver.findElement(By.xpath("//*[@class='title text-center']"));
        Assert.assertTrue(verifyusernavigate.isDisplayed());
        Thread.sleep(1000);


    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
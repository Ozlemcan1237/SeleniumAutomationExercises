package seleniumstudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Study_13 {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {

        //sahibinden.com a gidin
        driver.get("https://sahibinden.com");

        //anasayfada oldugunuzu dogrulayin
        WebElement anaSayfa = driver.findElement(By.xpath("(//html[@lang='tr'])[1]"));
        Assert.assertTrue(anaSayfa.isDisplayed());

        //detayli arama tiklayin
        driver.findElement(By.xpath("//a[contains(text(),'Detaylı Arama')]")).click();

        //detayli arama sayfasina geldiginizi dogrulatin
        String actualdetayliTitle = driver.getCurrentUrl();
        String expecteddetayliTitle = "https://www.sahibinden.com/arama/detayli";
        Assert.assertEquals(expecteddetayliTitle, actualdetayliTitle);

        //emlak-konut-satilik seceneklerini secip
        driver.findElement(By.xpath("(//span[text()='Emlak'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Konut']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Satılık']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Daire']")).click();

        //altta cikan butun filtre seceneklerine en az bir filtre degeri girip en sonundaki arama yap tusuna tiklayin
        detayliArama("Ankara", "Yenimahalle", "Yeni Batı Mh.");
        detayli_Arama_fiyat("100000","700000","TL");
//        scrollDownActions();
//        scrollDownActions();
        detayli_Arama_cephe("Kuzey"," Batı");
        WebElement aramayap = driver.findElement(By.xpath("(//button[normalize-space()='Arama Yap'])[1]"));
//        doubleClick(aramayap);
        //aramayap.click();
        //cikan sonuc sayisini veya sonuc yoksa bunu bildiren yaziyi konsolda yazdirin
        String sonuc = driver.findElement(By.xpath("//div[@class='result-text']")).getText();
        System.out.println(sonuc);
    }


    public void detayliArama(String il, String ilce, String mah) throws InterruptedException {
        WebElement Adres1 = driver.findElement(By.xpath("(//*[@class='faceted-select'])[1]"));
        Adres1.click();
        WebElement ilyaz = driver.findElement(By.xpath("//input[@placeholder='İl']"));
        ilyaz.sendKeys(il);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'" + il + "')]")).click();
        WebElement Adres2 = driver.findElement(By.xpath("(//*[@class='faceted-select'])[2]"));
        Adres2.click();
        Thread.sleep(2000);
        WebElement semtyaz = driver.findElement(By.xpath("//input[@placeholder='İlçe']"));
        semtyaz.sendKeys(ilce);
        driver.findElement(By.xpath("//a[contains(text(),'" + ilce + "')]")).click();
        driver.findElement(By.xpath("//a[@class='collapse-pane']")).click();
        WebElement Adres3 = driver.findElement(By.xpath("(//*[@class='faceted-select'])[3]"));
        Adres3.click();
        WebElement mahlyaz = driver.findElement(By.xpath("//input[@placeholder='Semt / Mahalle']"));
        mahlyaz.sendKeys(mah);
        driver.findElement(By.xpath("//a[normalize-space()='" + mah + "']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='collapse-pane']")).click();
    }
    public void detayli_Arama_fiyat(String min,String max,String parabirimi){
        WebElement minFiyat=driver.findElement(By.xpath("//input[@placeholder='Min TL']"));
        minFiyat.click();
        minFiyat.sendKeys(min);
        WebElement maxFiyat=driver.findElement(By.xpath("//input[@placeholder='Max TL']"));
        maxFiyat.click();
        maxFiyat.sendKeys(max);
        WebElement parabrimi=driver.findElement(By.xpath("//select[@name='price_currency']"));
        parabrimi.click();
        parabrimi.sendKeys(parabirimi);
    }
    public void detayli_Arama_cephe(String...cephe) {
        Actions actions=new Actions(driver);
        WebElement ddm = driver.findElement(By.xpath("//a[normalize-space()='Cephe']"));
        actions.moveToElement(ddm).perform();
        actions.doubleClick();
        for (String w : cephe) {
            if (w == cephe[0]) {
                driver.findElement(By.xpath("//*[contains(text(),'"+cephe[0]+"')]")).click();
            } else if (w == cephe[1]) {
                driver.findElement(By.xpath("//*[contains(text(),'" +cephe[1]+"')]")).click();
            } else if (w == cephe[2]) {
                driver.findElement(By.xpath("//*[contains(text(),'" +cephe[2]+"')]")).click();
            } else if (w == cephe[3]) {
                driver.findElement(By.xpath("//*[contains(text(),'" +cephe[3]+"')]")).click();
            }else break;
        }
    }
}
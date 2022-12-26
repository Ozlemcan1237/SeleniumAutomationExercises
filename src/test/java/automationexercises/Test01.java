package automationexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test01 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //2. 'http://automationexercise.com/' URL'sine gidin
        driver.get("https://automationexercise.com/");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement anaSayfa = driver.findElement(By.cssSelector("html[lang='en']"));
        if (anaSayfa.isDisplayed()) {
            System.out.println("Test1 PASSED");
        }else{
            System.out.println("Test1 FAILED");
        }

        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.cssSelector("a[href='/login']")).click();

        //5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
        WebElement yeniKullaniciAdi = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        if (yeniKullaniciAdi.isDisplayed()){
            System.out.println("Test2 PASSED");
        }else{
            System.out.println("Test FAILED");
        }

        //6. Adı ve e-posta adresini girin
        driver.findElement(By.cssSelector("input[data-qa='signup-name']")).sendKeys("Jorge", Keys.ENTER);
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys("asdzF123@gmail.com", Keys.ENTER);

        //7. 'Kaydol' düğmesini tıklayın
        driver.findElement(By.cssSelector("form[action='/signup']")).click();

        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın
        WebElement gorunurluk = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        if (gorunurluk.isDisplayed()){
            System.out.println("Test3 PASSED");
        }else{
            System.out.println("Test3 FAILED");
        }

        //9. Ayrıntıları doldurun: Unvan, Ad, E-posta, Parola, Doğum tarihi
        driver.findElement(By.xpath("//*[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("12345",Keys.TAB,"26",Keys.TAB,"December",Keys.TAB,"2021");

        //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        driver.findElement(By.xpath("//*[@id='newsletter']")).click();

        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        driver.findElement(By.cssSelector("input[id='optin']")).click();

        //12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys("Jorge",Keys.TAB,"Jesus",Keys.TAB,"Fenerbahce",Keys.TAB,"Kadikoy", Keys.TAB,"Caddebostan");
        driver.findElement(By.cssSelector("option[value='Australia']")).click();
        driver.findElement(By.cssSelector("input[id='state']")).sendKeys("Anadolu",Keys.TAB,"Istanbul",Keys.TAB,"34",Keys.TAB,"05550020234");

        //13. 'Hesap Oluştur düğmesini' tıklayın
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();

        //14. 'HESAP OLUŞTURULDU!' görünür
        WebElement gorunurMu = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        if (gorunurMu.isDisplayed()){
            System.out.println("Hesabiniz PASSED");
        }else{
            System.out.println("Hesabiniz FAILED");
        }

        //15. 'Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

        //16. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        WebElement kullaniciAdigorunurMu = driver.findElement(By.xpath("//*[@class='fa fa-user']"));
        if (kullaniciAdigorunurMu.isDisplayed()){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        //17. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.cssSelector("a[href='/delete_account']")).click();

        //18. 'HESAP SİLİNDİ!' görünür ve 'Devam Et' düğmesini tıklayın
        WebElement hesapSilindiMi = driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
        if (hesapSilindiMi.isDisplayed()){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();

        driver.quit();
    }
}
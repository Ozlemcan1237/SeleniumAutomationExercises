package seleniumstudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Study_06 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void alertTest() throws InterruptedException {
        // go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        //"Alert with OK" butonuna tıklayın ve "click the button to display an  alert box:" 'a tıklayın
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//*[@class='analystic'])[1]")).click();
        driver.findElement(By.xpath("//*[@onclick='alertbox()']")).click();

        //    accept Alert(I am an alert box!) and print alert on console
        //Alert(I am an alert box!) konsolda yazdırın ve Alert'ü kabul edin.
        Thread.sleep(2000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        //"Alert with OK & Cancel" butonuna tıklayın ve"click the button to display a confirm box " butonuna tıklayın
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();

        //    cancel Alert  (Press a Button !)
        // Alert'ü kapatın
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[onclick='confirmbox()']")).click();
        driver.switchTo().alert().dismiss();

        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        //"Alert with Textbox" butonuna tıklayın ve "click the button to demonstrate the prompt box " butonuna tıklayın.
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();

        //    and then sendKeys 'TechProEducation' (Please enter your name)
        //Açılan alert e 'TechProEducation' (Lütfen İsminizi girin).
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[onclick='promptbox()']")).click();
        driver.switchTo().alert().sendKeys("TechProEducation");
        driver.switchTo().alert().accept();

        //Gönderdiğiniz metnin isminizi içerdiğini doğrulayın
        //    finally print on console this mesaaje "Hello TechproEducation How are you today"
        Thread.sleep(2000);
        String actualIsimDogrulama = driver.findElement(By.id("demo1")).getText();
        String expectedIsimDogrulama = "TechProEducation";
        Assert.assertTrue(actualIsimDogrulama.contains(expectedIsimDogrulama));

    }
}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.manager.SeleniumManager;

public class Selenium_Manager {

    public static void main(String[] args) {

        SeleniumManager.getInstance().getDriverPath("chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://techproeducation.com");
        driver.quit();


//        SeleniumManager.getInstance().getDriverPath("IEDriverServer");
//        InternetExplorerDriver driver1 = new InternetExplorerDriver();
//        driver1.get("https://techproeducation.com");
//        driver1.quit();
    }
}

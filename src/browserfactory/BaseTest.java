package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public static WebDriver driver;

    public  void openBrowser(String baseUrl){

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        //Launch the Url
        driver.get(baseUrl);
        //Maximize the Window
        driver.manage().window().maximize();

    }
    public void closeBrowser(){
        driver.quit();
    }
}



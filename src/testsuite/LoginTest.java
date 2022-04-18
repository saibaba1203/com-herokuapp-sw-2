package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before

    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test

    public void userSholdLoginSuccessfullyWithValidCredentials(){
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        String expectedMessage = "Secure Area";
        WebElement message = driver.findElement(By.xpath("/h2[normalize-space()='Secure Area']"));
        String actualMessage = message.getText();
        Assert.assertEquals("securearea text is not displayed",expectedMessage , actualMessage);

    }
    @Test
public void verifyTheUsernameErrorMessage(){
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith1");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        String expectedMessage = " Your username is invalid! ";
        WebElement message = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = message.getText();
        Assert.assertEquals("Error message is not displayed",expectedMessage , actualMessage);

    }
    @Test
    public void verifyThePasswordErrorMessage(){
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        String expectedMessage = "Your password is invalid!" + "×";
        WebElement message = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = message.getText();
        Assert.assertEquals("Error message is not displayed",expectedMessage , actualMessage);

    }
}

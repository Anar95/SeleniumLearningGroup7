import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class T14_Alert_Test {

    @Test
    public  void  simpleAlertTest(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();

        //Alertin görünmeyi üçün gözle

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        // Alertin içindeki metni götürmek isteyerken
        String alertText = alert.getText();
        System.out.println("Alert metni: " + alertText);
        Assert.assertEquals(alertText,"You clicked a button");

        // Allerti qebul etmek
        alert.accept();


    }
}

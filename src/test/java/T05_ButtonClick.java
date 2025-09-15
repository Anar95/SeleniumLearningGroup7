import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class T05_ButtonClick {

    @Test
    public  void buttonClick(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();


        WebElement dubleClick = driver.findElement(By.id("doubleClickBtn"));

        // bu normal tek sol clickdir
        // dubleClick.click();


        Actions action = new Actions(driver);
        // bu ise duble clickdir
        action.doubleClick(dubleClick).perform();

        // right click  nece edilir

        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
        action.contextClick(rightClick).perform();



        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));

        String messageRightClick = rightClickMessage.getText();
        System.out.println(messageRightClick);



    }
}

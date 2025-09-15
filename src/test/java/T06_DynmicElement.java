import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class T06_DynmicElement {


    @Test

    public void dynamicsElemnt() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/dynamic-properties");
        driver.manage().window().maximize();

        WebElement textElement = driver.findElement(By.xpath("//div/p"));
        String text = textElement.getText();
        System.out.println(text);


  // explicit wait WebDriverWait
        WebElement firstWaitButton = driver.findElement(By.id("enableAfter"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(firstWaitButton));

        firstWaitButton.click();


        WebElement colorChangeButton = driver.findElement(By.id("colorChange"));
        String clasName = colorChangeButton.getAttribute("class");
        System.out.println("Deyişmeden önceki: " + clasName);


        WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.attributeToBe(colorChangeButton, "class","mt-4 text-danger btn btn-primary"));
        clasName = colorChangeButton.getAttribute("class");
        System.out.println("Deyişdikden sonra : " + clasName);



        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        driver.findElement(By.id("visibleAfter")).click();



    }
}
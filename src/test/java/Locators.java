package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    @Test

    public  void  locators01() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");

        // ID ilə element tapır və data yazır
        WebElement fullName = driver.findElement(By.id("userName")); // ID ilə tapır  xpath //textarea[@id='currentAddress']
        fullName.click();
        fullName.sendKeys("Anar Abbas");

        // Name ilə tapmaq (demoqa-da az sayda var, bu testlik nümunədir)
       WebElement gender = driver.findElement(By.name("gender"));
        gender.click();

        WebElement email = driver.findElement(new By.ByCssSelector(".mr-sm-2[id='userEmail']")); // İlk uyğun elementi tapır
        email.click();
        email.sendKeys("anar@example.com");

        WebElement address = driver.findElement(new By.ByCssSelector(".form-control[placeholder='Current Address']"));
        address.click();
        address.sendKeys("test data adress bolumune yazıldı meselen Baku Azerbaıjan");


    }
}

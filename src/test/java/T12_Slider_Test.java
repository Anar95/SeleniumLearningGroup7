import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class T12_Slider_Test {

    @Test

    public void  sliderTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/slider");
        driver.manage().window().maximize();


        //Slider oldugu bolumu tapırıq
        WebElement slider= driver.findElement(By.cssSelector("input[type='range']"));

        // Slider cari deyerini alaq

        String initialvalue = slider.getAttribute("value");
        System.out.println("Başlanğıc deyeri: " + initialvalue);


        //istediymiz yeni deyeri mueyyen edirik
        int hedefValue = 70;

        Actions actions = new Actions(driver);

        // Slider genişliyini ölçmek üçün elementin ölçüsünü işledirik

        int width = slider.getSize().getWidth();
        System.out.println("Sliderin genişliyi: " + width);

        // İstediymiz deyer = (hedef-başlanğıc)*(pixel per unit)

        int currentValueInt = Integer.parseInt(initialvalue);
        int offset = (int) ((hedefValue-currentValueInt)* (width/100.0));
        System.out.println("Offset deyeri: " + offset);

        actions.clickAndHold(slider)
                .moveByOffset(offset,0)
                .release() // siçanı buraxır drag emeliyyatı bitir
                .perform();

        Thread.sleep(1000); // deyişiklik domda deyişsin



        // Sliderin yerini deyişenden sonrakı deyerini alaq


        String newValue = slider.getAttribute("value");
        System.out.println("Yeni deyeri: " + newValue);

    }
}

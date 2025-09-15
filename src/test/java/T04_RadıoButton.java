import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T04_RadıoButton {

    @Test

    public  void radioButton(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();


        // Yes duymesını tapırıq

     //   WebElement yesRadio = driver.findElement(By.id("yesRadio"));
        WebElement yesRadio = driver.findElement(By.xpath("//label[@for=\"yesRadio\"]"));

        // yes duymesinin aktıv olub olmadıgına baxaq

        System.out.println("Yes düymesi aktivdir ? " + yesRadio.isEnabled());

        // kliklenmezden evvel seçilmişse klik edirik

        if(!yesRadio.isSelected() && yesRadio.isEnabled()){
            yesRadio.click();
        }

        System.out.println("Yes seçilibmi? " + yesRadio.isSelected());



        // Impressıve duymesın telebeler yazacaq


        // No duymesinin deaktivdir klik edile bilmez

        WebElement noRadio = driver.findElement(By.id("noRadio"));
        System.out.println("No düymesini aktivdirmi? " + noRadio.isEnabled());


       driver.quit();


    }

}

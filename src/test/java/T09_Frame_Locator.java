import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T09_Frame_Locator {

    @Test
    public  void  testFarme(){


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/frames");
        driver.manage().window().maximize();


        // Frame 1 e keçirmeliyik // Hansı element hansı framededirse ora ilk önce keçilmelidir

        driver.switchTo().frame("frame1");
        WebElement headingText = driver.findElement(By.id("sampleHeading"));
        System.out.println("Frame Heading: " + headingText.getText());

        // Geri main contente qayıdaq
        driver.switchTo().defaultContent();

       // Frame 2 ye keçek

        driver.switchTo().frame("frame2");
        WebElement headText2 = driver.findElement(By.id("sampleHeading"));
        System.out.println("Frame2 Heading Text: " + headText2.getText());

        // Geri main contente qayıdaq
        driver.switchTo().defaultContent();

        driver.quit();

    }
}

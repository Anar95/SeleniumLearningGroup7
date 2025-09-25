import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class T11_Progress_BarTest {

    @Test

    public  void testProgressBar() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/demo-site/progress-bar/#Download%20Manager");
        driver.manage().window().maximize();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Thread.sleep(5000);


        driver.navigate().refresh();

          //ifram görünene kimi gözleyirik ve içeri keçirik
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe.demo-frame")));

          WebElement startButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Start Download']")));
      //  WebElement startButton = driver.findElement(By.xpath("//button[text()='Start Download']"));
        startButton.click();

       //Gözleyirik progress bar 100% olsun

        while (true){
            WebElement progressBar = driver.findElement(By.cssSelector("div[role='progressbar']"));
            String progressText = progressBar.getAttribute("aria-valuenow");
           // System.out.println("Progress: " + progressText + "%");

            if(progressText!= null && progressText.equals("100")){
                break;
            }
            Thread.sleep(100); //Her 100 ms de bir yoxlasın
        }


        System.out.println("Progress reached 100%");

        driver.quit();
    }
}

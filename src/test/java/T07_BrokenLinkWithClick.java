import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class T07_BrokenLinkWithClick {


    @Test

    public void dynamicsElemnt() throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/broken");
        driver.manage().window().maximize();

     // İlk pencereni yadda saxla

     String mainWindow = driver.getWindowHandle();

     //Link elementini tap

        WebElement clickBrokenLink = driver.findElement(By.linkText("Click Here for Broken Link"));

        // Scroll etmek

        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)",clickBrokenLink);
        Thread.sleep(500);

      //  Linke klick etdim
        clickBrokenLink.click();


        Set<String> allWindows = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(allWindows);

  for (String window : windowList){
      if (!window.equals(mainWindow)){
          driver.switchTo().window(window);
          break;
      }
  }


  //Yeni url i al
        String opendUrl = driver.getCurrentUrl();
        System.out.println(opendUrl);

 // Urle get sorgusu gönder status koda bax

        CloseableHttpClient client = HttpClientBuilder.create().build();

        HttpGet request = new HttpGet(opendUrl);
        HttpResponse response = client.execute(request);

        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Status Code: " + statusCode);

        client.close();

        // driver bağlamaq

        driver.quit();






    }
}
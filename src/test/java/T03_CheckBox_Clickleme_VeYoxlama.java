import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T03_CheckBox_Clickleme_VeYoxlama {

    @Test
    public void checkBoxClick(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/checkbox");
        driver.manage().window().maximize();


        //CheckBox spanı tapıb cliklemeliyik

        WebElement checkBoxSpan = driver.findElement(By.xpath("//span[@class=\"rct-checkbox\"]"));
       checkBoxSpan.click();


       // İçindeki svg elementini tapırıq

        WebElement svgIcon = checkBoxSpan.findElement(By.tagName("svg"));

      // class attributna bax

        String iconClass = svgIcon.getAttribute("class");

      if (iconClass.contains("rct-icon-check")){
          System.out.println("Checbox seçilib!");
      }else {
          System.out.println("Checbox Secilmedi!");
      }


      driver.quit();



    }




}

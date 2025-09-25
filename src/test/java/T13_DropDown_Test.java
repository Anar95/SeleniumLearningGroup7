import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class T13_DropDown_Test {

    @Test
    public  void  testDropDownSelection () throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();

          // EKranda DropDownu tapırıq
        WebElement dropDownElement = driver.findElement(By.id("dropdown"));

        Select dropdown = new Select(dropDownElement);

        dropdown.selectByVisibleText("Option 2");
        Thread.sleep(1000);

        String selectOption = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(selectOption,"Option 2", "Seçim düzgün deyil!");


    }
}

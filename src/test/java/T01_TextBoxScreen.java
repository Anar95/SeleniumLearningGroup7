import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T01_TextBoxScreen {
    @Test
    public  void textBoxScenario(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");

        driver.manage().window().maximize();

        // ID ile element tapır ve data yazır

        WebElement fullName = driver.findElement(By.id("userName"));

        // Seleniumda clicl elemente mausun sol duymesi ile bir defe click edir
        fullName.click();

        // Seleniumda sendKeys ınput bölümüne data gönderir
        fullName.sendKeys("QA Automation");

        //Xpathle element tapmaq data yazmaq

        WebElement email = driver.findElement(By.xpath("//input[@id=\"userEmail\"]"));
        email.click();
        email.sendKeys("test@gmail.com");


     //      .form-control[placeholder='Current Address']

        // Css Selector

        WebElement adress = driver.findElement(new By.ByCssSelector(".form-control[placeholder='Current Address']"));

        adress.click();
        adress.sendKeys("Azerbaijan Baku");

        // ID ILE ELEMENT TAPDIQ

        WebElement permanetAdress = driver.findElement(By.id("permanentAddress"));
        permanetAdress.click();
        permanetAdress.sendKeys("Bakı Merdakan");

        // Submıt button
        WebElement submitButton = driver.findElement(new By.ByCssSelector("button.btn"));
        submitButton.click();


        // Textleri kontrol edirik
        WebElement nameText = driver.findElement(By.xpath("//div/p[@id='name']"));
        String name= nameText.getText();
        System.out.println(name);


         driver.quit(); //bütün brazuer pencerelerini bağlayır
    }

}

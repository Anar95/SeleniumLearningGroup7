import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T10_Date_Picker_Test {

    @Test
    public void  selectDate() throws InterruptedException {



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/date-picker");
        driver.manage().window().maximize();


        // Date inputu tapaq ve klikleyek

        WebElement dateInput = driver.findElement((By.id("datePickerMonthYearInput")));
        dateInput.click();


        //Ayı seçirik (meselen March)

        WebElement monthDropdown = driver.findElement((By.className("react-datepicker__month-select")));
        monthDropdown.sendKeys("Mar");

        // İli seçirik (meselen 2026)
        WebElement yearDropDown = driver.findElement(By.className("react-datepicker__year-select"));
        yearDropDown.sendKeys("2026");

       // Günü seçirik (meselen 25i)

        WebElement day =driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--025']"));
        day.click();

        // Seçilmiş günü yoxla

        String selectedDate = dateInput.getAttribute("value");
        System.out.println("Selected date: " + selectedDate); // 03/25/2026

        Thread.sleep(2000);

        driver.quit();
    }

}

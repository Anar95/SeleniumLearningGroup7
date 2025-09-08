import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T02_SehifeÜzerindeHereketler {
    @Test
    public void test01() throws InterruptedException {
        // Webdriver  üçün driver avtomatik yükleyir
        WebDriverManager.chromedriver().setup();

        //ChromDriver yaradmaq
        WebDriver driver = new ChromeDriver();

        //Siteye nece gedirik

        driver.get("https://demoqa.com/text-box");

        // Cari sehifenin başlığını konsola yazır

        System.out.println("Title: " + driver.getTitle());

        // Sehifeni max size edir

        driver.manage().window().maximize();

        //Cari sehifenin urlin consola yazdırır
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // ChecBox sehıfesıne yonlendırı
        // ve sleep etmek
        driver.navigate().to("https://demoqa.com/checkbox");
        Thread.sleep(2000); // 2 saniye gözleyir

        // Geri qayıdır( ana sehifeye)
        driver.navigate().back();
        Thread.sleep(2000);

        // Yeniden İreli gedmek(checkbox sehşfesine)
        driver.navigate().forward();

        // Sehıfenı Refresh edir

        driver.navigate().refresh();

        // bütün brazuerleri bağlayır
        driver.quit();

    }
}
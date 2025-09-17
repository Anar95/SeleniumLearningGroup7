import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class T08_File_Download_Upload {


    @Test
    public  void  donwloadFileTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/upload-download");
        driver.manage().window().maximize();

        WebElement downloadButton = driver.findElement(By.id("downloadButton"));
        downloadButton.click();

        // Faylın yüklenmesi üçün vaxt verek (3 saniye)
        Thread.sleep(3000);

        String downloadPath = "/Users/anarabbas/Downloads/";
        String fileName = "sampleFile.jpeg"; // demoqaçcom bu adda fayl yükleyir
        File downloadFile = new File(downloadPath + fileName); // file obyectin yaratdım

        if(downloadFile.exists()) {    // exist filen diskde olub olmadıgna baxır ve true--false
            System.out.println("Fayl uğurla yüklendi: " +downloadFile.getAbsolutePath());

        }else {
            System.out.println("Fayl tapılmadı");

        }

driver.quit();


    }



    @Test
    public void  uploadFile(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/upload-download");
        driver.manage().window().maximize();

        //Faylın tam yolunu gösteririk
        String filePath = "/Users/anarabbas/Downloads/sampleFile.jpeg";


        WebElement uploadInput = driver.findElement(By.id("uploadFile"));
        uploadInput.sendKeys(filePath);

        //Yoxlama üçün çap et

        WebElement uploadFilePath = driver.findElement(By.id("uploadedFilePath"));
        System.out.println("Yüklenen fayl: " + uploadFilePath.getText());

        driver.quit();

    }
}

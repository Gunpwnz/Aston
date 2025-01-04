package Lesson_16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MTS_Test {
    MTS2 mts;
    //MTS2 mts = new MTS2(driver);
    WebDriver driver;

    @BeforeEach
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mts = new MTS2(driver);
        driver.get("https://www.mts.by/?hash-offset=70&hash-dur=1300#pay-section");
        driver.manage().window().maximize();
        WebElement cookieLocator = driver.findElement(By.xpath("//*[@id='cookie-agree']"));
        if (cookieLocator.isDisplayed()) {
        }
            cookieLocator.click();
    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @DisplayName("Проверка заголовка")
    @Test
    public void FindTitle() {
        String title = "Онлайн пополнение без комиссии";
        assertEquals(title, mts.getTitle(), "Заголовок не найден");
    }
    @DisplayName("Проверка логотипа")
    @Test
    public void FindLogo() {
        String title = "Visa";
        assertEquals(title, mts.getVisa(), "Лого не найден");
    }
}

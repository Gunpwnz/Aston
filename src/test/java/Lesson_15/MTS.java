package Lesson_15;

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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MTS {
    MTS2 mts;
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
            cookieLocator.click();
        }
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

    @DisplayName("Проверка логотипа Visa")
    @Test
    public void FindLogoVisa() {
        assertTrue(mts.isLogoPresent(mts.logoVisa), "Логотип Visa не найден");
    }

    @DisplayName("Проверка логотипа Verified by Visa")
    @Test
    public void FindLogoVisa2() {
        assertTrue(mts.isLogoPresent(mts.logoVisa2), "Логотип Verified by Visa не найден");
    }

    @DisplayName("Проверка логотипа MasterCard")
    @Test
    public void FindLogoMasterCard() {
        assertTrue(mts.isLogoPresent(mts.logoMasterCard), "Логотип MasterCard не найден");
    }

    @DisplayName("Проверка логотипа MasterCardSecure")
    @Test
    public void FindLogoMasterCardSecure() {
        assertTrue(mts.isLogoPresent(mts.logoMasterCardSecure), "Логотип MasterCard не найден");
    }

    @DisplayName("Проверка логотипа Belkart")
    @Test
    public void FindLogoBelkart() {
        assertTrue(mts.isLogoPresent(mts.logoBelkart), "Логотип Belkart не найден");
    }

    @DisplayName("Проверка работы ссылки 'Подробнее о сервисе'")
    @Test
    public void CheckServiceLink() {
        mts.clickServiceLink();
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        assertEquals(expectedUrl, mts.getCurrentUrl(), "URL не совпадает");
    }

    @DisplayName("Проверка работы кнопки 'Продолжить'")
    @Test
    public void CheckContinueButton() {
        String phoneNumber = "297777777";
        String sum = "10";

        mts.fillPhoneField(phoneNumber);
        mts.fillSumField(sum);
        mts.clickContinueButton();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


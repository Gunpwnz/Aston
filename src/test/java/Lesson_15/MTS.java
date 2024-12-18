package Lesson_15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MTS {
    private static WebDriver driver;
    //private static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/?hash-offset=70&hash-dur=1300#pay-section/");

    }
    @BeforeEach
    public void handleCookiePopup() {
        By cookieButtonLocator = By.xpath("//button[@class='btn btn_black cookie__ok']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(cookieButtonLocator));
            cookieButton.click();
        } catch (TimeoutException | NoSuchElementException ignored) {
            System.out.println("Не удалось нажать кнопку");
        }
    }
    @DisplayName("Проверка пополнение")
    @Test
    public void findText(){
        driver.findElement(By.xpath("//*[contains(text(), 'Онлайн пополнение')]"));
    }
    @DisplayName("Проверка найти партнеров")
    @Test
    public void findPartners(){
        driver.findElement(By.xpath("//*[@class='pay__partners']"));
    }
    @DisplayName("Проверка подробнее о сервисе")
    @Test
    public void findServis(){
        String linkpage = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        WebElement link = driver.findElement(By.linkText("Подробнее о сервисе"));
        link.click();
        //Assertions.assert
    }
}


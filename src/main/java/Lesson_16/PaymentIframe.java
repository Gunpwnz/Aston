package Lesson_16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentIframe extends BasePage {

    @FindBy(className = "bepaid-iframe")
    private WebElement paymentIframe;

    @FindBy(xpath = "//div[@class='app-wrapper__content']")
    private WebElement onlinePaymentForm;

    @FindBy(id = "cc-number")
    private WebElement cardNumberField;

    @FindBy(xpath = "//input[@formcontrolname='expirationDate']")
    private WebElement expirationDateField;

    @FindBy(xpath = "//input[@formcontrolname='cvc']")
    private WebElement cvcField;

    @FindBy(xpath = "//input[@formcontrolname='holder']")
    private WebElement holderField;

    public PaymentIframe(WebDriver driver) {
        super(driver);
    }

    public void switchToIframe() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentIframe));
    }

    public void fillCardNumber(String cardNumber) {
        cardNumberField.sendKeys(cardNumber);
    }

    public void fillExpirationDate(String expirationDate) {
        expirationDateField.sendKeys(expirationDate);
    }

    public void fillCvc(String cvc) {
        cvcField.sendKeys(cvc);
    }

    public void fillHolderName(String holderName) {
        holderField.sendKeys(holderName);
    }

    public String getCardNumberError() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class, 'error-message') and contains(text(), 'Некорректный номер карты')]")));
        return errorElement.getText();
    }

    public String getExpirationDateError() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class, 'error-message') and contains(text(), 'Исправьте срок действия')]")));
        return errorElement.getText();
    }

    public String getCvcError() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class, 'error-message') and contains(text(), 'Введите CVC-код')]")));
        return errorElement.getText();
    }

    public String getHolderNameError() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class, 'error-message') and contains(text(), 'Введите имя и фамилию как указано на карте')]")));
        return errorElement.getText();
    }
}


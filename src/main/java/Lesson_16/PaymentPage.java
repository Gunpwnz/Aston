package Lesson_16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage extends BasePage {

    @FindBy(xpath = "//div[@class='pay__wrapper']/h2")
    private WebElement title;

    @FindBy(xpath = "//img[@alt='Visa']")
    WebElement logoVisa;

    @FindBy(xpath = "//img[contains(@src, 'visa-verified.svg')]")
    WebElement logoVisa2;

    @FindBy(xpath = "//img[@alt='MasterCard']")
    WebElement logoMasterCard;

    @FindBy(xpath = "//img[contains(@src, 'mastercard-secure.svg')]")
    WebElement logoMasterCardSecure;

    @FindBy(xpath = "//img[@alt='Белкарт']")
    WebElement logoBelkart;

    @FindBy(linkText = "Подробнее о сервисе")
    private WebElement serviceLink;

    @FindBy(id = "connection-phone")
    private WebElement phoneField;

    @FindBy(id = "connection-sum")
    private WebElement sumField;

    @FindBy(css = "button.button.button__default[type='submit']")
    private WebElement continueButton;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return title.getText().replaceAll("\n", " ");
    }

    public boolean isLogoPresent(WebElement logo) {
        return logo.isDisplayed();
    }

    public void clickServiceLink() {
        serviceLink.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void fillPhoneField(String phoneNumber) {
        phoneField.sendKeys(phoneNumber);
    }

    public void fillSumField(String sum) {
        sumField.sendKeys(sum);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public String getPhoneFieldPlaceholder() {
        return phoneField.getAttribute("placeholder");
    }

    public String getSumFieldPlaceholder() {
        return sumField.getAttribute("placeholder");
    }

    public String getEmailFieldPlaceholder() {
        return driver.findElement(By.id("connection-email")).getAttribute("placeholder");
    }

    public void selectService(String serviceName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("use[xlink\\:href*='drop-arrow']")));
        dropdown.click();
        WebElement serviceOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), '" + serviceName + "')]")));
        serviceOption.click();
    }

    public void fillEmailField(String email) {
        WebElement emailField = driver.findElement(By.id("connection-email"));
        emailField.sendKeys(email);
    }
}


package Lesson_16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MTS2 {
    WebDriver driver;
    // Конструктор класса
    public MTS2(WebDriver driver) {
        this.driver = driver;
    }
    By pay_wrapper = By.xpath("//div[@class='pay__wrapper']/h2");
    public String getTitle() {
        return driver.findElement(pay_wrapper).getText().replaceAll("\n", " ");
    }
    By logoVisa = By.xpath("//img[@alt='Verified by Visa']");
    public String getVisa() {
       // return driver.findElement(logoVisa).getText().replaceAll("\n", " ");
        return driver.findElement(logoVisa);
    }
}

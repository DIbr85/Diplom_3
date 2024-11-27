package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoveryPasswordPage {
    private final WebDriver driver;

    public RecoveryPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By linkLogin = By.xpath("//a[text()='Войти']");

    @Step("Переход к странице логина")
    public void clickLinkLoginStep() {
        driver.findElement(linkLogin).click();
    }
}

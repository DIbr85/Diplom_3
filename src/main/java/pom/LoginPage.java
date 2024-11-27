package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By fieldEmail = By.xpath(".//input[@type = 'text']");
    private final By fieldPassword = By.xpath(".//input[@type = 'password']");
    private final By buttonLogin = By.xpath(".//button[text() = 'Войти']");
    private final By linkRegister = By.xpath(".//a[text() = 'Зарегистрироваться']");
    private final By linkRecoveryPassword = By.xpath(".//a[text() = 'Восстановить пароль']");
    private final By textLoginPage = By.xpath(".//h2[text()='Вход']");


    public void enterEmail(String email) {
        driver.findElement(fieldEmail).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
    }

    public void clickButtonLogin() {
        driver.findElement(buttonLogin).click();
    }

    @Step("Переход к регистрации пользователя")
    public void followLinkRegisterStep() {
        driver.findElement(linkRegister).click();
    }

    @Step("Переход к восстановлению пароля")
    public void followLinkRecoveryPasswordStep() {
        driver.findElement(linkRecoveryPassword).click();
    }

    public boolean visibilityTextLogin() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(textLoginPage));
        return true;
    }

    @Step("Логин пользователя")
    public void loginUserStep(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickButtonLogin();
    }
}

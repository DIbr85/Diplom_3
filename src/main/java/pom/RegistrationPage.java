package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By fieldEmail = By.xpath("//label[text()='Email']/../input");
    private final By fieldPassword = By.xpath("//label[text()='Пароль']/../input");
    private final By fieldName = By.xpath("//label[text()='Имя']/../input");
    private final By buttonRegister = By.xpath("//button[text()='Зарегистрироваться']");
    private final By linkLogin = By.xpath("//a[text()='Войти']");
    private final By fieldError = By.xpath("//p[text()='Некорректный пароль']");


    public void setEmail(String email) {
        driver.findElement(fieldEmail).sendKeys(email);
    }


    public void setPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
    }


    public void setName(String name) {
        driver.findElement(fieldName).sendKeys(name);
    }

    public void clickButtonRegister() {
        driver.findElement(buttonRegister).click();
    }

    @Step("Переход к странице логина")
    public void clickLinkLoginStep() {
        driver.findElement(linkLogin).click();
    }

    public boolean visibilityFieldError() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(fieldError));
        return true;
    }

    @Step("Регистрация нового пользователя")
    public void registrationUserStep(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickButtonRegister();
    }

}

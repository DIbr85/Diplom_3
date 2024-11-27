package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAccountPage {
    private final WebDriver driver;

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By linkConstructor = By.xpath("//p[text()='Конструктор']");
    private final By logoStellarBurgers = By.className("AppHeader_header__logo__2D0X2");
    private final By buttonLogout = By.xpath("//button[text()='Выход']");

    @Step("Переход в конструктор по клику на «Конструктор»")
    public void clickLinkConstructorStep() {
        driver.findElement(linkConstructor).click();
    }

    @Step("Переход в конструктор по клику на логотип Stellar Burgers")
    public void clickLogoStellarBurgersStep() {
        driver.findElement(logoStellarBurgers).click();
    }


    public void clickButtonLogout() {
        driver.findElement(buttonLogout).click();
    }

    public void clickableButtonLogout() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(buttonLogout));
    }

    @Step("Выход из личного кабинета")
    public void logoutFromPersonalAccountStep() {
        clickableButtonLogout();
        clickButtonLogout();
    }

}

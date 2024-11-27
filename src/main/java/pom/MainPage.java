package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By buttonLoginToAccount = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By buttonPersonalAccount = By.xpath(".//p[text()='Личный Кабинет']");
    private final By sectionBuns = By.xpath(".//span[text()='Булки']");
    private final By sectionSauces = By.xpath(".//span[text()='Соусы']");
    private final By sectionFillings = By.xpath(".//span[text()='Начинки']");
    private final By selectedSection = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]");
    private final By textCreateBurger = By.xpath("//h1[text()='Соберите бургер']");


    @Step("Нажать на кнопку «Войти в аккаунт»")
    public void clickLoginToAccountStep() {
        driver.findElement(buttonLoginToAccount).click();
    }

    @Step("Нажать на кнопку «Личный кабинет»")
    public void clickPersonalAccountStep() {
        driver.findElement(buttonPersonalAccount).click();
    }

    @Step("Нажать на кнопку раздела «Булки»")
    public void clickSectionBunsStep() {
        driver.findElement(sectionBuns).click();
    }

    @Step("Нажать на кнопку раздела «Соусы»")
    public void clickSectionSaucesStep() {
        driver.findElement(sectionSauces).click();
    }

    @Step("Нажать на кнопку раздела «Начинки»")
    public void clickSectionFillingsStep() {
        driver.findElement(sectionFillings).click();
    }

    public String getSectionName() {
        new WebDriverWait(driver, Duration.ofSeconds(5));
        return driver.findElement(selectedSection).getText();
    }

    public boolean visibilityTextCreateBurger() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(textCreateBurger));
        return true;
    }
}

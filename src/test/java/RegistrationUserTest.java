import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pom.LoginPage;
import pom.MainPage;
import pom.RegistrationPage;


public class RegistrationUserTest extends BaseTest {

    @Test
    @DisplayName("Регистрация пользователя")
    @Description("Проверка успешной регистрации пользователя")
    public void testRegistrationUser() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginToAccountStep();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.followLinkRegisterStep();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registrationUserStep(name, email, password);
        Assert.assertTrue(loginPage.visibilityTextLogin());
    }

    @Test
    @DisplayName("Регистрация пользователя с невалидным паролем")
    @Description("Проверка неуспешной регистрации пользователя с паролем: менее шести символов")
    public void testRegistrationUserWithNotValidPassword() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginToAccountStep();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.followLinkRegisterStep();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registrationUserStep(name, email, notValidPassword);
        Assert.assertTrue(registrationPage.visibilityFieldError());
    }
}

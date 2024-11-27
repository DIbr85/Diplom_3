import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pom.LoginPage;
import pom.MainPage;
import pom.RecoveryPasswordPage;
import pom.RegistrationPage;

public class LoginUserTest extends BaseTest {
    @Before
    public void CreateUser() {
        userClient.createUserStep(user);
    }

    @Test
    @DisplayName("Логин пользователя с использованием кнопки «Войти в аккаунт»")
    @Description("Проверка успешного логина пользователя с использованием кнопки «Войти в аккаунт»")
    public void testLoginUserByButtonLoginToAccount() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginToAccountStep();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUserStep(email, password);
        Assert.assertTrue(mainPage.visibilityTextCreateBurger());
    }

    @Test
    @DisplayName("Логин пользователя с использованием кнопки «Личный кабинет»")
    @Description("Проверка успешного логина пользователя с использованием кнопки «Личный кабинет»")
    public void testLoginUserByButtonPersonalAccount() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountStep();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUserStep(email, password);
        Assert.assertTrue(mainPage.visibilityTextCreateBurger());
    }

    @Test
    @DisplayName("Логин пользователя через ссылку в форме регистрации")
    @Description("Проверка успешного логина пользователя через ссылку в форме регистрации")
    public void testLoginUserByLinkLogin() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginToAccountStep();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.followLinkRegisterStep();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickLinkLoginStep();
        loginPage.loginUserStep(email, password);
        Assert.assertTrue(mainPage.visibilityTextCreateBurger());
    }

    @Test
    @DisplayName("Логин пользователя через ссылку в форме восстановления пароля")
    @Description("Проверка успешного логина пользователя через ссылку в форме восстановления пароля")
    public void testLoginUserByLinkLoginFromRecoveryPassword() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginToAccountStep();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.followLinkRecoveryPasswordStep();
        RecoveryPasswordPage recoveryPasswordPage = new RecoveryPasswordPage(driver);
        recoveryPasswordPage.clickLinkLoginStep();
        loginPage.loginUserStep(email, password);
        Assert.assertTrue(mainPage.visibilityTextCreateBurger());
    }

}

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pom.LoginPage;
import pom.MainPage;
import pom.PersonalAccountPage;

public class PersonalAccountTest extends BaseTest {
    @Before
    public void CreateUser() {
        userClient.createUserStep(user);
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»")
    @Description("Проверка успешного перехода из личного кабинета в конструктор по клику на «Конструктор»")
    public void testClickButtonConstructor() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountStep();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUserStep(email, password);
        mainPage.clickPersonalAccountStep();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickLinkConstructorStep();
        Assert.assertTrue(mainPage.visibilityTextCreateBurger());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    @Description("Проверка успешного перехода из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void testClickLogoStellarBurgers() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountStep();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUserStep(email, password);
        mainPage.clickPersonalAccountStep();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickLogoStellarBurgersStep();
        Assert.assertTrue(mainPage.visibilityTextCreateBurger());
    }

    @Test
    @DisplayName("Выход из личного кабинета по кнопке «Выйти»")
    @Description("Проверка успешного выхода из личного кабинета по кнопке «Выйти»")
    public void testLogoutFromPersonalAccount() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountStep();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUserStep(email, password);
        mainPage.clickPersonalAccountStep();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.logoutFromPersonalAccountStep();
        Assert.assertTrue(loginPage.visibilityTextLogin());
    }
}

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pom.MainPage;

public class ChooseIngredientsTest extends BaseTest {
    @Override
    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    @Description("Проверка успешнойго перехода к разделу «Начинки»")
    public void testClickSectionFillings() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSectionFillingsStep();
        Assert.assertEquals("Начинки", mainPage.getSectionName());
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    @Description("Проверка успешнойго перехода к разделу «Соусы»")
    public void testClickSectionSauces() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSectionSaucesStep();
        Assert.assertEquals("Соусы", mainPage.getSectionName());
    }

    @Test
    @DisplayName("Переход к разделу «Булки»")
    @Description("Проверка успешнойго перехода к разделу «Булки»")
    public void testClickSectionBuns() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSectionSaucesStep();
        mainPage.clickSectionBunsStep();
        Assert.assertEquals("Булки", mainPage.getSectionName());
    }

}

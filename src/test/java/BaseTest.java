import client.UserClient;
import driver.WebDriverCreator;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;


import static generators.UserGenerator.*;
import static utils.Faker.*;

public class BaseTest {

    public WebDriver driver;
    public UserClient userClient = new UserClient();
    public User user;
    public String name = fakerName();
    public String email = fakerEmail();
    public String password = fakerValidPassword();
    public String notValidPassword = fakerNotValidPassword();
    public String baseUrl = "https://stellarburgers.nomoreparties.site/";



    @Before
    public void setUp() {
        WebDriverCreator driverCreator = new WebDriverCreator();
        driver = driverCreator.createWebDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        user = randomUser(email, password, name);

    }

    @After
    public void teardown() {
        driver.quit();
        String accessToken = userClient.getUserAccessTokenStep(user);
        if (accessToken != null) {
            userClient.deleteUserStep(accessToken);
        }
    }
}

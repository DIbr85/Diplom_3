package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverCreator {
    public WebDriver driver;

    public WebDriver createWebDriver() {
        String browser = System.getProperty("browser");
        if (browser == null) {
            return createChromeDriver();
        }

        return switch (browser) {
            case "yandex" -> createYandexDriver();
            case "chrome" -> createChromeDriver();
            default -> createChromeDriver();
        };
    }

    private WebDriver createChromeDriver() {
        driver = WebDriverManager.chromedriver().create();
        return driver;
    }

    private WebDriver createYandexDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        driver = new ChromeDriver();
        return driver;
    }
}
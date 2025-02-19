package scripts;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();

        String browserType = System.getProperty("browser", "chrome");

        switch (browserType.toLowerCase()) {
            case "chrome":
                browser = playwright.chromium()
                        .launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox()
                        .launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                browser = playwright.webkit()
                        .launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
        }
    }

    @BeforeEach
    void createContextandPage() {
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://demo1.cybersoft.edu.vn/");
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @AfterAll
    static void closeBrowser() {
        browser.close();
    }
}

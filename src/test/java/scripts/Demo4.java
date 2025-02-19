package scripts;

import com.microsoft.playwright.*;

public class Demo4 {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();

        Page page = context.newPage();

        page.navigate("https://google.com");

        Page page2 = context.newPage();

        page2.navigate("https://demo1.cybersoft.com");

    }
}

package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import com.microsoft.playwright.*;

public class Hooks {
    public static Playwright playwright;
    public static Browser browser;

    @Before
    public void setUp() {
        System.out.println("Cucumber @Before hook: Setting up Playwright");
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @After
    public void tearDown() {
        System.out.println("Cucumber @After hook: Tearing down Playwright");
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}

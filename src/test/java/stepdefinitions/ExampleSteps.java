package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.microsoft.playwright.*;

import static org.junit.Assert.assertEquals;

public class ExampleSteps {
    private static Playwright playwright;
    private static Browser browser;
    private static Page page;

    @Given("I open the homepage")
    public void i_open_the_homepage() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
        page = browser.newPage();
        page.navigate("https://example.com");
    }
    @Given("I open the {string}")
    public void i_open_the(String url) {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
        page = browser.newPage();
        page.navigate(url);
    }
    @Then("the title should be {string}")
    public void the_title_should_be(String expectedTitle) {
        String actualTitle = page.title();
        assertEquals(expectedTitle, actualTitle);
        browser.close();
        playwright.close();
    }
}

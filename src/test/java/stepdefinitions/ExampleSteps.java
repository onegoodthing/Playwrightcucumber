package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.microsoft.playwright.*;
import static org.junit.Assert.assertEquals;

public class ExampleSteps {

    private Page page;

    public ExampleSteps() {
        // zero-arg constructor (needed by Cucumber by default)
    }

    @Given("I open the homepage")
    public void i_open_the_homepage() {
        page = Hooks.browser.newPage();
        page.navigate("https://example.com");
    }

    @Given("I open the {string}")
    public void i_open_the(String url) {
        page = Hooks.browser.newPage();
        page.navigate(url);
    }

    @Then("the title should be {string}")
    public void the_title_should_be(String expectedTitle) {
        String actualTitle = page.title();
        assertEquals(expectedTitle, actualTitle);
    }
}

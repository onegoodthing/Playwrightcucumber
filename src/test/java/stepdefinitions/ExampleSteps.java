package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.microsoft.playwright.*;
import pages.WealthManagement;


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
    @Then("I click on {string}")
    public void i_click_on(String locator) {
        try {
            switch(locator){
                case "wealthMangement":
                    page.click(WealthManagement.wealthMangement);

                    break;
                case "bookconsulation":
                    page.click(WealthManagement.bookConsultation);
                    break;
                case "openColoumn":
                    page.click(WealthManagement.openColoumn);

                    break;
                case "wealthMangmentSubmenu":
                    page.click(WealthManagement.wealthMangmentSubmenu);
                    break;

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @And("I enter {string} with {string}" )
    public void i_enter(String field, String text) {
        try {
            switch (field.toLowerCase()){
                case "name":
                    page.fill(WealthManagement.name, text);
                    break;
                case "phone":
                    page.fill(WealthManagement.phone, text);
                    break;
                case "email":
                    page.fill(WealthManagement.email, text);
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @And("I Select {string}")
    public void i_Select(String text) {
        try {
            switch (text){
                case "No, I am not a Davy Client":
                    page.selectOption(WealthManagement.DavyClient, text);
                    break;
                case "Up to €500K":
                    page.selectOption(WealthManagement.Assets, text);
                    break;
                case "Investing":
                    page.selectOption(WealthManagement.Interest, text);
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

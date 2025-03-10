package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.microsoft.playwright.*;
import pages.WealthManagement;
import pages.AmazonLocators;


import java.util.List;

import static org.junit.Assert.assertEquals;
import static stepdefinitions.Hooks.browser;

public class ExampleSteps {

    private Page page;


    public ExampleSteps() {
        // zero-arg constructor (needed by Cucumber by default)
    }

    @Given("I open the homepage")
    public void i_open_the_homepage() {
        page = browser.newPage();
        page.navigate("https://example.com");
    }

    @Given("I open the {string}")
    public void i_open_the(String url) {
        page = browser.newPage();
        page.navigate(url);
    }

    @Then("the title should be {string}")
    public void the_title_should_be(String expectedTitle) {
        System.out.println("Inside the_title_should_be");
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

                case "searchBar":
                    page.click(AmazonLocators.searchBar);
                    break;
                case "searchButton":
                    page.click(AmazonLocators.searchButton);
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
                case "searchbar":
                    page.fill(AmazonLocators.searchBar, text);
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
    @And("I get all anchor tags on this page")
     public void i_get_all_anchor_tags_on_this_page() {
        System.out.println("i_get_all_anchor_tags_on_this_page");
        try {
           List<Locator> anchortag= page.locator("a").all();
        for(Locator anchor: anchortag){
            String href= anchor.getAttribute("href");
            System.out.println(href);
        }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @And("I open all the links in new tabs")
    public void i_open_all_all_links_in_new_tabs() {
        System.out.println("i_open_all_all_links_in_new_tabs");
        try {
            // Get all anchor tags
            List<Locator> anchors = page.locator("a[class='a-link-normal s-line-clamp-2 s-link-style a-text-normal']").all();

            for (Locator anchor : anchors) {
                String href = anchor.getAttribute("href");

                // Skip null or empty href
                if (href == null || href.isBlank()) {
                    continue;
                }

                // Build the final URL
                String finalUrl;
                // If it's already absolute (starts with http:// or https://), just use it
                if (href.startsWith("http://") || href.startsWith("https://")) {
                    finalUrl = href;
                }
                // Otherwise, assume it's relative and prepend the Amazon base
                else {
                    finalUrl = "https://www.amazon.in" + href;
                }

                System.out.println("Opening URL: " + finalUrl);
                Page newTab = browser.newPage();
                newTab.navigate(finalUrl);
                newTab.close();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}

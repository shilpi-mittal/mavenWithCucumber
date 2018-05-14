package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.PageObjectFactory;
import utils.TestCaseHelper;

import java.sql.SQLException;
import org.testng.Assert;

public class SearchTestSteps extends TestCaseHelper {

  @Before
  public void setup() throws SQLException {
    super.setup();
  }

  @Given("^I access home page$")
  public void I_access_home_page() {
    HomePage homePage = PageObjectFactory.getHomePage(testWebDriver);
    homePage.accessHomePage();
  }

  @When("^I enter search parameter \"([^\"]*)\"$")
  public void I_enter_search_parameter(String parameter) {
    HomePage homePage = PageObjectFactory.getHomePage(testWebDriver);
    homePage.enterSearchParameter(parameter);
  }

  @And("^I hit enter$")
  public void I_hit_enter() {
    HomePage homePage = PageObjectFactory.getHomePage(testWebDriver);
    homePage.hitEnter();
  }

  @Then("^I verify I am taken to new page$")
  public void I_verify_I_am_taken_to_new_page() {
    HomePage homePage = PageObjectFactory.getHomePage(testWebDriver);
    Assert.assertNotEquals(homePage.getBaseUrl(), homePage.getUrl());
  }

  @And("^I verify search results are displayed$")
  public void I_verify_search_results_are_displayed() {
    HomePage homePage = PageObjectFactory.getHomePage(testWebDriver);
    Assert.assertTrue(homePage.isTextDisplayed("hello"));
  }

  @Then("^I verify logo is displayed$")
  public void I_verify_logo_is_displayed() {
    HomePage homePage = PageObjectFactory.getHomePage(testWebDriver);
    testWebDriver.waitForPageToLoad();
    Assert.assertTrue(homePage.isLogoDisplayed());
  }

  @And("^I write text$")
  public void I_write_text() {
     System.out.println("cucu");
  }
}

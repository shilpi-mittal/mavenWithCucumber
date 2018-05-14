package functional;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.PageObjectFactory;
import utils.TestCaseHelper;

import java.sql.SQLException;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

public class BasicSearchTest extends TestCaseHelper {

  @BeforeMethod(groups = {"testNG"})
  public void setup() throws SQLException {
    super.setup();
  }

  @Test(groups = {"testNG"})
  public void verifyBasicSearch() throws SQLException {
    HomePage homePage = PageObjectFactory.getHomePage(testWebDriver);
    homePage.accessHomePage();
    testWebDriver.waitForPageToLoad();
    assertTrue(homePage.isLogoDisplayed());
    homePage.enterSearchParameter("hello");
    homePage.hitEnter();
    testWebDriver.waitForPageToLoad();
    assertNotEquals(homePage.getBaseUrl(), homePage.getUrl());
    assertTrue(homePage.isTextDisplayed("hello"));
  }

  @AfterMethod(groups = {"testNG"})
  public void tearDown() throws SQLException {
  }
}
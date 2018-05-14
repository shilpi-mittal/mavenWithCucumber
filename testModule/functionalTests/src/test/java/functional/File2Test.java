package functional;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestCaseHelper;

import java.sql.SQLException;

public class File2Test extends TestCaseHelper{
  @BeforeMethod(groups = {"test2"})
  public void setup() throws SQLException {
    super.setup();
  }

  @Test(groups = {"test2"})
  public void verify() throws SQLException {
//    HomePage homePage = PageObjectFactory.getHomePage(testWebDriver);
//    homePage.accessHomePage();
//    testWebDriver.waitForPageToLoad();
//    assertTrue(homePage.isLogoDisplayed());
//    System.out.println("test2") ;
  }

  @AfterMethod(groups = {"test2"})
  public void tearDown() throws SQLException {
//    dbWrapper.closeConnection();
  }
}

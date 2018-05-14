package pageObjects;

import utils.TestWebDriver;

public class PageObjectFactory {
  private static Page instanceOfPage;
  private static HomePage instanceOfHomePage;

  public static Page getPage(TestWebDriver testWebDriver) {
    if(instanceOfPage == null) {
      instanceOfPage = new Page(testWebDriver);
    }
    return instanceOfPage;
  }

  public static HomePage getHomePage(TestWebDriver testWebDriver) {
    if(instanceOfHomePage == null) {
      instanceOfHomePage = new HomePage(testWebDriver);
    }
    return instanceOfHomePage;
  }
}
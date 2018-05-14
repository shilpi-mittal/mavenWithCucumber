package pageObjects;

import utils.TestWebDriver;

public class Page {
  public TestWebDriver testWebDriver;
  private static String baseUrl = "https://www.google.co.in";

  public Page(TestWebDriver testWebDriver) {
    this.testWebDriver = testWebDriver;
  }

  public HomePage accessHomePage() {
    testWebDriver.navigateTo(baseUrl);
    return PageObjectFactory.getHomePage(testWebDriver);
  }

  public String getUrl() {
    return testWebDriver.getCurrentUrl();
  }

  public String getBaseUrl() {
    return baseUrl;
  }
}

package utils;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.annotations.Until;

public class TestWebDriver {
  private static final long DEFAULT_WAIT_TIME = 10;
  private static WebDriver webDriver;
  private static String BASE_URL;

  public TestWebDriver(WebDriver driver) {
    TestWebDriver.webDriver = driver;
    maximizeWindows();
  }

  public void setBaseUrl(String BASE_URL) {
    webDriver.manage().deleteAllCookies();
    TestWebDriver.BASE_URL = BASE_URL;
  }

  public void maximizeWindows() {
    webDriver.manage().window().maximize();
  }

  public boolean isDisplayed(WebElement element) {
    return element.isDisplayed();
  }

  public void waitForElementToAppear(final WebElement element) {
//    (new WebDriverWait(webDriver, DEFAULT_WAIT_TIME)).until(new ExpectedCondition<Boolean>() {
//      public Boolean apply(WebDriver d) {
//        return (element.isDisplayed());
//      }
//    });
    
  }

  public WebElement waitForElementExists(final String selector, String timeout) {
	    Wait<WebDriver> wait = new WebDriverWait(webDriver, DEFAULT_WAIT_TIME);

	    WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	        public WebElement apply(WebDriver driver) {
	            return driver.findElement(By.cssSelector(selector));
	        }
	    });

	    return element;
	 }

  
  public String getCurrentUrl() {
    return webDriver.getCurrentUrl();
  }  

  public WebElement findElement(By by) {
    return webDriver.findElement(by);
  }

  public void quitDriver() {
    webDriver.quit();
  }

  public static WebDriver getDriver() {
    return webDriver;
  }

  public void navigateTo(String url) {
    webDriver.navigate().to(url);
  }

  public void sleep(int time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

//  public void waitForPageToLoad() {
//    try {
//      Thread.sleep(1000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    (new WebDriverWait(webDriver, DEFAULT_WAIT_TIME)).until(new ExpectedCondition<Boolean>() {
//      public Boolean apply(WebDriver d) {
//        return (((org.openqa.selenium.JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
//      }
//    });
//  }
  
  public void waitForPageToLoad() {

    Wait<WebDriver> wait = new WebDriverWait(webDriver, 30);
    wait.until(new Function<WebDriver, Boolean>() {
        public Boolean apply(WebDriver driver) {
            return String
                .valueOf(((JavascriptExecutor) webDriver).executeScript("return document.readyState"))
                .equals("complete");
        }
    });
  }
}

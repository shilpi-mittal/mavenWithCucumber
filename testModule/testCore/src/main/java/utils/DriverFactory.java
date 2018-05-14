package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

import static java.lang.System.getProperty;

public class DriverFactory {
  //private String driverType;

    static String chromeDriverPath = "chromedriver.exe";

    public ChromeDriver createChromeDriver() {
    	System.out.println("------------------" + System.getProperty("user.dir") + "\\" + chromeDriverPath);
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\" + chromeDriverPath);
        //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }

  protected WebDriver loadDriver() {
    //driverType = getProperty("web.driver", "Firefox");

    return createChromeDriver();
  }

//  private WebDriver createFirefoxDriver() {
//    boolean headless = Boolean.parseBoolean(getProperty("headless", "false"));
//    System.setProperty("webdriver.gecko.driver","geckodriver.exe");
//    FirefoxProfile profile = new FirefoxProfile();
//    profile.setAcceptUntrustedCertificates(true);
//    profile.setPreference("signed.applets.codebase_principal_support", true);
//    profile.setPreference("javascript.enabled", true);
//    profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv");
//    profile.setPreference("browser.download.dir", new File(System.getProperty("user.dir")).getParent());
//    profile.setPreference("browser.download.folderList", 2);
//    profile.setPreference("dom.storage.enabled", true);
//    profile.setPreference("device.storage.enabled", true);
//
//    if ((getProperty("os.name").toLowerCase().contains("mac")) && headless) {
//      String LOCAL_FIREFOX_X11_PATH = "/opt/local/bin/firefox-x11";
//      File binaryFile = new File(LOCAL_FIREFOX_X11_PATH);
//      FirefoxBinary binary = new FirefoxBinary(binaryFile);
//      String LOCAL_X11_DISPLAY = ":5";
//      binary.setEnvironmentProperty("DISPLAY", LOCAL_X11_DISPLAY);
//      return new FirefoxDriver(binary, profile);
//    }
//    return new FirefoxDriver(profile);
//  }
}

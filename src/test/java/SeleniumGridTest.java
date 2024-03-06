import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.solvd.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SeleniumGridTest {
    protected WebDriver driver;
    String gridUrl="http://localhost:4444";
    protected HomePage home;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(new URL(gridUrl), chromeOptions);
        driver.get("https://www.ebay.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        home= PageFactory.initElements(driver, HomePage.class);
    }
    @Test
    public void searchbarTest(){
        String search="iPad";
        home.clickOnSearchbar();
        home.sendKeysToSearchbar(search);
        home.clickOnSearchBtn();
        Assert.assertTrue(home.resultsContainSearch(search));
    }
    @Test
    public void carouselTitlesTest(){
        Assert.assertTrue(home.areCarouselTitlesPresent());
    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}

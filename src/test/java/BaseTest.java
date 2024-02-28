import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.solvd.HomePage;
import org.solvd.ProductDetailPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage home;
    protected ProductDetailPage product;

    @BeforeTest
    public void setUp(){
        driver=new ChromeDriver();
        driver.get("https://www.ebay.com/");
        home= PageFactory.initElements(driver, HomePage.class);
        product= PageFactory.initElements(driver, ProductDetailPage.class);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}

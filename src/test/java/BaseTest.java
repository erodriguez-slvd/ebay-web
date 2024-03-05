import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.solvd.HomePage;
import org.solvd.ProductDetailPage;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseTest implements ITestListener {
    public static final Logger LOGGER= Logger.getLogger(String.valueOf(HomePage.class));
    String filePath = "/Users/solvd/Documents/Projects/ebay-Web/src/test/screenshots/";
    protected WebDriver driver;
    protected HomePage home;
    protected ProductDetailPage product;

    @BeforeTest
    public void setUp(ITestContext context){
        driver=new ChromeDriver();
        driver.get("https://www.ebay.com/");
        home= PageFactory.initElements(driver, HomePage.class);
        product= PageFactory.initElements(driver, ProductDetailPage.class);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        context.setAttribute("WebDriver", driver);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getName().toString().trim()+result.id();
        LOGGER.warning("***** "+result.getName()+" test has failed *****");
        ITestContext context = result.getTestContext();
        WebDriver driverContext = (WebDriver)context.getAttribute("WebDriver");
        try {
            takeScreenshot(methodName, driverContext);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void takeScreenshot(String methodName, WebDriver driver) throws IOException, InterruptedException {
        //Convert web driver object to TakeScreenshot
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        //Call getScreenshotAs method to create image file
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File destFile=new File(filePath+methodName+".png");
        //Copy file at destination
        FileUtils.copyFile(srcFile, destFile);
        LOGGER.info("Placed screenshot in "+filePath+" as "+methodName+".png"+" ***");
    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}

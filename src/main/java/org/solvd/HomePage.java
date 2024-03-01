package org.solvd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class HomePage extends CommonPage{
    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public static final Logger LOGGER= Logger.getLogger(String.valueOf(HomePage.class));
    @FindBy(css ="input[id='gh-ac']")
    private WebElement searchBar;
    @FindBy(css ="input[id='gh-btn']")
    private WebElement searchButton;
    @FindBy(xpath ="//ul[@class='srp-results srp-list clearfix']/li")
    private List<WebElement> resultsList;
    @FindBy(xpath = "//div[@class='carousel vl-carousel carousel--slides carousel--peek']/descendant::h3")
    private List<WebElement> todayDealsTitlesCarousel;
    @FindBy(xpath = "//div[@class='carousel vl-carousel carousel--slides carousel--peek']/descendant::button[@class='carousel__control carousel__control--next']")
    private WebElement carouselNextButton;


    public void clickOnSearchbar(){
        clickOnElement(searchBar);
    }
    public void sendKeysToSearchbar(String input){
        sendKeysToElement(searchBar,input);
    }
    public void clickOnSearchBtn(){
        clickOnElement(searchButton);
    }

    public boolean resultsContainSearch(String input){
        for (WebElement e:resultsList) {
            if (e.getText().contains(input)){
                return true;
            }
        }
        return false;
    }

    public boolean areCarouselTitlesPresent(){
        for (WebElement e:todayDealsTitlesCarousel) {
            System.out.println(e.getText());
            if(e.getText().isEmpty()){
                return false;
            }
        }
        return true;
    }

    public ProductDetailPage clickOnACarouselProduct(){
        //int index= (int) (Math.random()*todayDealsTitlesCarousel.size());
        int index=7;
        System.out.println(todayDealsTitlesCarousel.get(index).getText());
        clickOnElement(carouselNextButton);
        wait5Seconds();
        clickOnElement(todayDealsTitlesCarousel.get(index));
        wait5Seconds();
        return PageFactory.initElements(driver, ProductDetailPage.class);
    }

    public void switchToNewWindow(){
        Set<String> handles=driver.getWindowHandles();
        Iterator it=handles.iterator();
        String parent= (String) it.next();
        String child= (String) it.next();
        driver.switchTo().window(child);
    }

}

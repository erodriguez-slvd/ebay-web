package org.solvd;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Logger;

public class HomePage {
    public static final Logger LOGGER= Logger.getLogger(String.valueOf(HomePage.class));
    @FindBy(css ="input[id='gh-ac']")
    private WebElement searchBar;
    @FindBy(css ="input[id='gh-btn']")
    private WebElement searchButton;
    @FindBy(xpath ="//ul[@class='srp-results srp-list clearfix']/li")
    private List<WebElement> resultsList;
    @FindBy(xpath = "//div[@class='carousel vl-carousel carousel--slides carousel--peek']/descendant::h3")
    private List<WebElement> todayDealsTitlesCarousel;


    public void clickOnSearchbar(){
        searchBar.click();
    }
    public void sendKeysToSearchbar(String input){
        searchBar.sendKeys(input);
    }
    public void clickOnSearchBtn(){
        searchButton.click();
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

}

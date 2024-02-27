package org.solvd;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage {
    @FindBy(css ="input[id='gh-ac']")
    private WebElement searchBar;
    @FindBy(css ="input[id='gh-btn']")
    private WebElement searchButton;
    @FindBy(xpath ="//ul[@class='srp-results srp-list clearfix']/li")
    private List<WebElement> resultsList;

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

}

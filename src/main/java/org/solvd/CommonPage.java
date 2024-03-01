package org.solvd;

import org.openqa.selenium.WebElement;

public abstract class CommonPage {
    public void clickOnElement(WebElement element){
        element.click();
    }
    public  void sendKeysToElement(WebElement element, String input){
        element.sendKeys(input);
    }
    public void wait5Seconds(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

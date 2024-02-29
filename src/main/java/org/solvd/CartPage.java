package org.solvd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {
    private WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "button[data-test-id='cta-top']")
    private WebElement checkoutBtn;
    @FindBy(css = "button[data-test-id='cart-remove-item']")
    private WebElement deleteBtn;
    @FindBy(css = "div[id='confirmation-status']")
    private WebElement confirmationMessage;


    public boolean isCheckoutBtnPresent(){
        return checkoutBtn.isDisplayed();
    }
    public void clickOnDeleteBtn(){
        deleteBtn.click();
    }
    public boolean isConfirmationMessagePresent(){
        return confirmationMessage.isDisplayed();
    }



}

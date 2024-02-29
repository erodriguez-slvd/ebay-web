package org.solvd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
    @FindBy(css = "div[class='quantity'] select[data-test-id='qty-dropdown']")
    private WebElement quantityBtn;
    @FindBy(css = "div[class='item-price font-title-3']")
    private WebElement productPrice;


    public boolean isCheckoutBtnPresent(){
        return checkoutBtn.isDisplayed();
    }
    public void clickOnDeleteBtn(){
        deleteBtn.click();
    }
    public boolean isConfirmationMessagePresent(){
        return confirmationMessage.isDisplayed();
    }
    public void selectQuantityOptions(){
        quantityBtn.click();
        Select staticDropdownOptions =new Select(quantityBtn);
        staticDropdownOptions.selectByValue("2");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String getProductPrice(){
        return productPrice.getText();
    }
}

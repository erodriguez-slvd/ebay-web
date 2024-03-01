package org.solvd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
        String option="2";
        quantityBtn.click();
        Select staticDropdownOptions =new Select(quantityBtn);
        staticDropdownOptions.selectByValue(option);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(text(),'(2)')]"),option));
    }
    public String getProductPrice(){
        return productPrice.getText();
    }
}

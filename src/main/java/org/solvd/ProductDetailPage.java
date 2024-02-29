package org.solvd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {
    private WebDriver driver;
    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//h1/descendant::span[@class='ux-textspans ux-textspans--BOLD']")
    private WebElement productTitle;
    @FindBy(css = ".x-price-primary")
    private WebElement productPrice;
    @FindBy(css = "#binBtn_btn_1")
    private WebElement buyNowBtn;
    @FindBy(css = "div[data-testid='x-atc-action'] a[data-testid='ux-call-to-action']")
    private WebElement addToCartBtn;

    public boolean isProductTitlePresent(){
        return productTitle.isDisplayed();
    }
    public boolean isProductPricePresent(){
        return  productPrice.isDisplayed();
    }
    public boolean isBuyNowBtnPresent(){
        return buyNowBtn.isDisplayed();
    }

    public CartPage clickOnAddToCartBtn(){
        addToCartBtn.click();
        return PageFactory.initElements(driver, CartPage.class);
    }

}

import org.solvd.CartPage;
import org.solvd.ProductDetailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest{
    @Test
    public void addProductToCartTest(){
        ProductDetailPage product=home.clickOnACarouselProduct();
        home.switchToNewWindow();
        CartPage cart=product.clickOnAddToCartBtn();
        Assert.assertTrue(cart.isCheckoutBtnPresent());
    }
    @Test
    public void deleteProductFromCartTest(){
        ProductDetailPage product=home.clickOnACarouselProduct();
        home.switchToNewWindow();
        CartPage cart=product.clickOnAddToCartBtn();
        cart.clickOnDeleteBtn();
        Assert.assertTrue(cart.isConfirmationMessagePresent());
    }
    @Test
    public void itemIdTest(){
        ProductDetailPage product=home.clickOnACarouselProduct();
        home.switchToNewWindow();
        Assert.assertTrue(product.isItemIdPresent());
    }
}

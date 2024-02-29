import org.solvd.CartPage;
import org.solvd.ProductDetailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest{
    @Test
    public void addToCartTest(){
        ProductDetailPage product=home.clickOnACarouselProduct();
        home.switchToNewWindow();
        CartPage cart=product.clickOnAddToCartBtn();
        Assert.assertTrue(cart.isCheckoutBtnPresent());
    }
}

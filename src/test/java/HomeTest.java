import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(BaseTest.class)
public class HomeTest extends BaseTest{
    @Test
    public void searchbarTest(){
        String search="iPad";
        home.clickOnSearchbar();
        home.sendKeysToSearchbar(search);
        home.clickOnSearchBtn();
        Assert.assertTrue(home.resultsContainSearch(search));
    }
    @Test
    public void carouselTitlesTest(){
        Assert.assertTrue(home.areCarouselTitlesPresent());
    }
    @Test
    public void productDetailsTest(){
        home.clickOnACarouselProduct();
        home.switchToNewWindow();
        product.isProductTitlePresent();
        product.isProductPricePresent();
        Assert.assertTrue(product.isBuyNowBtnPresent());
    }


}

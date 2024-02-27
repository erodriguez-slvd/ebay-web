import org.solvd.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest{
    @Test
    public void searchbarTest(){
        String search="iPad";
        home.clickOnSearchbar();
        home.sendKeysToSearchbar(search);
        home.clickOnSearchBtn();
        Assert.assertTrue(home.resultsContainSearch(search));
    }
}

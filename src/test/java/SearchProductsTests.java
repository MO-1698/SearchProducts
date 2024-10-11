import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.example.SearchProductsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchProductsTests {
    private SHAFT.GUI.WebDriver driver;

    @BeforeMethod
    @Description("this is a setup class for our test")
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
    }

    @Test(description = "Validate search products")
    private void validateSearchProducts() {
        new SearchProductsPage(driver).navigateToURL("https://automationexercise.com/")
                .ValidateHomePage().clickOnProductButton().ValidateAllProduct().typeInSearchProduct("Tshirt")
                .clickSearchButton().ValidateSearchedProductsText().ValidateProductsVisibility();
    }
}
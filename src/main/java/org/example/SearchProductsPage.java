package org.example;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SearchProductsPage {
    private SHAFT.GUI.WebDriver driver;

    public SearchProductsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By HomePage = By.xpath("//a[@style=\"color: orange;\"]");
    private By ProductButton = By.xpath("//a[@href=\"/products\"]");
    private By AllProduct = By.xpath("//h2[@class=\"title text-center\"]");
    private By SearchProduct = By.xpath("//input[@id='search_product']");
    private By SearchButton = By.xpath("//button[@type=\"button\"]");
    private By SearchedProductsText = By.xpath("//h2[@class='title text-center']");
    private By ProductsVisibility = By.xpath("//div[@class='features_items']");


    public SearchProductsPage navigateToURL(String URL) {
        driver.browser().navigateToURL(URL);
        return this;
    }

    public SearchProductsPage clickOnProductButton() {
        driver.element().click(ProductButton);
        return this;
    }

    public SearchProductsPage typeInSearchProduct(String productName) {
        driver.element().waitToBeReady(SearchProduct);
        driver.element().type(SearchProduct, productName);
        return this;
    }


    public SearchProductsPage clickSearchButton() {
        driver.element().click(SearchButton);
        return this;
    }


    @Step("Validate that the user is on Home Page")
    public SearchProductsPage ValidateHomePage() {
        driver.element().verifyThat(HomePage).text().contains("Home");
        return this;
    }

    @Step("Validate that the user is on product page")
    public SearchProductsPage ValidateAllProduct(){
        driver.element().verifyThat(AllProduct).text().isEqualTo("ALL PRODUCTS");
        return this;
    }

    @Step("Validate that SEARCHED PRODUCTS text is visible")
    public SearchProductsPage ValidateSearchedProductsText(){
        driver.element().verifyThat(SearchedProductsText).text().contains("SEARCHED PRODUCTS");
        return this;
    }

    @Step("Validate that the searched products are visible")
    public SearchProductsPage ValidateProductsVisibility(){
        driver.element().verifyThat(ProductsVisibility).text().contains("Tshirt");
        return this;
    }
}

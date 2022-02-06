import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductPage;

public class AddingProductToTheCart extends BaseTest {

    HomePage homePage;
    ProductPage productPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    @Test
    @Order(1)
    public void click_hover_menu() throws InterruptedException {//click golf
        homePage = new HomePage(driver);
        Assertions.assertTrue(homePage.isOnHomePage(), "Error!"); // verifies that they went to this address.
        Assertions.assertTrue(homePage.isUrlCorrect("https://rapsodo.com/"));// verifies that they went to this address.
        homePage.clickMenu();
        Assertions.assertTrue(homePage.isOnItemHomePage(), "Not on a hover menu!");
        Thread.sleep(5000);
    }

    @Test
    @Order(2)
    public void click_a_item() {//click MLM, go to MLM product page
        productPage = new ProductPage(driver);
        homePage.clickItem();
        Assertions.assertTrue(productPage.isOnProductPage(), "Error!"); //verifies the page's title correct
        Assertions.assertTrue(productPage.isCorrectShopItemandAmount("0","0"),"Not a correct shop items and amount."); //verifies there is 0 item and $0.00
    }

    @Test
    @Order(3)
    public void click_shop_now() { //click SHOP NOW to get product detail page
        productDetailPage = new ProductDetailPage(driver);
        productPage.clickButton();
        Assertions.assertTrue(productDetailPage.isUrlCorrect("mobile-launch-monitor"), "Not a correct url!");
    }


    @Test
    @Order(4)
    public void add_product_to_cart() throws InterruptedException { // add 2 mlm products to the cart, go to cart
        cartPage = new CartPage(driver);
        Thread.sleep(5000);
        productDetailPage.addToCart();
        Assertions.assertTrue(cartPage.isUrlCorrect("cart"), "Not a correct url!");


    }

    @Test
    @Order(5)
    public void view_cart() throws InterruptedException {
        cartPage.viewCart();
        Assertions.assertTrue(cartPage.checkIfProductAdded("2", "999.98"), "Product was not added to cart!");
        Thread.sleep(5000);
    }

    @Test
    @Order(6)
    public void apply_coupon() throws InterruptedException { //use incorrect coupon code to get error message
        Thread.sleep(5000);
        cartPage.applyCoupon("GOLFTHEBEST");
        Thread.sleep(5000);
        Assertions.assertTrue(cartPage.displayedErrorMessage());

    }



}

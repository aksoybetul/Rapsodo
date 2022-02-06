package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {

    By addToCartButton = By.xpath("//*[@class='single_add_to_cart_button button alt']");
    By plusButton = By.xpath("//*[@id='plus_qty']");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }


    public void addToCart() throws InterruptedException {
        scrollToElement(addToCartButton);
        Thread.sleep(5000);
        click(plusButton);
        click(addToCartButton);
    }


}

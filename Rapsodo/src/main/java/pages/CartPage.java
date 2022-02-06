package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    By viewCartButton = By.xpath("//*[text()='View Cart']");
    By amountPriceText = By.xpath("//span[@class='Description']");
    By couponCode = By.id("coupon_code");
    By applyCouponButton = By.name("apply_coupon");
    By couponErrorMessage = By.xpath("//*[@class='woocommerce-error']");
    By rapsodoLogo = By.xpath("//*[@class='RapsodoLogo Desktop']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfProductAdded(String amount, String price) {
        boolean flag = false;
        String priceStr = find(amountPriceText).getText();
        String amountStr = find(amountPriceText).getText();
        if (priceStr.contains(price) && (amountStr.contains(amount))) {
            flag = true;
        }
        return flag;
    }


    public void viewCart() {
        click(viewCartButton);
    }

    public void applyCoupon(String code) {
        scrollToElement(couponCode);
        type(couponCode, code);
        click(applyCouponButton);

    }

    public boolean displayedErrorMessage() {
        scrollToElement(rapsodoLogo);
        boolean flag = false;
        if (isDisplayed(couponErrorMessage))
            flag = true;
        return flag;
    }
}

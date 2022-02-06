package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    By shopNowButton = By.xpath("//span[text()='SHOP NOW']");
    By pageTitle = By.xpath("//title[text()=\"Golf Swing Analyzer | Improve Your Swing | Rapsodo\"]");
    By amountPriceText = By.xpath("//span[@class='Description']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductPage() {
        boolean flag = false;
        String websitePageTitle = driver.getTitle();
        String verifiedTitle = driver.findElement(pageTitle).getText();
        if (websitePageTitle.contains(verifiedTitle)) { //The reason I use the contains method is in case there are spaces at the beginning and end of the title on the site.
            flag = true;
        }
        return flag;

    }


    public void clickButton() {
        click(shopNowButton);
    }


    public boolean isCorrectShopItemandAmount(String amount, String price) {
        boolean flag = false;
        String priceStr = find(amountPriceText).getText();
        String amountStr = find(amountPriceText).getText();
        if (priceStr.contains(price) && (amountStr.contains(amount))) {
            flag = true;
        }
        return flag;
    }
}


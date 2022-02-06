package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    By golfMenuButton = By.xpath("(//a[text()=\"GOLF\"])[2]");
    public static final By mlmButton = By.xpath("//span[text()=\"MLM\"]");
    By rapsodoLogo = By.xpath("//*[@class='RapsodoLogo Desktop']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickMenu() {
        mouseOver(golfMenuButton);
    }

    public void clickItem() {
        click(mlmButton);
    }

    public boolean isOnItemHomePage() {
        return isDisplayed(mlmButton);
    }


    public boolean isOnHomePage() {
        return isDisplayed(rapsodoLogo) && isDisplayed(golfMenuButton);
    }
}

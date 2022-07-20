package BookingTest.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class RentCarPage extends BasePage{
    public RentCarPage(WebDriver driver) {
        super(driver);
    }

    public WebElement enterLocation() {
        return waitElementToBeClickable("//input[@id= 'ss_origin']");
    }
    public List<WebElement> choiceLocation() {
        return waitVisibilityOfAllElementsLocatedBy("//span[@class= 'search_hl_name']");
    }
    public WebElement clickSearchBtn() {
        return driver.findElement(By.cssSelector("span.js-sb-submit-text"));
    }
    public WebElement checkTableVisible() {
        return waitElementToBeClickable("//table[@class= 'ab-SearchSummary']");
    }
}

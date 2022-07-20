package BookingTest.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HotelHomePage extends BasePage{
    public HotelHomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement checkFieldDateIn() {
        return waitElementToBeClickable("//div[@data-placeholder='Check-in Date']");
    }
    public WebElement checkFieldDateOut() {
        return waitElementToBeClickable("//div[@data-placeholder='Check-out Date']");
    }
}

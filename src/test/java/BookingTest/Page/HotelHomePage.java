package BookingTest.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HotelHomePage extends BasePage{
    public HotelHomePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> checkFieldDate() {
        return driver.findElements(By.xpath("//div[@class= 'xp__dates-inner']"));
    }
}

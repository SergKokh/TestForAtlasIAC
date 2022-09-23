package BookingTest.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NewYorkHotelPage extends BasePage {
    public NewYorkHotelPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkHotelInNewYorkOnly() {
        boolean result = false;
        for (WebElement city : hotelInNewYorkOnly()) {
            if (city.getText().contains("New York")) {
                result = true;
            }
            else {
                result = false;
                break;
            }
        }
        return result;
    }
    public List<WebElement> hotelInNewYorkOnly() {
        return driver.findElements(By.xpath("//span[@data-testid= 'address']"));
    }
}

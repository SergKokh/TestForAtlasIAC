package BookingTest.Page;

import BookingTest.Test.TestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DatesFieldPage extends BasePage {
    public DatesFieldPage(WebDriver driver) {
        super(driver);
    }

    public void changeMonth() {
        String st = "December 2022";
        while (!st.equals(choiceDate().get(0).getText())) {
            clickChangeDateBtn().click();
        }
    }
    public void changeDate(){
        DatesFieldPage datesField = new DatesFieldPage(driver);
        datesField.changeMonth();
        datesField.changeDateIn().get(0).click();
        datesField.clickFieldChangeDateOff().click();
        datesField.changeDateOff().click();
        datesField.clickSearchBtn().click();
    }
    public void changeTab() {
        ArrayList tabs2 = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window(String.valueOf(tabs2.get(1)));

    }
    public List<WebElement> choiceDate() {
        return driver.findElements(By.xpath("//h3[@class=  'ac78a73c96 ab0d1629e5']"));
    }
    public WebElement clickChangeDateBtn() {
        return driver.findElement(By.xpath("//button[contains(@class,'be298b15fa')]/span"));
    }
    public List<WebElement> changeDateIn() {
        return driver.findElements(By.cssSelector("td:nth-child(4) > span"));
    }
    public WebElement clickFieldChangeDateOff() {
        return driver.findElement(By.xpath("//button[@data-testid= 'date-display-field-end']"));
    }
    public WebElement changeDateOff() {
        return driver.findElement(By.xpath("//span[@aria-label='31 December 2022']//span"));
    }
    public WebElement clickSearchBtn() {
        return driver.findElement(By.xpath("//button[@type= 'submit']"));
    }
    public List<WebElement> choiceHotel() {
        return waitVisibilityOfAllElementsLocatedBy("//span[contains(text(), 'See availability')]");
    }
}


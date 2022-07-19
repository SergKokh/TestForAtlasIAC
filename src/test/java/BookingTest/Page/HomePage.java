package BookingTest.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void openBooking(){
        driver.get("https://www.booking.com/");
    }


    public WebElement clickLanguageBtn() {
        return waitElementToBeClickable("//img[@class= 'bui-avatar__image']");
    }

    public List<WebElement> choiceLanguageEnglish() {
        return waitVisibilityOfAllElementsLocatedBy("//div[contains(text(), 'English (US)')]");
    }

    public WebElement choiceNewYorkCity() {
        return driver.findElement(By.cssSelector("#ss"));
    }
    public WebElement clickSerchBtn() {
        return driver.findElement(By.xpath("//button//span[contains(text(), 'Search')]"));
    }

    public void changeLanguage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLanguageBtn().click();
        homePage.choiceLanguageEnglish().get(0).click();
    }
    public void choiceCity(){
        HomePage homePage = new HomePage(driver);
        homePage.choiceNewYorkCity().sendKeys("New York\n");
    }



}

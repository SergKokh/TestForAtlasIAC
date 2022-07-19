package BookingTest.Test;

import BookingTest.Page.DatesFieldPage;
import BookingTest.Page.HomePage;
import BookingTest.Page.HotelHomePage;
import BookingTest.Page.NewYorkHotelPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestBooking extends TestInit{


    @Test
    public void checkChoiceNewYorkCity(){
        HomePage homePage = new HomePage(driver);
        DatesFieldPage datesField = new DatesFieldPage(driver);
        NewYorkHotelPage newYorkHotel = new NewYorkHotelPage(driver);
        homePage.openBooking();
        homePage.changeLanguage();
        homePage.choiceCity();
        homePage.clickSerchBtn().click();
        datesField.changeDate();

        Assert.assertTrue(newYorkHotel.checkHotelInNewYorkOnly());
    }

    @Test
    public void checkConformityDate(){
        HomePage homePage = new HomePage(driver);
        DatesFieldPage datesField = new DatesFieldPage(driver);
        NewYorkHotelPage newYorkHotel = new NewYorkHotelPage(driver);
        HotelHomePage hotelHome = new HotelHomePage(driver);
        homePage.openBooking();
        homePage.changeLanguage();
        homePage.choiceCity();
        homePage.clickSerchBtn().click();
        datesField.changeDate();
        datesField.choiceHotel().get(0).click();
//        String oldTab = driver.getWindowHandle();
//        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
//        newTab.remove(oldTab);
//        driver.switchTo().window(newTab.get(0));
        hotelHome.testSwichTo().click();

        Assert.assertTrue(hotelHome.checkFieldDate().get(0).getText().contains("Thu, Dec 1"));
        Assert.assertTrue(hotelHome.checkFieldDate().get(1).getText().contains("Sat, Dec 31"));
    }
}

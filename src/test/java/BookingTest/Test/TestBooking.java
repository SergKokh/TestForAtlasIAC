package BookingTest.Test;

import BookingTest.Page.DatesFieldPage;
import BookingTest.Page.HomeBooking;
import BookingTest.Page.HotelHomePage;
import BookingTest.Page.NewYorkHotelPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestBooking extends TestInit{


    @Test
    public void checkChoiceNewYorkCity(){
        HomeBooking homeBooking = new HomeBooking(driver);
        DatesFieldPage datesField = new DatesFieldPage(driver);
        NewYorkHotelPage newYorkHotel = new NewYorkHotelPage(driver);
        homeBooking.openBooking();
        homeBooking.changeLanguage();
        homeBooking.choiceCity();
        homeBooking.clickSerchBtn().click();
        datesField.changeDate();

        Assert.assertTrue(newYorkHotel.checkHotelInNewYorkOnly());
    }

    @Test
    public void checkConformityDate(){
        HomeBooking homeBooking = new HomeBooking(driver);
        DatesFieldPage datesField = new DatesFieldPage(driver);
        NewYorkHotelPage newYorkHotel = new NewYorkHotelPage(driver);
        HotelHomePage hotelHome = new HotelHomePage(driver);
        homeBooking.openBooking();
        homeBooking.changeLanguage();
        homeBooking.choiceCity();
        homeBooking.clickSerchBtn().click();
        datesField.changeDate();
        datesField.choiceHotel().get(0).click();
        String oldTab = driver.getWindowHandle();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(0));

        Assert.assertTrue(hotelHome.checkFieldDate().get(0).getText().contains("Thu, Dec 1"));
        Assert.assertTrue(hotelHome.checkFieldDate().get(1).getText().contains("Sat, Dec 31"));
    }
}

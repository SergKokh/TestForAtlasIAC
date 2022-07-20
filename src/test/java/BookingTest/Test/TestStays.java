package BookingTest.Test;

import BookingTest.Page.DatesFieldPage;
import BookingTest.Page.HomePage;
import BookingTest.Page.HotelHomePage;
import BookingTest.Page.NewYorkHotelPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestStays extends TestInit{

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
        HotelHomePage hotelHome = new HotelHomePage(driver);
        homePage.openBooking();
        homePage.changeLanguage();
        homePage.choiceCity();
        homePage.clickSerchBtn().click();
        datesField.changeDate();
        datesField.choiceHotel().get(0).click();
        datesField.changeTab();

        Assert.assertTrue(hotelHome.checkFieldDateIn().getText().contains("Thursday, December 1, 2022"));
        Assert.assertTrue(hotelHome.checkFieldDateOut().getText().contains("Saturday, December 31, 2022"));
    }
}

package BookingTest.Test;

import BookingTest.Page.DatesFieldPage;
import BookingTest.Page.HomePage;
import BookingTest.Page.HotelHomePage;
import BookingTest.Page.NewYorkHotelPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestStays extends TestInit{
    HomePage homePage = new HomePage(driver);
    DatesFieldPage datesField = new DatesFieldPage(driver);
    NewYorkHotelPage newYorkHotel = new NewYorkHotelPage(driver);

    @Test
    public void checkChoiceNewYorkCity(){
        homePage.openBooking();
        homePage.changeLanguage();
        homePage.choiceCity();
        homePage.clickSerchBtn().click();
        datesField.changeDate();

        Assert.assertTrue(newYorkHotel.checkHotelInNewYorkOnly());
    }

    @Test
    public void checkConformityDate(){
        new HomePage(driver).openBooking();
        homePage.changeLanguage();
        homePage.choiceCity();
        homePage.clickSerchBtn().click();
        datesField.changeDate();
        datesField.choiceHotel().get(0).click();
        datesField.changeTab();

        Assert.assertTrue(new HotelHomePage(driver).checkFieldDateIn().getText().contains("Thursday, December 1, 2022"));
        Assert.assertTrue(new HotelHomePage(driver).checkFieldDateOut().getText().contains("Saturday, December 31, 2022"));
    }
}

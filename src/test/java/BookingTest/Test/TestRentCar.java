package BookingTest.Test;

import BookingTest.Page.HomePage;
import BookingTest.Page.RentCarPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRentCar extends TestInit{

    @Test
    public void checkSelectLocation(){
        new HomePage(driver).openBooking();
        new HomePage(driver).changeLanguage();
        new HomePage(driver).choiceCarRent().click();
        new RentCarPage(driver).enterLocation().sendKeys("Kiev");
        new RentCarPage(driver).choiceLocation().click();
        new RentCarPage(driver).clickSearchBtn().click();

        Assert.assertTrue(new RentCarPage(driver).checkTableVisible().isDisplayed());
    }
}

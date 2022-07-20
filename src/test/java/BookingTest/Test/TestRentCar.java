package BookingTest.Test;

import BookingTest.Page.HomePage;
import BookingTest.Page.RentCarPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRentCar extends TestInit{

    @Test
    public void checkSelectLocation(){
        HomePage homePage = new HomePage(driver);
        RentCarPage rentCarPage = new RentCarPage(driver);
        homePage.openBooking();
        homePage.changeLanguage();
        homePage.choiceCarRent().click();
        rentCarPage.enterLocation().sendKeys("Kiev");
        rentCarPage.choiceLocation().get(1).click();
        rentCarPage.clickSearchBtn().click();

        Assert.assertTrue(rentCarPage.checkTableVisible().isDisplayed());
    }
}

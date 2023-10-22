package passwords;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testRetrievePassword () {
        var forgetPasswordPage = homePage.clickForgotPassword();
        var emailSentPage = forgetPasswordPage.retrievePassword("tau@example.com");
        assertEquals(emailSentPage.getMessage(), "Internal Server Error", "Message is incorrect");


    }

}

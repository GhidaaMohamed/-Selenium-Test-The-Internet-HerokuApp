package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class FileUploadPage extends BaseTests {

    @Test
    public void testFileUpload () {
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile(
                "C:\\Users\\Ghidaa\\IdeaProjects\\TAU_Selenium_Course\\resources\\Budget Types Template.xlsx");
        assertEquals(uploadPage.getUploadedFiles(), "Budget Types Template.xlsx", "Uploaded files incorrect");
    }
}

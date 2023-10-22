package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
public class NestedFramesPage {
    private final WebDriver driver;
    private final String topFrame = "frame-top";
    private final String leftFrame = "frame-left";
    private final String bottomFrame = "frame-bottom";
    private final By body = By.tagName("body");
    public NestedFramesPage(WebDriver driver){
        this.driver = driver;
    }
    public String getLeftFrameText(){
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame(leftFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame(); //exit left to top
        driver.switchTo().parentFrame(); //exit top to main
        return text;
    }
    public String getBottomFrameText(){
        driver.switchTo().frame(bottomFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame(); //exit top to main
        return text;
    }
    private String getFrameText(){
        return driver.findElement(body).getText();
    }
}

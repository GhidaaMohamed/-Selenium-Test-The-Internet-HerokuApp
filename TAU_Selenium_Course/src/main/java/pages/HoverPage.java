package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoverPage {
    private final WebDriver driver;
    private final By figureBox = By.className("figure");
    private final By boxCapton = By.className("figcaption");
    public HoverPage (WebDriver driver) {
        this.driver = driver;
    }

    /**
     *
     * @param index starts at 1
     */
    public FigureCaption hoverOverFigures (int index) {
        WebElement figure = driver.findElements(figureBox).get(index - 1);
        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();
        return new FigureCaption(figure.findElement(boxCapton));
    }

    public class FigureCaption {
        private final WebElement caption;
        private final By header = By.tagName("h5");
        private final By link = By.tagName("a");
        public FigureCaption (WebElement caption) {
            this.caption = caption;
        }
        public boolean isCaptionDisplayed () {
            return caption.isDisplayed();
        }
        public String getTitle () {
            return caption.findElement(header).getText();
        }
        public String getLink () {
            return caption.findElement(link).getAttribute("href");
        }
        public String getLinkText () {
            return caption.findElement(link).getText();
        }
    }

}

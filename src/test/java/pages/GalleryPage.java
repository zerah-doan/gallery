package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class GalleryPage extends BasePage {
    @FindBy(xpath = "//input[@type='file']")
    private WebElement txtUpload;

    @FindBy(xpath = "//article[@class='thumbnails-list']/a")
    private List<WebElement> lstImages;

    @FindBy(xpath = "//button[contains(@onclick,'prev')]")
    private List<WebElement> btnPrev;

    @FindBy(xpath = "//button[contains(@onclick,'next')]")
    private List<WebElement> btnNext;

    @FindBy(xpath = "//button[contains(@onclick,'closeModal')]")
    private List<WebElement> btnCloseModal;

    @FindBy(xpath = "//button[contains(@onclick,'removeImage')]")
    private List<WebElement> btnRemove;

    public static GalleryPage Page() {
        return new GalleryPage();
    }

    public void uploadImage(String filePath) {
        txtUpload.sendKeys(filePath);
    }

    public int countCurrentImage() {
        try {
            return lstImages.size();
        } catch (Exception e) {
            return 0;
        }
    }

    public void openImage(int imageIndex) {
        try {
            lstImages.get(imageIndex).click();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Given index does NOT exist, click 1st image by default");
            lstImages.get(0).click();
        } catch (NullPointerException e) {
            System.out.println("There is no image to open");
        }
    }

    public boolean isPopupDisplayed() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            wd.switchTo().alert().accept();
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}

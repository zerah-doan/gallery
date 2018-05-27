package pages;

import org.openqa.selenium.By;
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
    private WebElement btnPrev;

    @FindBy(xpath = "//button[contains(@onclick,'next')]")
    private WebElement btnNext;

    @FindBy(xpath = "//button[contains(@onclick,'closeModal')]")
    private WebElement btnCloseModal;

    @FindBy(xpath = "//button[contains(@onclick,'removeImage')]")
    private WebElement btnRemove;

    @FindBy(xpath = "//section[contains(@class, 'viewImageModal')]")
    private WebElement mdlViewImg;


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

    public boolean isViewImageModalDisplayed() {
        return mdlViewImg.isDisplayed();
    }

    public int currentImageNumberDisplayed() {
        return Integer.parseInt(mdlViewImg.findElement(By.xpath("./div")).getAttribute("data-image"));
    }

    public int getNextImageNum(int currentImgNum) {
        int max = countCurrentImage();
        if (currentImgNum == max) {
            return 1;
        } else {
            return currentImgNum + 1;
        }
    }

    public int getPrevImageNum(int currentImgNum) {
        int max = countCurrentImage();
        if (currentImgNum == 1) {
            return max;
        } else {
            return currentImgNum - 1;
        }
    }

    public void navigateViewImage(int move) {
        if (move >= 0) {
            for (int i = 0; i < move; i++) {
                btnNext.click();
            }
        } else {
            for (int i = 0; i > move; i--) {
                btnPrev.click();
            }
        }
    }

    public void closeViewImageModal() {
        btnCloseModal.click();
    }

    public void removeImage(boolean isRemove) {
        btnRemove.click();
        wait.until(ExpectedConditions.alertIsPresent());
        if (isRemove) {
            wd.switchTo().alert().accept();
        } else {
            wd.switchTo().alert().dismiss();
        }
    }

    public void removeImage() {
        removeImage(true);
    }
}

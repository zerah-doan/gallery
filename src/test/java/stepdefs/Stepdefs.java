package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java8.En;
import org.testng.Assert;
import pages.GalleryPage;

public class Stepdefs implements En {
    private static final String TEST_DATA_FOLDER = System.getProperty("user.dir") + "\\src\\testclasses\\resources\\testdata\\";
    private static int numOfImageBef;
    private static int expectedNOImage;


    public Stepdefs() {
        When("^I upload ([^\"]*)$", (String file) -> {

            numOfImageBef = GalleryPage.Page().countCurrentImage();
            GalleryPage.Page().uploadImage(TEST_DATA_FOLDER + file);
        });
        Then("^Image is added to gallery$", () -> {
            Assert.assertTrue(GalleryPage.Page().countCurrentImage() > numOfImageBef);
        });
        And("^Image is NOT added to gallery$", () -> {
            Assert.assertTrue(GalleryPage.Page().countCurrentImage() == numOfImageBef);
        });
        Then("^Error popup is displayed$", () -> {
            Assert.assertTrue(GalleryPage.Page().isPopupDisplayed());
        });

        When("^I have multiple file to upload as below$", (DataTable table) -> {
            for (String file : table.asList(String.class)) {
                GalleryPage.Page().uploadImage(TEST_DATA_FOLDER + file);
            }
            expectedNOImage = table.asList(String.class).size();
        });
        Then("^All image is added$", () -> {
            Assert.assertTrue(GalleryPage.Page().countCurrentImage() == expectedNOImage);
        });
        When("^I open image number ([^\"]*)$", (Integer imgNum) -> {
            GalleryPage.Page().openImage(imgNum - 1);
        });
        Then("^View image modal is displayed$", () -> {
            Assert.assertTrue(GalleryPage.Page().isViewImageModalDisplayed());
        });
        And("^Image number ([^\"]*) is displayed$", (Integer imgNum) -> {
            Assert.assertTrue(GalleryPage.Page().currentImageNumberDisplayed() == imgNum);
        });
        And("^Click next button$", () -> {
            GalleryPage.Page().navigateViewImage(1);
        });
        And("^Click previous button$", () -> {
            GalleryPage.Page().navigateViewImage(-1);
        });
        Then("^Next image of image number ([^\"]*) will be displayed$", (Integer imgNum) -> {
            Assert.assertTrue(GalleryPage.Page().currentImageNumberDisplayed() == GalleryPage.Page().getNextImageNum(imgNum));
        });
        Then("^Previous image of image number ([^\"]*) will be displayed$", (Integer imgNum) -> {
            Assert.assertTrue(GalleryPage.Page().currentImageNumberDisplayed() == GalleryPage.Page().getPrevImageNum(imgNum));
        });
        And("^Click close button$", () -> {
            GalleryPage.Page().closeViewImageModal();
        });
        Then("^View image modal is closed$", () -> {
            Assert.assertTrue(!GalleryPage.Page().isViewImageModalDisplayed());
        });
        When("^I remove viewing image$", () -> {
            numOfImageBef = GalleryPage.Page().countCurrentImage();
            GalleryPage.Page().removeImage();
        });
        And("^Image is removed from gallery$", () -> {
            Assert.assertTrue(GalleryPage.Page().countCurrentImage() == numOfImageBef - 1);
        });
        When("^I remove viewing image but cancel at confirmation popup$", () -> {
            numOfImageBef = GalleryPage.Page().countCurrentImage();
            GalleryPage.Page().removeImage(false);
        });
        And("^Number of image is not changed$", () -> {
            Assert.assertTrue(GalleryPage.Page().countCurrentImage() == numOfImageBef);
        });

    }
}

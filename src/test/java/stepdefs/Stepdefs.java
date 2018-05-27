package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java8.En;
import org.testng.Assert;
import pages.GalleryPage;

public class Stepdefs implements En {
    private static final String TEST_DATA_FOLDER = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\";
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
    }
}

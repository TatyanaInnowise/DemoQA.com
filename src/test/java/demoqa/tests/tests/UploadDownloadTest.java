import demoqa.pages.UploadDownloadPage;
import demoqa.tests.base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import io.qameta.allure.*;

@Epic("DemoQA Upload & Download")
@Feature("Download file functionality")
public class UploadDownloadTest extends BaseTest {

    private UploadDownloadPage page;

    @BeforeEach
    public void openUploadDownloadPage() {
        driver.get("https://demoqa.com/upload-download");
        page = new UploadDownloadPage(driver);
    }

    @Test
    @Story("Download file and verify")
    @Severity(SeverityLevel.NORMAL)
    @Description("Clicks the Download button and verifies the file appears in the Downloads folder.")
    public void testDownloadFile() {

        page.downloadFile();

        String filePath = System.getProperty("user.home") + "/Downloads/sampleFile.jpeg";

        boolean fileExists = page.waitForFileDownload(filePath, 10);

        Assertions.assertTrue(fileExists, "Downloaded file not found at path: " + filePath);
    }


    @Test
    @Story("Upload file and verify")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Uploads a file and verifies the file name is shown after upload.")
    public void testUploadFile() {
        page.uploadFile();

        boolean uploadShown = page.waitForUploadConfirmation(5);

        Assertions.assertTrue(uploadShown, "Upload confirmation not displayed");

        String uploadedPath = page.getUploadedFileName();

        Assertions.assertTrue(uploadedPath.contains("sampleFile.jpeg"), "Uploaded file path doesn't contain expected file name: " + uploadedPath);
    }
}

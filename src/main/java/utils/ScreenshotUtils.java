package utils;

import factory.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;

public class ScreenshotUtils {

    public static String captureScreenshot(String testName) {
        try {
            File src = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            String destPath =
                    "test-output/screenshots/" + testName + ".png";

            File dest = new File(destPath);
            dest.getParentFile().mkdirs();

            Files.copy(src.toPath(), dest.toPath());

            return destPath;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

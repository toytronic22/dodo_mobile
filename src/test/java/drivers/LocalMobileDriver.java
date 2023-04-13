package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.LocalConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.ParametersAreNonnullByDefault;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

@ParametersAreNonnullByDefault
public class LocalMobileDriver implements WebDriverProvider {

    public WebDriver createDriver(Capabilities capabilities) {

        File app = downloadApk();

        LocalConfig config = ConfigFactory.create(LocalConfig.class, System.getProperties());

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(config.platformName())
                .setDeviceName(config.deviceName())
                .setPlatformVersion(config.platformVersion())
                .setApp(app.getAbsolutePath())
                .setAppPackage("org.wikipedia.alpha")
                .setAppActivity("org.wikipedia.main.MainActivity");

        try {
            return new AndroidDriver(new URL("http://localhost:4723/wd/hub"), options);
        } catch (
                MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private File downloadApk() {
        File apk = new File("src/test/resources/apps/app-alpha-universal-release.apk");
        if (!apk.exists()) {
            String url = "https://github.com/wikimedia/apps-android-wikipedia/" +
                    "releases/download/latest/app-alpha-universal-release.apk?raw=true";
            try (InputStream in = new URL(url).openStream()) {
                copyInputStreamToFile(in, apk);
            } catch (IOException e) {
                throw new AssertionError("Failed to download apk", e);
            }
        }
        return apk;
    }

}
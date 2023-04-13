package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AppBrowserstack;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    public static URL getBrowserstackUrl() {
        try {
            return new URL(AppBrowserstack.config.browserstackUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    @Override
    public WebDriver createDriver(Capabilities capabilities) {

        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", AppBrowserstack.config.browserstackLogin());
        mutableCapabilities.setCapability("browserstack.key", AppBrowserstack.config.browserstackPassword());

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", AppBrowserstack.config.appUrl());

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", AppBrowserstack.config.deviceName());
        mutableCapabilities.setCapability("os_version", AppBrowserstack.config.osVersion());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "QA guru final project");
        mutableCapabilities.setCapability("build", "browserstack-build-wiki");
        mutableCapabilities.setCapability("name", "wiki mobile tests");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }
}

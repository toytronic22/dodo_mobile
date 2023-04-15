package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackMobileDriver;
import drivers.LocalMobileDriver;
import helpers.Attach;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static helpers.Attach.getSessionId;
import static io.qameta.allure.Allure.step;

public class TestBase {

    public static String env = System.getProperty("env");

    @BeforeAll
    static void beforeAll() {

        switch (env) {
            case "emulation":
                Configuration.browser = LocalMobileDriver.class.getName();
                break;
            case "browserstack":
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                break;
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
        step("Choose country", () -> {
            $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewSwitcher/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[10]/android.widget.TextView")).click();
        });
        step("Choose delivery option", () -> {
            $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewSwitcher/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.TextView")).click();
        });
        step("Choose city", () -> {
            $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewSwitcher/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")).click();
        });
        step("Choose restaurant", () -> {
            $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewSwitcher/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")).click();
        });
    }

    @AfterEach
    public void afterEach() {
        String sessionId = getSessionId();
        Attach.pageSource();
        closeWebDriver();

        if (env.equals("browserstack")) {
            Attach.addVideo(sessionId);
        }
    }
}

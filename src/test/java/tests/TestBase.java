package tests;

import com.codeborne.selenide.Configuration;
import config.RunConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.RunHelper.runHelper;

public class TestBase {
    private final RunConfig config = ConfigFactory.create(RunConfig.class, System.getProperties());

    @BeforeAll
    public static void setUp() {
        Configuration.browser = runHelper().getDriverClass().getName();
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void tearDown() {
        String sessionId = sessionId().toString();

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        closeWebDriver();

        if (config.deviceHost().equals("browserstack")) {
            Attach.video(sessionId);
        }
    }
}

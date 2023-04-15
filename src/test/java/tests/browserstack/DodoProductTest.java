package tests.browserstack;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class DodoProductTest extends TestBase {
        @Tag("browserstack")
        @DisplayName("Checking text in due order")
        @Test
        @Owner("toytronic")
        void checkButtonLogIn() {
            step("Click on the NavBar Menu button", () -> {
                $(id("org.wikipedia.alpha:id/menu_overflow_button")).click();
            });
        }
    }

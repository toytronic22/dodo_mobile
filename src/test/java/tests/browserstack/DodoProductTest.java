package tests.browserstack;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.xpath;


@Tag("browserstack")
public class DodoProductTest extends TestBase {
    @DisplayName("Checking text in due order")
    @Test
    @Owner("toytronic")
    void checkButtonLogIn() {

        step("Choose country", () -> {
            $(AppiumBy.id("ru.dodopizza.app:id/00000000-0000-0021-ffff-ffff00000043"));
        });
        step("Choose delivery option", () -> {
            $(id("ru.dodopizza.app:id/00000000-0000-0019-ffff-ffff0000005b")).click();
        });
        step("Choose city", () -> {
            $(id("ru.dodopizza.app:id/00000000-0000-0019-ffff-ffff00000095")).click();
        });
    }
}

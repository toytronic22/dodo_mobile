package tests.browserstack;

import com.codeborne.selenide.Condition;
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
    void checkComboForOne() {

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
        step("Choose Combo", () -> {
            $(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"Комбо\"]/android.widget.TextView")).click();
        });
        step("Check combo for one", () -> {
            $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewSwitcher/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.TextView[1]")).shouldHave(Condition.text("Комбо от 599 ₽"));
        });
    }
}

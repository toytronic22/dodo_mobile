package tests.browserstack;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


@Tag("browserstack")
public class ProductTest extends TestBase {
    @DisplayName("Checking text combo for one")
    @Test
    @Owner("toytronic")
    void checkComboForOne() {
        step("Choose Combo", () -> {
            $(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"Комбо\"]/android.widget.TextView")).click();
        });
        step("Check combo for one", () -> {
            $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewSwitcher/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.TextView[1]")).shouldHave(Condition.text("Комбо от 599 ₽"));
        });
    }
}

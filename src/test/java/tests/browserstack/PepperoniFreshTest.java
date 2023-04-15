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
public class PepperoniFreshTest extends TestBase {
    @DisplayName("Checking Pepperoni fresh exists")
    @Test
    @Owner("toytronic")
    void checkDodoHat() {
        step("Choose Pepperoni fresh and check text", () -> {
            $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewSwitcher/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView[2]/androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView")).shouldHave(Condition.text("Пепперони фреш"));
        });
    }
}

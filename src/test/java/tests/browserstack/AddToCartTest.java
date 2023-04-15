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
public class AddToCartTest extends TestBase {
    @DisplayName("Checking product adds to cart correctly")
    @Test
    @Owner("toytronic")
    void checkComboForOne() {
        step("Choose Coctails", () -> {
            $(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"Коктейли\"]/android.widget.TextView")).click();
        });
        step("Choose Coffee", () -> {
            $(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"Кофе\"]/android.widget.TextView")).click();
        });
        step("Put Latte in cart", () -> {
            $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewSwitcher/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button")).click();
        });
        step("Go to cart", () -> {
            $(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Корзина, 1 новое уведомление\"]/android.widget.FrameLayout/android.widget.ImageView")).click();
        });
        step("Check coffee is in cart", () -> {
            $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewSwitcher/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.ViewSwitcher/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]")).shouldHave(Condition.text("Кофе Кокосовый латте"));
        });
    }
}

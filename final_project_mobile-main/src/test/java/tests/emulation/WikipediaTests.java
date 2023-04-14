package tests.emulation;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
@Tag("emulation")
public class WikipediaTests extends TestBase {
    @DisplayName("Checking onboarding screen")
    @Owner("toytronic")
    @Test
    public void checkOnboardingScreen() {

        step("getting started check", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldBe(text("The Free Encyclopedia …in over 300 languages"));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldBe(text("New ways to explore"));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldBe(text("Reading lists with sync"));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldBe(text("Send anonymous data"));
            $(id("org.wikipedia.alpha:id/acceptButton")).click();
            $(id("org.wikipedia.alpha:id/main_toolbar_wordmark")).shouldBe(visible);
        });
    }

    @DisplayName("Successful article opening")
    @Owner("toytronic")
    @Test
    void openArticleTest() {
        back();

        step("Go to search input and type search", () -> {
            $(id("org.wikipedia.alpha:id/search_container")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("telegram");
        });
        step("Go to first article on search list", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title")).get(1)
                    .shouldHave(text("telegram (software)"));
            $$(id("org.wikipedia.alpha:id/page_list_item_description")).get(1)
                    .shouldHave(text("Cross-platform encrypted"));
            $$(id("org.wikipedia.alpha:id/page_list_item_title")).get(1).click();
        });
        step("Verify content", () ->
                $(id("org.wikipedia.alpha:id/view_announcement_text"))
                        .shouldNotBe((visible)));
    }
}

package pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class StartedPage {

    private SelenideElement textView = $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")),
            forwardButton = $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            getStartedButton = $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")),
            searchContainer = $(AppiumBy.id("org.wikipedia.alpha:id/search_container"));

    public StartedPage forwardButtonClick() {
        forwardButton.click();
        return this;
    }

    public StartedPage firstStartedPageText() {
        textView.shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        return this;
    }

    public StartedPage secondStartedPageText() {
        textView.shouldHave(text("New ways to explore"));
        return this;
    }

    public StartedPage thirdStartedPageText() {
        textView.shouldHave(text("Reading lists with sync"));
        return this;
    }

    public StartedPage fourthStartedPageText() {
        textView.shouldHave(text("Send anonymous data"));
        return this;
    }

    public StartedPage checkStartedPage() {
        getStartedButton.click();
        searchContainer.shouldBe(visible);
        return this;
    }
}

package pages;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {
    public static final String SEARCH_VALUE = "Русский";

    public SearchPage clickSearch() {
        $(AppiumBy.accessibilityId("Search Wikipedia")).click();
        return this;
    }

    public SearchPage setSearchValue() {
        $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys(SEARCH_VALUE);
        return this;
    }

    public SearchPage checkResults() {
        $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
        return this;
    }
}

package pages;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddLanguagePage {

    public static final String LANGUAGE = "Русский";

    public AddLanguagePage clickMenuButton() {
        $(AppiumBy.id("org.wikipedia.alpha:id/menu_icon")).click();
        return this;
    }

    public AddLanguagePage clickSettingsButton() {
        $(AppiumBy.id("org.wikipedia.alpha:id/main_drawer_settings_container")).click();
        return this;
    }

    public AddLanguagePage clickAddLanguageButton() {
        $$(AppiumBy.className("android.widget.TextView")).findBy(text("Wikipedia languages")).click();
        $$(AppiumBy.id("org.wikipedia.alpha:id/wiki_language_title")).findBy(text("ADD LANGUAGE")).click();
        return this;
    }

    public AddLanguagePage setLanguage() {
        $$(AppiumBy.id("org.wikipedia.alpha:id/localized_language_name")).findBy(text(LANGUAGE)).click();
        return this;
    }

    public AddLanguagePage checkLanguage() {
        $$(AppiumBy.className("android.widget.TextView")).findBy(text(LANGUAGE)).shouldBe(visible);
        return this;
    }
}

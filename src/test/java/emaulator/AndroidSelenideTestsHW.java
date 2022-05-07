package emaulator;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static java.lang.Thread.sleep;

public class AndroidSelenideTestsHW extends TestBase {

    @Test
    @Tag("selenide")
    void searchTest() {
        step("Skip introduction", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
        });
        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("Appium");
        });
        step("Verify content found", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @Tag("emulator_hw")
    void hw1() throws InterruptedException {

        step("1st page of introduction: checking header", () -> {
                    $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                            .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
                });

        step("1st page of introduction: checking that english has already been available in app", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/option_label")).shouldHave(text("1. English"));
        });

        step("1st page of introduction: checking that page has button for adding new languages", () -> {
            $$(AppiumBy.id("android.widget.TextView")).findBy(text("ADD OR EDIT LANGUAGES")).click();
           // $(AppiumBy.accessibilityId("ADD OR EDIT LANGUAGES")).shouldHave(attribute("enabled", "true"));

        });
    }

}

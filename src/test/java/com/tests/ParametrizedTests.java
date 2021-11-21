package com.tests;

import com.codeborne.selenide.Condition;
import com.tests.domain.MenuItem;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ParametrizedTests extends TestBase {

    @ValueSource(strings = {
            "Беспроводные клавиатуры Logitech MX Keys",
            "Наушники Sony",
            "Apple watch"
    })
    @ParameterizedTest(name = "FindThing - {0}")
    void findProductOnPage(String goods) {
        open(UrlSber);
        $(".search-field-input").setValue(goods).pressEnter();
        $(".filter.category-nav").shouldHave(text("Продавец"));
    }

    @CsvSource(value = {
            "Смартфоны, 10000",
            "Телевизоры, 15000",
            "Кофемашины, 30000"
    })
    @ParameterizedTest(name = "{1}")
    void findProductOnPageCsv(String goods, String price) {
        open(UrlSber);
        $(".search-field-input").setValue(goods).pressEnter();
        $(".range-inputs input").setValue(price).pressEnter();;
        $(".filter.category-nav").shouldHave(text("Продавец"));
    }

    @EnumSource(value = MenuItem.class)
    @ParameterizedTest()
    void openTabsWithEnumSource(MenuItem menuItem) {
        open(UrlTinkoff);
        $$("[data-qa-type='uikit/navigation.menuItem']").find(Condition.text(menuItem.getDescription())).click();
    }

    static Stream<Arguments> testWithMethodSource() {
        return Stream.of(
                Arguments.of(
                        "Dwayne", "Johnson", "dwayne@gmail.com", "9787970811"
                ),
                Arguments.of(
                        "Kevin", "Rendellman", "rendell@gmail.com", "3366446722"
                ),
                Arguments.of(
                        "Hugh", "Jackman", "jackhu@gmail.com", "7778889085"
                )
        );
    }

    @MethodSource("testWithMethodSource")
    @ParameterizedTest(name = "TestForm: {0}")
    void studentFormTest(String name, String lastname, String email, String phoneNumber) {
        open(UrlDemoQa);
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastname);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(phoneNumber);
        $("#submit").scrollTo().click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }
}

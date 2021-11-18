package com.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    static final String UrlSbermMarket = "https://sbermegamarket.ru/";
    static final String UrlTinkoff = "https://www.tinkoff.ru/";
    static final String UrlDemoQa = "https://demoqa.com/automation-practice-form";

    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }
}

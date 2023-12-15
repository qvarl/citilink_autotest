package tests;

import org.junit.jupiter.api.BeforeAll;
import pages.CorporatePage;
import pages.SmartfonyPage;

import static com.codeborne.selenide.Configuration.*;

public class TestBase {
    CorporatePage corporatePage = new CorporatePage();
    SmartfonyPage smartfonyPage = new SmartfonyPage();

    @BeforeAll
    static void setEnvironment() {
        baseUrl = "https://www.citilink.ru";
        browserSize = "1920x1080";
        holdBrowserOpen = true;
        pageLoadTimeout = 50000;
    }
}

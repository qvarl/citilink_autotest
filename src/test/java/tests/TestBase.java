package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import pages.CorporatePage;
import pages.SmartfonyPage;

import static com.codeborne.selenide.Configuration.*;

public class TestBase
{
    CorporatePage corporatePage = new CorporatePage();
    SmartfonyPage smartfonyPage = new SmartfonyPage();
    TestData data = new TestData();

    @BeforeAll
    static void setEnvironment()
    {
        baseUrl = "https://www.citilink.ru";
        browserSize = "1920x1080";
        pageLoadTimeout = 50000;

        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}

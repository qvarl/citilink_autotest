package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.CorporatePage;
import pages.SmartfonyPage;

import java.util.Map;

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
        pageLoadTimeout = 50000;
        browser = System.getProperty("browser", "chrome");
        browserSize = System.getProperty("browserSize", "1920x1080");;
        remote = System.getProperty("remote", null);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        browserCapabilities = capabilities;

        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments () {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}

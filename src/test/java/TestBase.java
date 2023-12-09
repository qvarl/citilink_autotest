import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Configuration.*;

public class TestBase {

    @BeforeAll
    static void setEnvironment() {
        baseUrl = "https://www.citilink.ru";
        browserSize = "1920x1080";
        holdBrowserOpen = true;
        pageLoadTimeout = 60000;
    }
}

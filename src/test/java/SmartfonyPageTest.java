import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SmartfonyPageTest extends TestBase {

    @BeforeEach
    void setUp() {
        open("/catalog/smartfony/");
    }

    @Test
    void name() {
        int price = Integer.parseInt($$("div [data-meta-name='ProductHorizontalSnippet']").get(43).$(".app-catalog-j8h82j").getText().replace(" ", ""));
        executeJavaScript("document.querySelector('.css-qysqxe').remove()");
        $$("div [data-meta-name='ProductHorizontalSnippet']").get(1).$("[data-meta-name='Snippet__cart-button']").click();
    }
}

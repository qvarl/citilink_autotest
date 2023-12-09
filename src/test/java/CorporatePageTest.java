import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CorporatePageTest extends TestBase {

    @BeforeEach
    void setUp() {
        open("/about/corporate/");
    }

    @Test
    void selectCityUsingmMainCitiesListTest() {
        String city = "Краснодар";

        $(".MainHeader__city").click();
        $(".CitiesSearch__main-cities-list").$(byText(city)).click();
        $(".Popup__show-popup").shouldNotBe(exist);
        $(".MainHeader__city").shouldHave(textCaseSensitive(city));
    }

    @Test
    void transitionByMagazineHeaderTopLinkTest() {
        $(".MainMenu__link").$(byText("Журнал")).click();
        $(byTagAndText("span", "Магазин →")).shouldNotBe(exist);
    }

    @Test
    void transitionByCatalogMenuLinksTest() {
        String category = "Бытовая техника";
        String expectedUel = baseUrl + "/catalog/bytovaya-tehnika-dlya-doma-i-kuhni/?ref=mainmenu";

        $(".MainHeader__catalog").click();
        $(".CatalogMenu__category ").$(byText(category)).click();
        Assertions.assertEquals(expectedUel, WebDriverRunner.url());
    }

    @Test
    void displaySubscribeErrorTest() {
        executeJavaScript("$('.PersonalDataConfirm').remove()");
        $(".Subscribe__input-block .InputBox_error").shouldNotBe(exist);
        $(".Subscribe__button-block").click();
        $(".Subscribe__body .InputBox__error").shouldHave(textCaseSensitive("Укажите полный адрес электронной почты"));
    }

    @Test
    void transitionByMainLogoLinkTest() {
        $(".MainHeader__logo").click();
        Assertions.assertEquals(baseUrl + "/", WebDriverRunner.url());
    }

    @Test
    void workEconomicDepartmentPdfParseTest() throws Exception {
        File downloadedPdf = $("a[href='https://content.s1.citilink.ru/all_cl/buklet_b2b_2023.pdf']").download();
        PDF content = new PDF(downloadedPdf);
        assertThat(content.text).contains("Ситилинк  - один из крупнейших онлайн-магазинов");
    }
}

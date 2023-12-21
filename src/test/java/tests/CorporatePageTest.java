package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Configuration.*;

@DisplayName("Тест страницы Корпоратам")
@Owner("qwarl")
@Epic("Корпораты")
public class CorporatePageTest extends TestBase
{
    @BeforeEach
    void setUp()
    {
        corporatePage.openPage();
    }


    @DisplayName("Проверка выбора города проживания через спиок основных городов")
    @Feature("Выбор города проживания")
    @Severity(SeverityLevel.BLOCKER)
    @Tags({@Tag("blocker"), @Tag("corporate")})
    @Test
    void selectCityFromMainCitiesListTest()
    {
        String city = data.randomMainCity ;

        corporatePage.
                openCitiesSelector().
                setCityFromtMainCitiesList(city).
                checkCurrentCityName(city);
    }


    @DisplayName("Проверка перехода на страницу 'Журнал' по ссылке")
    @Feature("Переход по ссылке")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag("critical"), @Tag("corporate"), @Tag("magazine")})
    @Test
    void transitionByMagazineHeaderTopLinkTest()
    {
        corporatePage.openJournaPage();
    }


    @CsvSource({
            "'Телевизоры, аудио-видео, фото', televizory-audio-video-hi-fi",
            "Смартфоны и гаджеты, smartfony-i-gadzhety",
            "Ноутбуки и компьютеры, noutbuki-i-kompyutery"
    })

    @ParameterizedTest(name = "При переходе на страницу категори {0} URL должен содержать строку {1}")
    @DisplayName("Параметраризированный тест |")
    @Feature("Переход по ссылке")
    @Severity(SeverityLevel.CRITICAL)
    @Tags(
            {@Tag("critical"), @Tag("corporate"), @Tag("televizory-audio-video-hi-fi"), @Tag("smartfony-i-gadzhety"),
            @Tag("noutbuki-i-kompyutery") })
    void transitionByCatalogMenuLinksTest(
            String category,
            String expectedUelString
    ){
        String expectedUel = baseUrl + "/catalog/" + expectedUelString + "/?ref=mainmenu";

        corporatePage.
                openCatalog().
                selectCategory(category, expectedUel);
    }


    @DisplayName("Проверка появления ошибки при вводе пустой почты")
    @Feature("Регистрация почты")
    @Severity(SeverityLevel.NORMAL)
    @Tags({@Tag("normal"), @Tag("corporate")})
    @Test
    void displaySubscribeErrorTest() {
        corporatePage.
                subscribeButtonClick().
                emptyEmailWarningCheck();
    }


    @DisplayName("Проверка прехода на главную страницу при нажатии на логотип")
    @Feature("Переход по ссылке")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag("critical"), @Tag("corporate")})
    @Test
    void transitionByMainLogoLinkTest()
    {
        corporatePage.mainLogoClick();
    }


    @DisplayName("Проверка скачивания PDF файла")
    @Feature("Скачивание файла")
    @Severity(SeverityLevel.MINOR)
    @Tags({@Tag("minor"), @Tag("corporate")})
    @Test
    void workEconomicDepartmentPdfParseTest() throws Exception
    {
        corporatePage.
                pdfDownload().
                pdfTextCheck();
    }
}

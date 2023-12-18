package pages;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.io.File;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.textCaseSensitive;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CorporatePage
{

    private final String EMPTY_EMAIL_WARNING = "Укажите полный адрес электронной почты";
    private File downloadFile;
    private SelenideElement
            citiesSelectorOpener = $(".MainHeader__city");

    @Step("Открываем страницу")
    public CorporatePage openPage()
    {
        open("/about/corporate/");

        return this;
    }

    @Step("Раскрываем списки городов")
    public CorporatePage openCitiesSelector()
    {
        citiesSelectorOpener.click();

        return this;
    }

    @Step("Выбраем город {city} из списка основных городов")
    public CorporatePage setCityFromtMainCitiesList(String city)
    {
        $(".CitiesSearch__main-cities-list").$(byText(city)).click();
        $(".Popup__show-popup").shouldNotBe(exist);

        return this;
    }

    @Step("Проверяем, что текущим городом выбран {city}")
    public CorporatePage checkCurrentCityName(String city)
    {
        citiesSelectorOpener.shouldHave(textCaseSensitive(city));

        return this;
    }

    @Step("Переходим по ссылке 'Журнал'")
    public CorporatePage openJournaPage()
    {
        $(".MainMenu__link").$(byText("Журнал")).click();
        $(byTagAndText("span", "Магазин →")).shouldNotBe(exist);

        return this;
    }

    @Step("Открываем каталог")
    public CorporatePage openCatalog()
    {
        $(".MainHeader__catalog").click();

        return this;
    }

    @Step("Выбираем категорию")
    public CorporatePage selectCategory(String category, String categoryPageUrl)
    {
        $(".CatalogMenu__category").$(byText(category)).click();
        Assertions.assertEquals(categoryPageUrl, WebDriverRunner.url());

        return this;
    }

    @Step("Кликаем по кнопке 'Подписаться'")
    public CorporatePage subscribeButtonClick()
    {
        executeJavaScript("$('.PersonalDataConfirm').remove()");
        $(".Subscribe__input-block .InputBox_error").shouldNotBe(exist);
        $(".Subscribe__button-block").click();

        return this;
    }

    @Step("Проверяем предупреждение о вводе пустой почты")
    public CorporatePage emptyEmailWarningCheck()
    {
        $(".Subscribe__body .InputBox__error").shouldHave(textCaseSensitive(EMPTY_EMAIL_WARNING));

        return this;
    }

    @Step("Нажимаем на главный логотип")
    public CorporatePage mainLogoClick()
    {
        $(".MainHeader__logo").click();
        Assertions.assertEquals(baseUrl + "/", WebDriverRunner.url());

        return this;
    }

    @Step("Скачиваем файл PDF")
    public CorporatePage pdfDownload() throws Exception
    {
        downloadFile = $("a[href='https://content.s1.citilink.ru/all_cl/buklet_b2b_2023.pdf']").download();

        return this;
    }

    @Step("Проверяем текст скачанного PDF файла")
    public CorporatePage pdfTextCheck() throws Exception
    {
        PDF content = new PDF(downloadFile);
        assertThat(content.text).contains("Ситилинк  - один из крупнейших онлайн-магазинов");

        return this;
    }
}

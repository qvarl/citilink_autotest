package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.CorporatePage;

import static com.codeborne.selenide.Configuration.*;

public class CorporatePageTest extends TestBase {

    @BeforeEach
    void setUp() {
        corporatePage.openPage();
    }

    @Test
    void selectCityFromMainCitiesListTest() {
        String city = "Краснодар";

        corporatePage.
                openCitiesSelector().
                setCityFromtMainCitiesList(city).
                checkCurrentCityName(city);
    }

    @Test
    void transitionByMagazineHeaderTopLinkTest() {
        corporatePage.openJournaPage();
    }

    @Test
    void transitionByCatalogMenuLinksTest() {
        String category = "Бытовая техника";
        String expectedUel = baseUrl + "/catalog/bytovaya-tehnika-dlya-doma-i-kuhni/?ref=mainmenu";

        corporatePage.
                openCatalog().
                selectCategory(category, expectedUel);
    }

    @Test
    void displaySubscribeErrorTest() {
        corporatePage.
                subscribeButtonClick().
                emptyEmailWarningCheck();
    }

    @Test
    void transitionByMainLogoLinkTest() {
        corporatePage.mainLogoClick();
    }

    @Test
    void workEconomicDepartmentPdfParseTest() throws Exception {
        corporatePage.
                pdfDownload().
                pdfTextCheck();
    }
}

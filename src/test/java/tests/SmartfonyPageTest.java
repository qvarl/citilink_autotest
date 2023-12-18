package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

@DisplayName("Тест страницы Смартфоны")
@Owner("qwarl")
@Epic("Смартфоны")
@Feature("Добавление в корзину")
public class SmartfonyPageTest extends TestBase {

    @BeforeEach
    void setUp() {
        smartfonyPage.openPage();
    }


    @DisplayName("Проверка добавления смартфона в корзину")
    @Severity(SeverityLevel.BLOCKER)
    @Tags({@Tag("blocker"), @Tag("smartfony")})
    @Test
     void addSmartfonToCart() {
        int smartfonIndex =data.randomProductHorizontalSnippetIndex ;
        int serviceIndex = data.randomServiceIndex;
        String serviseYearCount = data.serviseYearCount;

        smartfonyPage.
                getSmartfonyPrice(smartfonIndex).
                addSmartfonToCart(smartfonIndex).
                addService(serviceIndex, serviseYearCount).
                getServicePrice(serviceIndex).
                openCartFromPopupServicePrice().
                getFinalPrice().
                checkFinalPrice();
    }
}

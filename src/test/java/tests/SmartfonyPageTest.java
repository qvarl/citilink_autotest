package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SmartfonyPageTest extends TestBase {

    @BeforeEach
    void setUp() {smartfonyPage.openPage();}

    @Test
    void name() {
        int smartfonListIndex = 43;
        int serviceListIndex = 2;
                String serviseYear = "1 год";

   smartfonyPage.
           getSmartfonyPrice(smartfonListIndex).
           addSmartfonToCart(smartfonListIndex).
           addService(serviceListIndex, serviseYear).
           getServicePrice(serviceListIndex).
           openCartFromPopupServicePrice().getFinalPrice().checkFinalPrice();





    }
}

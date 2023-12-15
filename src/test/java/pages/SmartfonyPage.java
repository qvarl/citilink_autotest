package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SmartfonyPage {
    private int smartphonePrice;
    private int servicePrice;
   private int finalPrice;

    @Step("Открываем страницу")
    public SmartfonyPage openPage() {
        open("/catalog/smartfony/");

        return this;
    }

    @Step("Запомнить цену товара в позиции {index}")
    public SmartfonyPage getSmartfonyPrice(int index) {
         smartphonePrice = Integer.parseInt($$("div [data-meta-name='ProductHorizontalSnippet']").get(index).
                $(".app-catalog-j8h82j").getText().replace(" ", ""));

        return this;
    }

    @Step("Положить в корзину товар в позиции {index}")
    public SmartfonyPage addSmartfonToCart(int index) {
        executeJavaScript("document.querySelector('.css-qysqxe').remove()");
        $$("div [data-meta-name='ProductHorizontalSnippet']").get(index).
                $("[data-meta-name='Snippet__cart-button']").click();

        return this;
    }

    @Step("Выбрать услугу в позиции {index}")
    public SmartfonyPage addService(int index, String year) {
        $$("div [data-meta-name='UpsaleBasketAdditionalServicesItem__info']").get(index).
                $(withText(year)).click();

        return this;
    }

    @Step("Запомнить цену товара в позиции {index}")
    public SmartfonyPage getServicePrice(int index) {
         servicePrice = Integer.parseInt($$("div [data-meta-name='UpsaleBasketAdditionalServicesItem__info']").get(index).
                $(".e1j9birj0.css-xbfpj5").getText().replace(" ", ""));

        return this;
    }

    @Step("Перейти в корзину с окна добавления товара")
    public SmartfonyPage openCartFromPopupServicePrice() {
        $(".css-ass1ds .css-1k0cnlg [data-meta-disabled='false']").click();

        return this;
    }

    @Step("Запоминаем конечную цену товара в позиции {index}")
    public SmartfonyPage getFinalPrice() {
        finalPrice = Integer.parseInt($(".e1j9birj0.css-zmmgir").getText().replace(" ", ""));

        return this;
    }

    @Step("Проверить что конечная цена товара({}) = цене самого товара({}) + цене услуги({})")
    public SmartfonyPage checkFinalPrice() {
        Assertions.assertEquals(smartphonePrice + servicePrice, finalPrice);

        return this;
    }
}

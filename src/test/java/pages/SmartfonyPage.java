package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SmartfonyPage
{
    private int
            smartphonePrice,
            servicePrice,
            finalPrice;

    private ElementsCollection
            productHorizontalSnippetList = $$("div [data-meta-name='ProductHorizontalSnippet']"),
            servicesList = $$("div [data-meta-name='UpsaleBasketAdditionalServicesItem__info']");

    @Step("Открываем страницу")
    public SmartfonyPage openPage()
    {
        open("/catalog/smartfony/");

        return this;
    }

    @Step("Запоминаем цену товара в позиции {index}")
    public SmartfonyPage getSmartfonyPrice(int index)
    {
        smartphonePrice = Integer.parseInt(productHorizontalSnippetList.get(index).
                $(".app-catalog-j8h82j").getText().replace(" ", ""));

        return this;
    }

    @Step("Кладем в корзину товар в позиции {index}")
    public SmartfonyPage addSmartfonToCart(int index)
    {
        executeJavaScript("document.querySelector('.css-qysqxe').remove()");
        productHorizontalSnippetList.get(index).
                $("[data-meta-name='Snippet__cart-button']").click();

        return this;
    }

    @Step("Выбираем услугу в позиции {index +1}")
    public SmartfonyPage addService(int index, String yearsCount)
    {
       servicesList.get(index).
                $(byText(yearsCount)).click();
        $(".css-105zng3.e1no5vnt0").shouldHave(Condition.exist);
        return this;
    }

    @Step("Запоминаем цену выбранной услуги")
    public SmartfonyPage getServicePrice(int index)
    {
        servicePrice = Integer.parseInt( servicesList.get(index).
                $(".e1j9birj0.css-xbfpj5").getText().replace(" ", ""));

        return this;
    }

    @Step("Переходим в корзину с окна добавления товара")
    public SmartfonyPage openCartFromPopupServicePrice()
    {
        $(".css-ass1ds .css-1k0cnlg [data-meta-disabled='false']").click();

        return this;
    }

    @Step("Запоминаем конечную цену товара в корзине")
    public SmartfonyPage getFinalPrice()
    {
        finalPrice = Integer.parseInt($(".e1j9birj0.css-zmmgir").getText().replace(" ", ""));

        return this;
    }

    @Step("Проверяем что конечная цена товара = цене самого товара + цене услуги")
    public SmartfonyPage checkFinalPrice()
    {
        Assertions.assertEquals(smartphonePrice + servicePrice, finalPrice);

        return this;
    }
}

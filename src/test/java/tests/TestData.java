package tests;

import com.github.javafaker.Faker;

public class TestData
{
    Faker faker = new Faker();

    public int
            randomProductHorizontalSnippetIndex = faker.random().nextInt(0, 47),
            randomServiceIndex = faker.random().nextInt(0, 3);
    public String
            randomMainCity = faker.options().option("Москва", "Санкт-Петербург", "Воронеж", "Волгоград", "Екатеринбург",
            "Казань", "Краснодар", "Красноярск", "Новосибирск", "Нижний Новгород", "Омск", "Пермь", "Ростов-на-Дону",
            "Самара", "Челябинск", "Уфа"),
            serviseYearCount = getServiseYearCount(randomServiceIndex);

    private String getServiseYearCount(int randomServiceIndex)
    {
        if (randomServiceIndex == 0)
        {
            return faker.options().option("1 год", "2 года");
        }
        else
        {
            return faker.options().option("1 год", "2 года", "3 года");
        }
    }
}

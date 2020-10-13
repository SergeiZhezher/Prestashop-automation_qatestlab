package com.test.prestashop;

import com.test.prestashop.service.MainService;
import com.test.prestashop.service.SearchService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    private static WebDriver driver;
    private static MainService mainService;
    private static SearchService searchService;


    public static void main(String[] args) {
        setUp();

        mainService.openMainPage(); // Открыть главную страницу сайта
        mainService.currencyComplianceCheck(); // Выполнить проверку, что цена продуктов в секции "Популярные товары" указана в соответствии с установленной валютой в шапке сайта
        mainService.currencyChange(); // Установить показ цены в USD используя выпадающий список в шапке сайта.
        mainService.dressSearch(); // Выполнить поиск в каталоге по слову “dress”
        searchService.totalProductsComplianceCheck(); //Выполнить проверку, что страница "Результаты поиска" содержит надпись "Товаров: x", где x - количество действительно найденных товаров.
        searchService.currencyComplianceCheck(); // Проверить, что цена всех показанных результатов отображается в долларах.
        searchService.changeSort(); // Установить сортировку "от высокой к низкой."
        searchService.checkingSortedProducts(); // Проверить, что товары отсортированы по цене от высокой к низкой.
        searchService.checkDiscount(); // Для любого товара со скидкой необходимо проверить, что цена до и после скидки совпадает с указанным размером скидки.

    }

    private static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC-0731\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();

        mainService = new MainService(driver);
        searchService = new SearchService(driver);
    }

}
package com.test.prestashop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchPage {

    private WebDriver driver;

    private By totalProducts = By.xpath("//*[@id=\"js-product-list-top\"]/div[1]/p");
    private By products = By.className("thumbnail-container");
    private By prices = By.className("price");
    private By sortDropDownMenu = By.xpath("//*[@id=\"js-product-list-top\"]/div[2]/div/div");
    private By sortHighToLowButton = By.xpath("//*[@id=\"js-product-list-top\"]/div[2]/div/div/div/a[5]");

    private By discountPercentage = By.xpath("//*[@class='regular-price']/following-sibling::span[@class='discount-percentage']");
    private By priceBeforeDiscount = By.xpath("//*[@class='regular-price']/following-sibling::span[@class='price']");
    private By regularPrice = By.className("regular-price");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTotalProducts() {
        System.out.println("Получения количества товаров");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        return driver.findElement(totalProducts).getText();
    }

    public List<WebElement> getProducts() {
        System.out.println("Получения всех товаров");
        return driver.findElements(products);
    }

    public List<WebElement> getPrices() {
        System.out.println("Проверить отображается ли цена всех товаров в долларах");
        return driver.findElements(prices);
    }

    public void clickSortDropDownMenu() {
        System.out.println("Клик по меню выбора вида сортировки");
        driver.findElement(sortDropDownMenu).click();
    }

    public void clickSortHighToLowButton() {
        System.out.println("Клик по пункте сортировки - от высокой к низкой");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(sortHighToLowButton).click();
    }

    /*
        Метод ниже получает список цен для определения правильной работы фильтра,
        но они не приходят в том порядке в котором находятся в html.

        Также если использовать xpath: //*[@id="js-product-list"]/div[1]/article[4]/div/div[1]/div/span
        который который указывает на элемент со значениям 1,00 $ приходит значения 1,14 $.
        В чём конкретно проблема такого поведения я к сожелению не смог выяснить

        В случае использования библиотеки Jsoup всё работает как надо.
    */
    public List<WebElement> getProductPrices() {
        System.out.println("Получения всех цен");
        return driver.findElements(prices);
    }

    public List<WebElement> getDiscountList() {
        System.out.println("Получения всех скидок");
        return driver.findElements(discountPercentage);
    }

    public List<WebElement> getPriceBeforeDiscount() {
        System.out.println("Получения всех цен до скидки");
        return driver.findElements(priceBeforeDiscount);
    }

    public List<WebElement> getRegularPrice() {
        System.out.println("Получения всех цен после скидки");
        return driver.findElements(regularPrice);
    }

}

package com.test.prestashop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MainPage {

    private WebDriver driver;

    private By selectedCurrency = By.xpath("//*[@id=\"_desktop_currency_selector\"]/div/span[2]");
    private By productCurrency = By.xpath("//*[@id=\"content\"]/section/div/article[1]/div/div[1]/div/span");
    private By dropDownMenu = By.xpath("//*[@id=\"_desktop_currency_selector\"]/div");
    private By usdButton = By.xpath("//*[@id=\"_desktop_currency_selector\"]/div/ul/li[3]");
    private By searchButton = By.xpath("//*[@id=\"search_widget\"]/form/button");
    private By searchInput = By.className("ui-autocomplete-input");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSelectedCurrency() {
        System.out.println("Получения установленной валюты");
        return driver.findElement(selectedCurrency).getText();
    }

    public String getProductCurrency() {
        System.out.println("Получения валюты из популярных товаров");
        return driver.findElement(productCurrency).getText();
    }

    public void clickDropDownMenu() {
        System.out.println("Клик по меню выбора валюты");
        driver.findElement(dropDownMenu).click();
    }

    public void clickUsdButton() {
        System.out.println("Клик по USD валюте");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(usdButton).click();
    }

    public void fillSearchInput() {
        System.out.println("Заполнения поисковой строки");
        driver.findElement(searchInput).sendKeys("dress");
    }

    public void clickSearchButton() {
        System.out.println("Клик по поисковой кнопке");
        driver.findElement(searchButton).click();
    }

}

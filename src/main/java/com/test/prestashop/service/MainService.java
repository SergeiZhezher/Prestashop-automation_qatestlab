package com.test.prestashop.service;

import com.test.prestashop.pages.MainPage;
import org.openqa.selenium.WebDriver;

public class MainService {

    private WebDriver driver;
    private MainPage mainPage;

    public MainService(WebDriver driver) {
        this.driver = driver;
        initialization();
    }

    public void openMainPage() {
        driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");
        System.out.println("Открытия страницы " + driver.getTitle());
    }

    public boolean currencyComplianceCheck() {
        String sc = mainPage.getSelectedCurrency();
        String pc = mainPage.getProductCurrency();
        System.out.println("Проверка соответствия валюты в популярных товарах с установленой валютой ");

        if (sc.charAt(sc.length() -1) != pc.charAt(pc.length() -1)) {
            return false;
        }
        return true;
    }

    public void currencyChange() {
        mainPage.clickDropDownMenu();
        mainPage.clickUsdButton();
    }

    public void dressSearch() {
        mainPage.fillSearchInput();
        mainPage.clickSearchButton();
    }

    private void initialization() {
        mainPage = new MainPage(driver);
    }

}

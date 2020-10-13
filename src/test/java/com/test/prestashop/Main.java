//package com.test.prestashop;
//
//import com.test.prestashop.pages.MainPage;
//import com.test.prestashop.pages.SearchPage;
//import org.junit.Assert;
//import org.junit.BeforeClass;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class Main {
//

//    private static WebDriver driver;
//    private static MainPage mainPage;
//    private static SearchPage searchPage;
//
//    @BeforeClass
//    public static void setUp() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC-0731\\Downloads\\chromedriver.exe");
//        driver = new ChromeDriver();
//
//        mainPage = new MainPage(driver);
//        searchPage = new SearchPage(driver);
//        openMainPage();
//    }
//
//    @Test
//    public void currencyComplianceCheck() {
//
//        String sc = mainPage.getSelectedCurrency();
//        String pc = mainPage.getProductCurrency();
//        System.out.println("Проверка соответствия валюты в популярных товарах с установленой валютой ");
//
//        Assert.assertEquals(sc.charAt(sc.length() -1), pc.charAt(pc.length() -1));
//    }

//    @Test
//    public void currencyChange() {
//        mainPage.clickDropDownMenu();
//        mainPage.clickUsdButton();
//    }

//    @Test
//    public void dressSearch() {
//        mainPage.fillSearchInput();
//        mainPage.clickSearchButton();
//    }

//    @Test
//    public void quantityProductsComplianceCheck() {
//        Assert.assertEquals(searchPage.getQuantityProducts(), searchPage.countQuantityProducts());
//        System.out.println("Проверка правильно ли указанно количество товаров");
//    }

//    @Test
//    public void currencyComplianceCheck2() {
//        searchPage.cheakCurrency();
//    }

//    private static void openMainPage() {
//        System.out.println("Открытия страницы " + driver.getTitle());
//        driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");
//    }
//
//}
package com.test.prestashop.service;

import com.test.prestashop.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchService {

    private WebDriver driver;
    private SearchPage searchPage;

    public SearchService(WebDriver driver) {
        this.driver = driver;
        initialization();
    }

    public void totalProductsComplianceCheck() {

        int tp = Integer.parseInt(searchPage.getTotalProducts().replaceAll("\\D", ""));
        List<WebElement> el = searchPage.getProducts();
        System.out.println("Проверка правильно ли указано количество товаров");

        if(tp != el.size()) System.out.println("Количество товаров указано неверно!");
    }

    public void currencyComplianceCheck() {
        List<WebElement> el = searchPage.getPrices();
        el.forEach(e -> {
            if (!e.getText().endsWith("$")) {System.out.println("найден товар цена которого не отображается в долларах");}
        });
    }

    public void changeSort() {
        searchPage.clickSortDropDownMenu();
        searchPage.clickSortHighToLowButton();
    }

    public void checkingSortedProducts() {
        List<WebElement> webElements = searchPage.getProductPrices();

        double firstValue = Math.pow(2,32);
        double secondValue = 0;

        for (WebElement we: webElements) {
            secondValue = Double.parseDouble(we.getText().replace("$","").replace(",","."));
            if (firstValue < secondValue) {
                System.out.println("Цены отсортированы неверно !");
                break;
            }
            firstValue = secondValue;
        }
    }

    public void checkDiscount() {

        List<WebElement> priceList = searchPage.getPriceBeforeDiscount();
        List<WebElement> discountList = searchPage.getDiscountList();
        List<WebElement> regularPriceList = searchPage.getRegularPrice();

        for (int i = 0; i < discountList.size() ; i++) {

            float price = getNumberFromString(priceList.get(i).getText());
            float discount = getNumberFromString(discountList.get(i).getText());
            float regularPrice = getNumberFromString(regularPriceList.get(i).getText());

            if (discount != Math.round((100 - (price * 100) / regularPrice))) {
                System.out.println("Найдена неправильно рассчитана скидка ");
            }
        }
    }

    private float getNumberFromString(String str) {
        String onlyNumber = str.replaceAll(",",".").replaceAll("[$%-]", "");
        return Float.parseFloat(onlyNumber);
    }

    private void initialization() {
        searchPage = new SearchPage(driver);
    }

}

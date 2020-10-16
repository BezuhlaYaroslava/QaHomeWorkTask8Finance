package TaskTestFinance;
import org.junit.Assert;
import help.*;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.*;

import org.junit.jupiter.api.Test;


public class TaskTestFinance {

    String actualResult;
    String expectedResult;
    private Open open;
    private HomePage homePage;
    private WebDriver driver;

    @BeforeEach
    void setUpBe() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://finance.i.ua/converter/");
        homePage = new HomePage(driver);
    }

    @Test
    public void canOpenPage(){

        actualResult = homePage.getCurrencyRates();
        expectedResult = "Курсы валют";

        Assert.assertEquals("Сломался тест главной страницы", expectedResult, actualResult);
    }

    @Test
    public void canClickConvert(){

        homePage.canConvert();
        homePage.canSelectCurrency("UAH");

        actualResult = homePage.getSelectCurrency();
        expectedResult = "USD";

       Assert.assertEquals("Сломался тест селектора", expectedResult, actualResult);
    }

    @Test
    public void averageRateAndAlpha(){

        homePage.canSelectAlpha("Альфа-Банк");

        actualResult = homePage.getSaleAverageRate();
        expectedResult = homePage.getSaleAverageRate();

        Assert.assertEquals("Сломался тест блока Продажа", expectedResult, actualResult);
    }
}


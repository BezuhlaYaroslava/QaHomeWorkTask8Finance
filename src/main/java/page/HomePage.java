
package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){ this.driver = driver; }

    public String getCurrencyRates() {
        WebElement element = driver.findElement(By.xpath("//div[@class='section_nav']//h2[@class='_title']"));
        element.getText();
        return element.getText();
    }

    public HomePage canConvert() {
        WebElement element = driver.findElement(By.xpath("//input[@id='currency_amount']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
        element.sendKeys("1000");
        return new HomePage(driver);
    }

    public void canSelectCurrency(String currency) {
        WebElement selectCurrency = driver.findElement(By.xpath("//select[@name='converter_currency']"));
        Select value = new Select(selectCurrency);
        value.selectByValue(currency);
    }

    public String getSelectCurrency() {
        WebElement getSelect = driver.findElement(By.xpath("//p[@style='display: block;']"));
        getSelect.getText();
        return getSelect.getText();
    }

    public String getSaleAverageRate() {
        WebElement getSelect = driver.findElement(By.xpath("(//table[@class='table table-data -important']//span)[2]"));
        getSelect.getText();
        return getSelect.getText();
    }

    public String canSelectAlpha(String bank) {
        WebElement getAlpha = driver.findElement(By.xpath("//select[@name='converter_bank']"));
        getAlpha.getText();
        return getAlpha.getText();
    }

}

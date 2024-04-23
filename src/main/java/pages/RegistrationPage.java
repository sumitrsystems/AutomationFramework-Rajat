package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By countryDropdownLocator = By.name("country");
    private By fruitsDropdownLocator = By.id("fruits");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // wait for up to 10 seconds
    }

    public void selectCountry(String countryName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryDropdownLocator));
        Select drpCountry = new Select(driver.findElement(countryDropdownLocator));
        drpCountry.selectByVisibleText(countryName);
    }

    public void selectFruits(String fruitName, int index) {
        driver.get("https://jsbin.com/osebed/2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(fruitsDropdownLocator));
        Select fruits = new Select(driver.findElement(fruitsDropdownLocator));
        fruits.selectByVisibleText(fruitName);
        fruits.selectByIndex(index);
    }

    public String getSelectedCountry() {
        Select drpCountry = new Select(driver.findElement(countryDropdownLocator));
        return drpCountry.getFirstSelectedOption().getText();
    }

    public boolean isFruitSelected(String fruitName) {
        Select fruits = new Select(driver.findElement(fruitsDropdownLocator));
        return fruits.getAllSelectedOptions().stream()
                .anyMatch(option -> option.getText().equals(fruitName));
    }
}
package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookTestingApp {
    public static final String XPATH_ACCEPT_COOKIES = "//button[@data-testid='cookie-policy-manage-dialog-accept-button']";
    public static final String XPATH_CREATE_NEW_ACCOUNT = "//a[@data-testid='open-registration-form-button']";
    public static final String XPATH_SELECT_DAY = "//select[@name='birthday_day']";
    public static final String XPATH_SELECT_MONTH = "//select[@name='birthday_month']";
    public static final String XPATH_SELECT_YEAR = "//select[@name='birthday_year']";
    public static final String XPATH_WAIT = "//div[contains(@class, \"_8ien\")]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath(XPATH_ACCEPT_COOKIES)).click();

        driver.findElement(By.xpath(XPATH_CREATE_NEW_ACCOUNT)).click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_WAIT)));

        WebElement selectCombo1 = driver.findElement(By.xpath(XPATH_SELECT_DAY));
        Select selectDay = new Select(selectCombo1);
        selectDay.selectByValue("10");

        WebElement selectCombo2 = driver.findElement(By.xpath(XPATH_SELECT_MONTH));
        Select selectMonth = new Select(selectCombo2);
        selectMonth.selectByIndex(11);

        WebElement selectCombo3 = driver.findElement(By.xpath(XPATH_SELECT_YEAR));
        Select selectYear = new Select(selectCombo3);
        selectYear.selectByValue("2000");
    }
}

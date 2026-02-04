package org.ext;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class SeleniumXPathTest extends BaseTest {
    @Override
    public String getLocator() { return "SELENIUM_LOCATOR"; }

    @Test
    public void testSeleniumXPath() throws Exception {
        driver.get(baseUrl);

        String titleXpath = ".media-title";

        // Element 1
        Thread.sleep(200);
        String elementText = driver.findElement(
            By.cssSelector(".ng-star-inserted:nth-child(1) .nav-link > .ellipsis-one-line")
        ).getText();
        driver.findElement(
            By.cssSelector(".ng-star-inserted:nth-child(1) > as-nav-link > .nav-link")
        ).click();
        String title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 2
        Thread.sleep(200);
        elementText = driver.findElement(
            By.cssSelector(".ng-star-inserted:nth-child(2) .nav-link > .ellipsis-one-line")
        ).getText();
        driver.findElement(
            By.cssSelector(".ng-star-inserted:nth-child(2) > as-nav-link > .nav-link")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 3
        Thread.sleep(200);
        elementText = driver.findElement(
            By.cssSelector(".ng-star-inserted:nth-child(3) .nav-link > .ellipsis-one-line")
        ).getText();
        driver.findElement(
            By.cssSelector(".ng-star-inserted:nth-child(3) > as-nav-link > .nav-link")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 4
        Thread.sleep(200);
        elementText = driver.findElement(
            By.cssSelector(".ng-star-inserted:nth-child(4) .nav-link > .ellipsis-one-line")
        ).getText();
        driver.findElement(
            By.cssSelector(".ng-star-inserted:nth-child(4) > as-nav-link > .nav-link")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 5
        Thread.sleep(200);
        elementText = driver.findElement(
            By.cssSelector(".ng-star-inserted:nth-child(5) .nav-link > .ellipsis-one-line")
        ).getText();
        driver.findElement(
            By.cssSelector(".ng-star-inserted:nth-child(5) > as-nav-link > .nav-link")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 6
        Thread.sleep(200);
        elementText = driver.findElement(
            By.cssSelector(".ng-star-inserted:nth-child(6) .nav-link > .ellipsis-one-line")
        ).getText();
        driver.findElement(
            By.cssSelector(".ng-star-inserted:nth-child(6) > as-nav-link > .nav-link")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector(titleXpath)
        )).getText();
        assertEquals(title, elementText);
    }

}

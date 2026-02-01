package org.ext;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class SeleniumXPathTest extends BaseTest {
    @Override
    public String getLocator() { return "SELENIUM_LOCATOR"; }

    @Test
    public void testSeleniumXPath() throws Exception {
        driver.get(baseUrl);

        // Search link in sidebar
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[contains(text(),'Search')]")
        )).click();

        // Search input
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector(".ng-touched")
        ));
        searchInput.clear();
        searchInput.sendKeys("Michael Jackson");

        // X icon
        driver.findElement(
            By.cssSelector(".svg-icon-times > svg")
        ).click();
        assertEquals("", searchInput.getDomAttribute("value"));
    }

}

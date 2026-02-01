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

public class KatalonXPathTest extends BaseTest {
    @Override
    public String getLocator() { return "KATALON_LOCATOR"; }

    @Test
    public void testKatalonXPath() throws Exception {
        driver.get(baseUrl);

        // Search link in sidebar
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Home'])[1]/following::a[1]")
        )).click();

        // Search input
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input")
        ));
        searchInput.clear();
        searchInput.sendKeys("Michael Jackson");

        // X icon
        driver.findElement(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Simon'])[1]/following::svg-icon[3]")
        ).click();
        assertEquals("", searchInput.getDomAttribute("value"));
    }

}

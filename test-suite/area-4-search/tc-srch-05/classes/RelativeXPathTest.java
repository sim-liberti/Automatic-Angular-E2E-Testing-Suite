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

public class RelativeXPathTest extends BaseTest {
    @Override
    public String getLocator() { return "RELATIVE_LOCATOR"; }

    @Test
    public void testRelativeXPath() throws Exception {
        driver.get(baseUrl);

        // Search link in sidebar
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[normalize-space()='Search']")
        )).click();

        // Search input
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[@placeholder='Artists, songs, albums, or playlists']")
        ));
        searchInput.clear();
        searchInput.sendKeys("Michael Jackson");

        // X icon
        driver.findElement(
            By.xpath("//div[@class='input-icon-container right ng-star-inserted']/svg-icon")
        ).click();
        assertEquals("", searchInput.getDomAttribute("value"));
    }
}

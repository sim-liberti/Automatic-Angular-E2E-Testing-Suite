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

        // Link MyPlaylists
        driver.findElement(
            By.xpath("//a[contains(text(),'My Playlists')]")
        ).click();

        // First playlist
        wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(@href, '/playlist/0vhooTWkjMKTZXvnXthXdo')])[2]"))
        )).click();

        // Song count text
        String songCountText = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector(".media-info")
        )).getText();
        // Song count number from text
        Matcher matcher = Pattern.compile("\\d+").matcher(songCountText);
        int songCountFromText = Integer.parseInt(matcher.find() ? matcher.group() : "0");
        // Song count from counting elements
        int songCount = driver.findElement(
            By.xpath("//as-playlist/div[2]/div")
        ).findElements(By.tagName("as-playlist-track")).size();

        assertEquals(songCount, songCountFromText);
    }

}

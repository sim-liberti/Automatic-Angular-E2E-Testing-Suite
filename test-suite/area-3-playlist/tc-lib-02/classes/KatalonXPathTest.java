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

        // Link MyPlaylists
        driver.findElement(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Browse'])[1]/following::a[1]")
        ).click();

        // First playlist
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Source Code'])[1]/following::h2[1]")
        )).click();

        // Song count text
        String songCountText = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Title'])[1]/preceding::div[3]")
        )).getText();
        // Song count number from text
        Matcher matcher = Pattern.compile("\\d+").matcher(songCountText);
        int songCountFromText = Integer.parseInt(matcher.find() ? matcher.group() : "0");
        // Song count from counting elements
        int songCount = driver.findElement(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Album'])[1]/following::div[2]")
        ).findElements(By.tagName("as-playlist-track")).size();

        assertEquals(songCount, songCountFromText);
    }

}

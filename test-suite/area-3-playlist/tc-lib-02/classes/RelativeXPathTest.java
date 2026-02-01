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

        // Link MyPlaylists
        driver.findElement(
            By.xpath("//a[normalize-space()='My Playlists']")
        ).click();

        // First playlist
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//as-card[@ng-reflect-title='The Goats']//a")
        )).click();

        // Song count text
        String songCountText = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//as-media-summary[@type='Playlist']//div[3]")
        )).getText();
        // Song count number from text
        Matcher matcher = Pattern.compile("\\d+").matcher(songCountText);
        int songCountFromText = Integer.parseInt(matcher.find() ? matcher.group() : "0");
        // Song count from counting elements
        int songCount = driver.findElement(
            By.xpath("//body/angular-spotify-root/as-layout/as-main-view/div/as-playlist/div[2]/div[1]")
        ).findElements(By.tagName("as-playlist-track")).size();

        assertEquals(songCount, songCountFromText);
    }
}

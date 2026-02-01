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
        ));

        // Song card
        WebElement songCard = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//as-playlist-track[1]//as-media-table-row[1]//as-track-main-info[1]")
        ));
        new Actions(driver).doubleClick(songCard).perform();

        // Next btn
        driver.findElement(
            By.xpath("//div[@class='now-playing-bar-center']//div[2]")
        ).click();

        // Second song card
        String songCardText = driver.findElement(
            By.xpath("//as-playlist-track[2]//as-media-table-row[1]//as-track-main-info[1]//div[2]//div[1]")
        ).getText();

        // Now playing song
        String nowPlayingText = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//a[@class='text-white hover:underline']")
        )).getText();
        assertEquals(songCardText, nowPlayingText);
    }
}

package org.ext;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

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
        wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.elementToBeClickable(By.xpath("//as-card[@ng-reflect-title='The Goats']//a"))
        )).click();

        // Playlist heading
        String playlistHeaderText = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//as-media-summary[@type='Playlist']//div//h2")
        )).getText();
        assertEquals("The Goats", playlistHeaderText);
    }
}

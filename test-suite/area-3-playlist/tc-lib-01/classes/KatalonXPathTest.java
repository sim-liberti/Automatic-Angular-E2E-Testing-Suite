package org.ext;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

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
        wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Source Code'])[1]/following::h2[1]"))
        )).click();

        // Playlist heading
        String playlistHeaderText = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Playlist'])[1]/following::h2[1]")
        )).getText();
        assertEquals("The Goats", playlistHeaderText);
    }

}

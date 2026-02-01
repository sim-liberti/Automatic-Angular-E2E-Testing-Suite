package org.ext;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

import static org.junit.Assert.*;

public class AbsoluteXPathTest extends BaseTest {
    @Override
    public String getLocator() { return "ABSOLUTE_LOCATOR"; }

    @Test
    public void testAbsoluteXPath() throws Exception {
        driver.get(baseUrl);

        // Link MyPlaylists
        driver.findElement(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-nav-bar/ul/li[4]/a")
        ).click();

        // First playlist
        wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.elementToBeClickable(By.xpath("/html/body/angular-spotify-root/as-layout/as-main-view/div[2]/as-playlists/div/as-playlist-list/div/as-card[1]/a"))
        )).click();

        // Playlist heading
        String playlistHeaderText = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-main-view/div[2]/as-playlist/div[1]/as-media-summary/div/h2")
        )).getText();
        assertEquals("The Goats", playlistHeaderText);
    }

}

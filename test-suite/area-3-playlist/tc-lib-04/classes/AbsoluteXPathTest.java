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
         wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-main-view/div[2]/as-playlists/div/as-playlist-list/div/as-card[1]/a")
         ));

         // Song card
        WebElement songCard = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-main-view/div[2]/as-playlist/div[2]/div/as-playlist-track[1]/as-media-table-row/as-track-main-info")
        ));
        new Actions(driver).doubleClick(songCard).perform();

        // Next btn
        driver.findElement(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-now-playing-bar/footer/div[2]/as-player-controls/div/div[2]")
        ).click();

        // Second song card
        String songCardText = driver.findElement(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-main-view/div[2]/as-playlist/div[2]/div/as-playlist-track[2]/as-media-table-row/as-track-main-info")
        ).getText();

        // Now playing song
        String nowPlayingText = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-now-playing-bar/footer/div[1]/as-track-current-info/div[2]/div[1]/a")
        )).getText();
        assertEquals(songCardText, nowPlayingText);
    }

}

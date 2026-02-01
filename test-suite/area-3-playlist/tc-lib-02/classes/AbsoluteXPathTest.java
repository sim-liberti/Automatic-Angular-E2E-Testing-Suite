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
         )).click();

        // Song count text
        String songCountText = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-main-view/div[2]/as-playlist/div[1]/as-media-summary/div/div[2]/div[2]")
        )).getText();
        // Song count number from text
        Matcher matcher = Pattern.compile("\\d+").matcher(songCountText);
        int songCountFromText = Integer.parseInt(matcher.find() ? matcher.group() : "0");
        // Song count from counting elements
        int songCount = driver.findElement(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-main-view/div[2]/as-playlist/div[2]/div")
        ).findElements(By.tagName("as-playlist-track")).size();

        assertEquals(songCount, songCountFromText);
    }

}

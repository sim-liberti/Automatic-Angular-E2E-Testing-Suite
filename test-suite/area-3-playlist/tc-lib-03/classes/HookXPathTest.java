package org.ext;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HookXPathTest extends BaseTest {
    @Override
    public String getLocator() { return "HOOK_LOCATOR"; }

    @Test
    public void testHookXPath() throws Exception {
        driver.get(baseUrl);

        // Link MyPlaylists
        driver.findElement(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-ul-3]//*[@x-test-hook-li-4][4]//*[@x-test-hook-a-5]")
        ).click();

        // First playlist
        wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.elementToBeClickable(By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-main-view-3]//*[@x-test-tpl-div-2]//*[@x-test-tpl-div-1]//*[@x-test-hook-as-playlist-list-2]//*[@x-test-tpl-div-1]//*[@x-test-hook-as-card-2][1]//*[@x-test-tpl-a-1]"))
        )).click();

        // Song card
        WebElement songCard = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-main-view-3]//*[@x-test-tpl-div-2]//*[@x-test-tpl-div-5]//*[@x-test-hook-as-playlist-track-14][1]//*[@x-test-tpl-as-media-table-row-1]//*[@x-test-hook-as-track-main-info-4]")
        ));
        new Actions(driver).doubleClick(songCard).perform();

        // Song text
        WebElement songName = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-main-view-3]//*[@x-test-tpl-div-2]//*[@x-test-tpl-div-5]//*[@x-test-hook-as-playlist-track-14][1]//*[@x-test-tpl-as-media-table-row-1]//*[@x-test-hook-as-track-main-info-4]//*[@x-test-tpl-div-3]//*[@x-test-hook-div-4]")
        ));
        Thread.sleep(1000);
        assertTrue(Objects.requireNonNull(songName.getDomAttribute("class")).contains("text-primary"));

        // Now playing song
        WebElement nowPlaying = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-now-playing-bar-4]//*[@x-test-tpl-footer-1]//*[@x-test-hook-as-track-current-info-3]//*[@x-test-tpl-div-3]//*[@x-test-hook-a-5]")
        ));
        assertEquals(songName.getText(), nowPlaying.getText());
    }
}

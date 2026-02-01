package org.ext;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class RobulaPlusXPathTest extends BaseTest {
    @Override
    public String getLocator() { return "ROBULAPLUS_LOCATOR"; }

    @Test
    public void testRobulaXPath() throws Exception {
        driver.get(baseUrl);

        // Link MyPlaylists
        driver.findElement(
            By.xpath("//*[@ng-reflect-router-link='/collection/playlists']")
        ).click();

        // First playlist
        wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.elementToBeClickable(By.xpath("//*[@_ngcontent-ng-c810943523='' and @ng-reflect-router-link='/playlist/0vhooTWkjMKTZXvnXthX']"))
        )).click();

        // Playlist sidebar
        WebElement playlist = driver.findElement(
            By.xpath("//*[@title='The Goats']")
        );
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(playlist.getDomAttribute("class")).contains("active"));
    }

}

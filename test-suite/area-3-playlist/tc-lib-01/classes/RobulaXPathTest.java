package org.ext;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class RobulaXPathTest extends BaseTest {
    @Override
    public String getLocator() { return "ROBULA_LOCATOR"; }

    @Test
    public void testRobulaXPath() throws InterruptedException {
        driver.get(baseUrl);

        // Link MyPlaylists
        driver.findElement(
            By.xpath("//a[@ng-reflect-router-link='/collection/playlists']")
        ).click();

        // First playlist
        wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.elementToBeClickable(By.xpath("//a[@_ngcontent-ng-c810943523='' and @ng-reflect-router-link='/playlist/0vhooTWkjMKTZXvnXthX']"))
        )).click();

        // Playlist heading
        String playlistHeaderText = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//h2")
        )).getText();
        assertEquals("The Goats", playlistHeaderText);
    }
}

package org.ext;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class SeleniumXPathTest extends BaseTest {
    @Override
    public String getLocator() { return "SELENIUM_LOCATOR"; }

    @Test
    public void testSeleniumXPath() throws Exception {
        driver.get(baseUrl);

        // Link MyPlaylists
        driver.findElement(
            By.xpath("//a[contains(text(),'My Playlists')]")
        ).click();

        // First playlist
        wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(@href, '/playlist/0vhooTWkjMKTZXvnXthXdo')])[2]"))
        )).click();

        // Playlist sidebar
        WebElement playlist = driver.findElement(
            By.xpath("//span[contains(.,'The Goats')]")
        );
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(playlist.getDomAttribute("class")).contains("active"));
    }

}

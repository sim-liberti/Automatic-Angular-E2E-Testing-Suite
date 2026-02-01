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

        // Link Home
        WebElement link = driver.findElement(
            By.xpath("//a[normalize-space()='Home']")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(link.getDomAttribute("class")).contains("active"));

        // Link Search
        link = driver.findElement(
            By.xpath("//a[normalize-space()='Search']")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(link.getDomAttribute("class")).contains("active"));

        // Link Browse
        link = driver.findElement(
            By.xpath("//a[normalize-space()='Browse']")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(link.getDomAttribute("class")).contains("active"));

        // Link MyPlaylists
        link = driver.findElement(
            By.xpath("//a[normalize-space()='My Playlists']")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(link.getDomAttribute("class")).contains("active"));

        // Link MyAlbums
        link = driver.findElement(
            By.xpath("//a[normalize-space()='My Albums']")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(link.getDomAttribute("class")).contains("active"));

        // Link LikedSongs
        link = driver.findElement(
            By.xpath("//a[normalize-space()='Liked songs']")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(link.getDomAttribute("class")).contains("active"));
    }
}

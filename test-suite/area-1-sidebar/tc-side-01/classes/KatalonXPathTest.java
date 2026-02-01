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

        // Link Home
        WebElement link = driver.findElement(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search'])[1]/preceding::a[1]")
        );
        link.click();
        Thread.sleep(200);
        assertEquals(baseUrl, driver.getCurrentUrl());

        // Link Search
        link = driver.findElement(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Home'])[1]/following::a[1]")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("/search"));

        // Link Browse
        link = driver.findElement(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search'])[1]/following::a[1]")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("/browse"));

        // Link MyPlaylists
        link = driver.findElement(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Browse'])[1]/following::a[1]")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("/collection/playlists"));

        // Link MyAlbums
        link = driver.findElement(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Playlists'])[1]/following::a[1]")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("/albums"));

        // Link LikedSongs
        link = driver.findElement(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Albums'])[1]/following::a[1]")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("/collection/tracks"));
    }

}

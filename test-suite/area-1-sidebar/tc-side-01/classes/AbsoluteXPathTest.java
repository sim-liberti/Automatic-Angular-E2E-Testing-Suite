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

        // Link Home
        WebElement link = driver.findElement(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-nav-bar/ul/li[1]/a")
        );
        link.click();
        Thread.sleep(200);
        assertEquals(baseUrl, driver.getCurrentUrl());

        // Link Search
        link = driver.findElement(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-nav-bar/ul/li[2]/a")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("/search"));

        // Link Browse
        link = driver.findElement(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-nav-bar/ul/li[3]/a")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("/browse"));

        // Link MyPlaylists
        link = driver.findElement(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-nav-bar/ul/li[4]/a")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("/collection/playlists"));

        // Link MyAlbums
        link = driver.findElement(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-nav-bar/ul/li[5]/a")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("/albums"));

        // Link LikedSongs
        link = driver.findElement(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-nav-bar/ul/li[6]/a")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("/collection/tracks"));
    }

}

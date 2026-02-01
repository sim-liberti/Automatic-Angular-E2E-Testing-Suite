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

        // Link Home
        WebElement link = driver.findElement(
            By.xpath("//a[contains(text(),'Home')]")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(link.getDomAttribute("class")).contains("active"));

        // Link Search
        link = driver.findElement(
            By.xpath("//a[contains(text(),'Search')]")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(link.getDomAttribute("class")).contains("active"));

        // Link Browse
        link = driver.findElement(
            By.xpath("//a[contains(text(),'Browse')]")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(link.getDomAttribute("class")).contains("active"));

        // Link MyPlaylists
        link = driver.findElement(
            By.xpath("//a[contains(text(),'My Playlists')]")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(link.getDomAttribute("class")).contains("active"));

        // Link MyAlbums
        link = driver.findElement(
            By.xpath("//a[contains(text(),'My Albums')]")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(link.getDomAttribute("class")).contains("active"));

        // Link LikedSongs
        link = driver.findElement(
            By.xpath("//a[contains(text(),'Liked songs')]")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(link.getDomAttribute("class")).contains("active"));
    }

}

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

        // Link Home
        WebElement link = driver.findElement(
            By.xpath("//a[@ng-reflect-router-link='']")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(link.getDomAttribute("class")).contains("active"));

        // Link Search
        link = driver.findElement(
            By.xpath("//a[@ng-reflect-router-link='/search']")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(link.getDomAttribute("class")).contains("active"));

        // Link Browse
        link = driver.findElement(
            By.xpath("//a[@ng-reflect-router-link='/browse']")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(link.getDomAttribute("class")).contains("active"));

        // Link MyPlaylists
        link = driver.findElement(
            By.xpath("//a[@ng-reflect-router-link='/collection/playlists']")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(link.getDomAttribute("class")).contains("active"));

        // Link MyAlbums
        link = driver.findElement(
            By.xpath("//a[@ng-reflect-router-link='/albums']")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(link.getDomAttribute("class")).contains("active"));

        // Link LikedSongs
        link = driver.findElement(
            By.xpath("//a[@ng-reflect-router-link='/collection/tracks']")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(link.getDomAttribute("class")).contains("active"));
    }
}

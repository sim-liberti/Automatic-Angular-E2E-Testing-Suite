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

        // Song card
        WebElement songCard = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//as-track-main-info")
        ));
        new Actions(driver).doubleClick(songCard).perform();

        Thread.sleep(1000);
        // Next btn
        driver.findElement(
            By.cssSelector(".svg-icon-step-forward path")
        ).click();

        Thread.sleep(500);
        // Second song card
        String songCardText = driver.findElement(
            By.cssSelector(".ng-star-inserted:nth-child(2) > .playlist-tracks-grid > .ng-star-inserted > .flex > .ellipsis-one-line")
        ).getText();

        // Now playing song
        String nowPlayingText = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector(".ellipsis-one-line > .text-white")
        )).getText();
        assertEquals(songCardText, nowPlayingText);
    }

}

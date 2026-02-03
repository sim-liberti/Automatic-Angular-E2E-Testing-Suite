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

public class RobulaXPathTest extends BaseTest {
    @Override
    public String getLocator() { return "ROBULA_LOCATOR"; }

    @Test
    public void testRobulaXPath() throws InterruptedException {
        driver.get(baseUrl);

        // Link MyPlaylists
        driver.findElement(
            By.xpath("//a[@href='/collection/playlists']")
        ).click();

        // First playlist
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//a[@ng-reflect-router-link='/playlist/0vhooTWkjMKTZXvnXthX'][@class='card']")
        )).click();

        // Song card
        WebElement songCard = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//as-playlist-track[1]/*/as-track-main-info")
        ));
        new Actions(driver).doubleClick(songCard).perform();

        Thread.sleep(1000);
        // Next btn
        driver.findElement(
            By.xpath("//div[2][@class='control-button hover:text-white']")
        ).click();

        Thread.sleep(500);
        // Second song card
        String songCardText = driver.findElement(
            By.xpath("//as-playlist-track[2]/*/as-track-main-info")
        ).getText();

        // Now playing song
        String nowPlayingText = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//a[@class='text-white hover:underline']")
        )).getText();
        assertEquals(songCardText, nowPlayingText);
    }
}

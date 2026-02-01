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
            By.xpath("//a[@ng-reflect-router-link='/collection/playlists']")
        ).click();

        // First playlist
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//a[@ng-reflect-router-link='/playlist/0vhooTWkjMKTZXvnXthX'][@_ngcontent-ng-c810943523='']")
        )).click();

        // Song card
        WebElement songCard = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//as-playlist-track[@ng-reflect-index='0']/*")
        ));
        new Actions(driver).doubleClick(songCard).perform();

        // Next btn
        driver.findElement(
            By.xpath("")
        ).click();

        // Second song card
        String songCardText = driver.findElement(
            By.xpath("")
        ).getText();

        // Now playing song
        String nowPlayingText = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("")
        )).getText();
        assertEquals(songCardText, nowPlayingText);
    }
}

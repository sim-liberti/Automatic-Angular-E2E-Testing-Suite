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

        // Now playing song
        Thread.sleep(500);
        String prevPlayingText = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//a[@class='text-white hover:underline']")
        )).getText();

        // Next Btn
        driver.findElement(
            By.xpath("//div[@x-test-hook-div-5=''][@_ngcontent-ng-c38434958='']")
        ).click();

        // Next playing song
        Thread.sleep(500);
        String nextPlayingText = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//a[@class='text-white hover:underline']")
        )).getText();

        assertNotEquals(prevPlayingText, nextPlayingText);
    }
}

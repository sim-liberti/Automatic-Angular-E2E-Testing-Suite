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

public class RobulaPlusXPathTest extends BaseTest {
    @Override
    public String getLocator() { return "ROBULAPLUS_LOCATOR"; }

    @Test
    public void testRobulaXPath() throws Exception {
        driver.get(baseUrl);

        // Link MyPlaylists
        driver.findElement(
            By.xpath("//*[@href='/collection/playlists']")
        ).click();

        // First playlist
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[@class='card' and @ng-reflect-router-link='/playlist/0vhooTWkjMKTZXvnXthX']")
        )).click();

        // Song card
        WebElement songCard = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[1]/*/as-track-main-info")
        ));
        new Actions(driver).doubleClick(songCard).perform();

        Thread.sleep(1000);
        // Next btn
        driver.findElement(
            By.xpath("//*[@class='flex justify-center']/*[3]")
        ).click();

        Thread.sleep(500);
        // Second song card
        String songCardText = driver.findElement(
            By.xpath("//*[2]/*/as-track-main-info")
        ).getText();

        // Now playing song
        String nowPlayingText = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[@class='text-white hover:underline']")
        )).getText();
        assertEquals(songCardText, nowPlayingText);
    }

}

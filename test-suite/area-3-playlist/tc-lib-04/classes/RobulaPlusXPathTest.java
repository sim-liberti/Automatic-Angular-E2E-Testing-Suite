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
            By.xpath("//*[@ng-reflect-router-link='/collection/playlists']")
        ).click();

        // First playlist
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[@_ngcontent-ng-c810943523='' and @ng-reflect-router-link='/playlist/0vhooTWkjMKTZXvnXthX']")
        )).click();

        // Song card
        WebElement songCard = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[@ng-reflect-index='0']/*")
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

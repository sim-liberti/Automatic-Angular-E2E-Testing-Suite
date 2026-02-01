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

        // Song count text
        String songCountText = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@class='media-info ng-star-inserted']")
        )).getText();
        // Song count number from text
        Matcher matcher = Pattern.compile("\\d+").matcher(songCountText);
        int songCountFromText = Integer.parseInt(matcher.find() ? matcher.group() : "0");
        // Song count from counting elements
        int songCount = driver.findElement(
            By.xpath("//div[@class='mb-8 ng-star-inserted']")
        ).findElements(By.tagName("as-playlist-track")).size();

        assertEquals(songCount, songCountFromText);
    }
}

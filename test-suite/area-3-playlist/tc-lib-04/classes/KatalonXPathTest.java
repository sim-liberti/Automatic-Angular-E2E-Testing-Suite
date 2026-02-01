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

public class KatalonXPathTest extends BaseTest {
    @Override
    public String getLocator() { return "KATALON_LOCATOR"; }

    @Test
    public void testKatalonXPath() throws Exception {
        driver.get(baseUrl);

        // Link MyPlaylists
        driver.findElement(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Browse'])[1]/following::a[1]")
        ).click();

        // First playlist
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Source Code'])[1]/following::h2[1]")
        )).click();

        // Song card
        WebElement songCard = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Album'])[1]/following::as-track-main-info[1]")
        ));
        new Actions(driver).doubleClick(songCard).perform();

        // Next btn
        driver.findElement(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Stop'])[1]/preceding::div[13]")
        ).click();

        // Second song card
        String songCardText = driver.findElement(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Michael Jackson'])[2]/preceding::div[1]")
        ).getText();

        // Now playing song
        String nowPlayingText = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jan 28, 2026'])[5]/following::a[1]")
        )).getText();
        assertEquals(songCardText, nowPlayingText);
    }

}

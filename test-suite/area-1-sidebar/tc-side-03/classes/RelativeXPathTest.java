package org.ext;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class RelativeXPathTest extends BaseTest {
    @Override
    public String getLocator() { return "RELATIVE_LOCATOR"; }

    @Test
    public void testRelativeXPath() throws Exception {
        driver.get(baseUrl);
        String titleXpath = "";

        // Element 1
        Thread.sleep(200);
        String elementText = driver.findElement(
            By.xpath("//span[normalize-space()='The Goats']")
        ).getText();
        driver.findElement(
            By.xpath("//a[@title='The Goats']")
        ).click();
        String title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 2
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("//span[normalize-space()='La roba consigliata']")
        ).getText();
        driver.findElement(
            By.xpath("//a[@title='La roba consigliata']")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 3
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("//span[normalize-space()='My Shazam Tracks']")
        ).getText();
        driver.findElement(
            By.xpath("//a[@title='My Shazam Tracks']")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 4
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("//a[@title=\"Chiaretta's favourites\"]//span[@class='ellipsis-one-line']")
        ).getText();
        driver.findElement(
            By.xpath("//a[@title=\"Chiaretta's favourites\"]")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 5
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("//span[normalize-space()='Weeb Moment']")
        ).getText();
        driver.findElement(
            By.xpath("//a[@title='Weeb Moment']")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 6
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("//span[normalize-space()='Metal Corner']")
        ).getText();
        driver.findElement(
            By.xpath("//a[@title='Metal Corner']")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);
    }
}

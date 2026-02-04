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

public class RobulaXPathTest extends BaseTest {
    @Override
    public String getLocator() { return "ROBULA_LOCATOR"; }

    @Test
    public void testRobulaXPath() throws InterruptedException {
        driver.get(baseUrl);

        String titleXpath = "//h2";

        // Element 1
        Thread.sleep(200);
        String elementText = driver.findElement(
            By.xpath("//a[@title='The Goats']/span")
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
            By.xpath("//a[@title='La roba consigliata']/span")
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
            By.xpath("//a[@title='My Shazam Tracks']/span")
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
            By.xpath("//a[@href='/playlist/7nCjc550yOmQYx6Gi71xPD']/span")
        ).getText();
        driver.findElement(
            By.xpath("//a[@href='/playlist/7nCjc550yOmQYx6Gi71xPD']")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 5
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("//a[@title='Weeb Moment']/span")
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
            By.xpath("//a[@title='Metal Corner']/span")
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

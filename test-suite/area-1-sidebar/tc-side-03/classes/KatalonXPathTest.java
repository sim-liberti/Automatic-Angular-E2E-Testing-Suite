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

public class KatalonXPathTest extends BaseTest {
    @Override
    public String getLocator() { return "KATALON_LOCATOR"; }

    @Test
    public void testKatalonXPath() throws Exception {
        driver.get(baseUrl);

        String titleXpath = "(.//*[normalize-space(text()) and normalize-space(.)='Playlist'])[1]/following::h2[1]";

        // Element 1
        Thread.sleep(200);
        String elementText = driver.findElement(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Liked songs'])[1]/following::span[1]")
        ).getText();
        driver.findElement(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Liked songs'])[1]/following::a[1]")
        ).click();
        String title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 2
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Liked songs'])[1]/following::span[2]")
        ).getText();
        driver.findElement(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Liked songs'])[1]/following::a[2]")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 3
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Liked songs'])[1]/following::span[3]")
        ).getText();
        driver.findElement(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Liked songs'])[1]/following::a[3]")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 4
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Liked songs'])[1]/following::span[4]")
        ).getText();
        driver.findElement(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Liked songs'])[1]/following::a[4]")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 5
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Liked songs'])[1]/following::span[5]")
        ).getText();
        driver.findElement(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Liked songs'])[1]/following::a[5]")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 6
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Liked songs'])[1]/following::span[6]")
        ).getText();
        driver.findElement(
            By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Liked songs'])[1]/following::a[6]")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);
    }

}

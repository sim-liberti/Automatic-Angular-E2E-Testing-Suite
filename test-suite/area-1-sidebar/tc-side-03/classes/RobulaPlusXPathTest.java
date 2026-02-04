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

public class RobulaPlusXPathTest extends BaseTest {
    @Override
    public String getLocator() { return "ROBULAPLUS_LOCATOR"; }

    @Test
    public void testRobulaXPath() throws Exception {
        driver.get(baseUrl);

        String titleXpath = "//h2";

        // Element 1
        Thread.sleep(200);
        String elementText = driver.findElement(
            By.xpath("//span[contains(text(),'The Goats')]")
        ).getText();
        driver.findElement(
            By.xpath("//*[@title='The Goats']")
        ).click();
        String title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 2
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("//*[contains(text(),'La roba consigliata')]")
        ).getText();
        driver.findElement(
            By.xpath("//*[@title='La roba consigliata']")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 3
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("//*[contains(text(),'My Shazam Tracks')]")
        ).getText();
        driver.findElement(
            By.xpath("//*[@title='My Shazam Tracks']")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 4
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("//*[@href='/playlist/7nCjc550yOmQYx6Gi71xPD']/span")
        ).getText();
        driver.findElement(
            By.xpath("//*[@href='/playlist/7nCjc550yOmQYx6Gi71xPD']")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 5
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("//*[contains(text(),'Weeb Moment')]")
        ).getText();
        driver.findElement(
            By.xpath("//*[@title='Weeb Moment']")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 6
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("//*[contains(text(),'Metal Corner')]")
        ).getText();
        driver.findElement(
            By.xpath("//*[@title='Metal Corner']")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);
    }

}

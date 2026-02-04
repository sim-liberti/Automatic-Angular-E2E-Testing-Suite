package org.ext;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

public class AbsoluteXPathTest extends BaseTest {
    @Override
    public String getLocator() { return "ABSOLUTE_LOCATOR"; }

    @Test
    public void testAbsoluteXPath() throws Exception {
        driver.get(baseUrl);

        String titleXpath = "/html/body/angular-spotify-root/as-layout/as-main-view/div[2]/as-playlist/div[1]/as-media-summary/div/h2";

        // Element 1
        Thread.sleep(200);
        String elementText = driver.findElement(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-nav-bar/as-nav-links/ul/li[1]/as-nav-link/a/span")
        ).getText();
        driver.findElement(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-nav-bar/as-nav-links/ul/li[1]/as-nav-link/a")
        ).click();
        String title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 2
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-nav-bar/as-nav-links/ul/li[2]/as-nav-link/a/span")
        ).getText();
        driver.findElement(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-nav-bar/as-nav-links/ul/li[2]/as-nav-link/a")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 3
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-nav-bar/as-nav-links/ul/li[3]/as-nav-link/a/span")
        ).getText();
        driver.findElement(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-nav-bar/as-nav-links/ul/li[3]/as-nav-link/a")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 4
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-nav-bar/as-nav-links/ul/li[4]/as-nav-link/a/span")
        ).getText();
        driver.findElement(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-nav-bar/as-nav-links/ul/li[4]/as-nav-link/a")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 5
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-nav-bar/as-nav-links/ul/li[5]/as-nav-link/a/span")
        ).getText();
        driver.findElement(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-nav-bar/as-nav-links/ul/li[5]/as-nav-link/a")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 6
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-nav-bar/as-nav-links/ul/li[6]/as-nav-link/a/span")
        ).getText();
        driver.findElement(
            By.xpath("/html/body/angular-spotify-root/as-layout/as-nav-bar/as-nav-links/ul/li[6]/as-nav-link/a")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);
    }
}

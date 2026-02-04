package org.ext;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

public class HookXPathTest extends BaseTest {
    @Override
    public String getLocator() { return "HOOK_LOCATOR"; }

    @Test
    public void testHookXPath() throws Exception {
        driver.get(baseUrl);

        String titleXpath = "//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-main-view-3]//*[@x-test-tpl-div-2]//*[@x-test-tpl-div-1]//*[@x-test-hook-as-media-summary-2]//*[@x-test-tpl-div-2]//*[@x-test-hook-h2-4]";

        // Element 1
        Thread.sleep(200);
        String elementText = driver.findElement(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-as-nav-links-7]//*[@x-test-tpl-ul-2]//*[@x-test-hook-li-3][1]//*[@x-test-hook-as-nav-link-4]//*[@x-test-tpl-a-1]//*[@x-test-hook-span-3]")
        ).getText();
        driver.findElement(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-as-nav-links-7]//*[@x-test-tpl-ul-2]//*[@x-test-hook-li-3][1]//*[@x-test-hook-as-nav-link-4]//*[@x-test-tpl-a-1]")
        ).click();
        String title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 2
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-as-nav-links-7]//*[@x-test-tpl-ul-2]//*[@x-test-hook-li-3][2]//*[@x-test-hook-as-nav-link-4]//*[@x-test-tpl-a-1]//*[@x-test-hook-span-3]")
        ).getText();
        driver.findElement(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-as-nav-links-7]//*[@x-test-tpl-ul-2]//*[@x-test-hook-li-3][2]//*[@x-test-hook-as-nav-link-4]//*[@x-test-tpl-a-1]")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 3
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-as-nav-links-7]//*[@x-test-tpl-ul-2]//*[@x-test-hook-li-3][3]//*[@x-test-hook-as-nav-link-4]//*[@x-test-tpl-a-1]//*[@x-test-hook-span-3]")
        ).getText();
        driver.findElement(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-as-nav-links-7]//*[@x-test-tpl-ul-2]//*[@x-test-hook-li-3][3]//*[@x-test-hook-as-nav-link-4]//*[@x-test-tpl-a-1]")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 4
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-as-nav-links-7]//*[@x-test-tpl-ul-2]//*[@x-test-hook-li-3][4]//*[@x-test-hook-as-nav-link-4]//*[@x-test-tpl-a-1]//*[@x-test-hook-span-3]")
        ).getText();
        driver.findElement(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-as-nav-links-7]//*[@x-test-tpl-ul-2]//*[@x-test-hook-li-3][4]//*[@x-test-hook-as-nav-link-4]//*[@x-test-tpl-a-1]")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 5
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-as-nav-links-7]//*[@x-test-tpl-ul-2]//*[@x-test-hook-li-3][5]//*[@x-test-hook-as-nav-link-4]//*[@x-test-tpl-a-1]//*[@x-test-hook-span-3]")
        ).getText();
        driver.findElement(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-as-nav-links-7]//*[@x-test-tpl-ul-2]//*[@x-test-hook-li-3][5]//*[@x-test-hook-as-nav-link-4]//*[@x-test-tpl-a-1]")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);

        // Element 6
        Thread.sleep(200);
        elementText = driver.findElement(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-as-nav-links-7]//*[@x-test-tpl-ul-2]//*[@x-test-hook-li-3][6]//*[@x-test-hook-as-nav-link-4]//*[@x-test-tpl-a-1]//*[@x-test-hook-span-3]")
        ).getText();
        driver.findElement(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-as-nav-links-7]//*[@x-test-tpl-ul-2]//*[@x-test-hook-li-3][6]//*[@x-test-hook-as-nav-link-4]//*[@x-test-tpl-a-1]")
        ).click();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(titleXpath)
        )).getText();
        assertEquals(title, elementText);
    }
}

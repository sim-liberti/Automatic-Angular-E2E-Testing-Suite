package org.ext;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Objects;

import static org.junit.Assert.assertTrue;

public class HookXPathTest extends BaseTest {
    @Override
    public String getLocator() { return "HOOK_LOCATOR"; }

    @Test
    public void testHookXPath() throws Exception {
        driver.get(baseUrl);

        // Link Home
        WebElement link = driver.findElement(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-ul-3]//*[@x-test-hook-li-4][1]//*[@x-test-hook-a-5]")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(link.getDomAttribute("class")).contains("active"));

        // Link Search
        link = driver.findElement(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-ul-3]//*[@x-test-hook-li-4][2]//*[@x-test-hook-a-5]")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(link.getDomAttribute("class")).contains("active"));

        // Link Browse
        link = driver.findElement(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-ul-3]//*[@x-test-hook-li-4][3]//*[@x-test-hook-a-5]")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(link.getDomAttribute("class")).contains("active"));

        // Link MyPlaylists
        link = driver.findElement(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-ul-3]//*[@x-test-hook-li-4][4]//*[@x-test-hook-a-5]")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(link.getDomAttribute("class")).contains("active"));

        // Link MyAlbums
        link = driver.findElement(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-ul-3]//*[@x-test-hook-li-4][5]//*[@x-test-hook-a-5]")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(link.getDomAttribute("class")).contains("active"));

        // Link LikedSongs
        link = driver.findElement(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-ul-3]//*[@x-test-hook-li-4][6]//*[@x-test-hook-a-5]")
        );
        link.click();
        Thread.sleep(200);
        assertTrue(Objects.requireNonNull(link.getDomAttribute("class")).contains("active"));
    }
}

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

        // Search link in sidebar
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-ul-3]//*[@x-test-hook-li-4][2]//*[@x-test-hook-a-5]")
        )).click();

        // Search input
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-main-view-3]//*[@x-test-tpl-div-2]//*[@x-test-tpl-div-1]//*[@x-test-hook-as-input-3]//*[@x-test-tpl-div-1]//*[@x-test-hook-input-4]")
        ));
        searchInput.clear();
        searchInput.sendKeys("Billie Jean");
        Thread.sleep(1000);

        // Results
        List<WebElement> results = driver.findElement(
            By.xpath("//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-main-view-3]//*[@x-test-tpl-div-2]//*[@x-test-tpl-div-1]//*[@x-test-hook-div-12]")
        ).findElements(By.xpath(".//*[normalize-space()='Billie Jean']"));
        assertFalse("Searched song not found.", results.isEmpty());
    }
}

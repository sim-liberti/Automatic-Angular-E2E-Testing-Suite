# Custom Locators

This guide explains how to generate advanced locators that are typically not supported by standard recording tools like Selenium IDE or the Katalon Extension. These strategies are designed to improve test stability and precision.

## Supported Locator Strategies
You can create the following types of locators:

* **ROBULA Locators** (Robust Locators)
* **ROBULA+ Locators** (An enhanced version of the ROBULA algorithm)
* **Hook-Based Locators**

### ROBULA and ROBULA+
Currently, generating these locators requires manual configuration within the `robula/Robula.java` and `robulaplus/RobulaPlus.java` entry points.

**Usage Instructions:**

1. **Prepare Resources:** Place the complete HTML DOM files you want to analyze inside the module's `resources` folder.
2. **Configure the Application:** Open he `robula/Robula.java` or `robulaplus/RobulaPlus.java` and locate the main function.
3. **Define Targets:** For each element you want to generate a locator for, add a new line to the `elements` list using the following syntax:

```java
elements.add(new element(
    "SongsNavbar", // 1. Name
    "/html/body/angular-root/as-nav-bar/ul/li[6]/a", // 2. Absolute XPath
    "home.html" // 3. Source File
));
```

### Hook-Based Locators
This strategy generates locators based on custom attributes, ensuring high stability even if the UI changes.

**Prerequisite:**

Before using this strategy, you must ensure that test hooks are correctly injected into your application. Please refer to the [Hook Injector Guide](../hook-injector/README.md) for detailed instructions.

**Configuration Steps:**
1.  Download or locate the [attributeHooksLocators.js](https://github.com/sim-liberti/Automatic-Angular-E2E-Testing-Suite/blob/master/custom-locators/src/main/java/org/unina/hooklocators/attributeHooksLocators.js) file.
2.  Open the **Katalon Extension** tool.
3.  Navigate to the **Extension Scripts** tab.
4.  Add the `.js` file to the scripts list to enable hook-based locator generation.
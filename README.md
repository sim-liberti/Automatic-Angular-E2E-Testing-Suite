# Automatic Angular E2E Testing Suite
A comprehensive automation tool designed to create and test mutations for HTML files within Angular repositories. This project streamlines the process of End-to-End (E2E) testing by generating targeted mutations and validating them against your application.

## Project Structure
The project relies on a modular architecture:
```txt
(root)
├── 📁 custom-locators      // Module for creating locators not present in Katalon/Selenium
├── 📁 hook-injector        // Module to inject custom hooks into the application under test
├── 📁 mutation-generator
|   ├── 📁 common           // Shared logic and utilities
|   ├── 📁 llm-generator    // (Upcoming) Mutation generator via LLM prompts
|   └── 📁 static-generator // Mutation generator using static analysis
├── 📁 mutation-tester      // Module to execute automatic tests on generated mutations
├── generator-config.json   // Main configuration file for the suite
└── pom.xml                 // Main Maven module file
```

## Getting started
### Prerequisites
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/download.cgi)
- Target project: a front-end project based on [AngularJS](https://angularjs.org/).

### Configuration
To start using the tool, configure the `generator-config.json` file.

**Configuration parameters**
- `seed`: (Optional) A seed used to initialize the [RandomSelector](https://github.com/sim-liberti/Automatic-Angular-E2E-Testing-Suite/blob/master/mutation-generator/common/src/main/java/org/unina/util/RandomSelector.java) to ensure reproducible results. Leave blank for random execution.
- `repositoryRootPath`: The absolute path to the Angular project you wish to mutate.
- `mutations`: An array of objects defining the mutation rules.
  - `name`: The name of the mutation.
  - `file_path`: The absolute path of the file where the tag to mutate is located.
  - `target_matcher`: Object used to locate the tag to mutate inside the file specified above
    - `type`: The type of matcher to be used. You can choose between `class`,`text`,`id`,`attribute`.
    - `key`: The key of the attribute of the target element. Only necessary if you choose the `attribute` type.
    - `value`: The value of the class, text, id or attribute of the target element.

### 2. Generate Mutations
With the configuration in place, you need to compile the generator module and then execute it.

**Step 1: Build the Module**

Run the following Maven command to build specifically the static-generator module and its dependencies:
```bash
mvn clean install -pl :static-generator -am
```

**Step 2: Run the Generator**

After a successful build, a `static-generator.jar` file will be created at the project root. Execute it with:
```bash
java -jar static-generator.jar
```

A `mutations.db` file will be generated at the project root. This database stores every mutation, including its name, type, ID, and the associated file path.

### Test the application
Currently, tests are executed manually via an IDE.
1. Create Test Classes: Place your test classes inside the `mutation-tester/org.unina/classes/` folder. 
2. Extend BaseTest: Ensure every test class extends BaseTest. This class handles the Selenium WebDriver initialization and authentication logic (which can be customized). 
3. Run the Tester: Run the App.java file located in the `mutation-tester/` module.

**Test Results:** 

Upon completion, two files are generated in the output folder:
- `stats.csv`: Results grouped by test class name (fragility, obsolescence, and skipped tests). 
- `batches.csv`: A detailed log of every test execution, including results and error messages.

### Secondary modules
For advanced usage regarding custom locators or hook injection, please refer to the specific module documentation:
- [Custom Locators Documentation](custom-locators/README.md)
- [Hook Injector Documentation](hook-injector/README.md)
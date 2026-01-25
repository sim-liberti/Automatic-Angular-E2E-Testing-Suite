# Hook Injector

This module automates the injection of test hooks into your application's source code, facilitating more robust testing strategies.

## Prerequisites

Before executing the injector, you must set up the `test-guard` environment.

1.  **Navigate to the module directory:**
    Open your terminal and change the directory to `test-hooks/test-guard`.
    ```bash
    cd test-hooks/test-guard
    ```

2.  **Install Dependencies:**
    Run the following command to install the required Node.js modules:
    ```bash
    npm install
    ```
    > **Troubleshooting:** If the installation fails due to C compilation errors, try running:
    > ```bash
    > CFLAGS="-std=gnu89" npm install
    > ```

## Usage

Once the dependencies are installed, you can build and run the tool using the provided JAR file.

### 1. Build the Project
Compile the project using Maven:
```bash
mvn clean install
```

### 2. Run the Injector

Execute the generated JAR file with the following three required arguments:
1. Extension: The file extension to target (e.g., .html).
2. Grammar: The framework grammar to use (e.g., angularjs).
3. Path: The absolute path to the source code of the application you want to modify.

**Example:**
```shell
java -jar target/Tesi-injector-plugin-1.0-SNAPSHOT.jar ".html" "angularjs" "C:\Users\Name\Projects\MyAngularApp\src"
```
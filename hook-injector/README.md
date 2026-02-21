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

**Troubleshooting**

The installation process may fail if your system lacks the necessary C/C++ development tools required to compile native add-ons. Use the following workarounds based on your operating system:
- **Linux environments:** Standard build tools are typically pre-installed, but compiler compatibility issues may occur. You can resolve this by explicitly specifying the C standard during installation:
  ```bash
  CFLAGS="-std=gnu89" npm install
  ```
- **Windows environments:** The Visual C++ build tools are strictly required. Refer to this [installation guide](https://github.com/bycloudai/InstallVSBuildToolsWindows) to properly configure your local environment. Once the build tools are successfully installed, re-run `npm install`.

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
java -jar hook-injector/target/hook-injector-1.0.0.jar ".html" "angularjs" "C:\Users\Name\Projects\MyAngularApp\src"
```

> **Troubleshooting:** 
> If you are on Linux and the script execution exits with code != 0, you might need to make the script executable:
> ```shell
> sudo chmod +x hook-injector/hookInjection.sh
>```
> Then you can manually run the script file to inject the hooks.

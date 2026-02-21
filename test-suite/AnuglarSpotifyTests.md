# Tests on the Angular-Spotify application
This tool has been used to run tests on the [Angular-Spotify](https://github.com/trungvose/angular-spotify) application.
This guide outlines the necessary setup processes to configure both the Spotify API and the local application environment to execute these tests successfully.

### Prerequisites
- A Spotify Premium account.
- Your local IPv4 address (e.g., 192.168.1.193).
- Node.js and npm installed on your machine.
- Git installed on your machine.

### Configuration
The setup process requires configuring an application via the Spotify Developer Dashboard and modifying the local project files.

**Spotify Configuration**

To allow the application to authenticate via Spotify, you must register it as a developer application.

1. Navigate to the [Spotify Dashboard for Developers](https://developer.spotify.com/dashboard) and log in.
2. Click the **Create App** button.
3. Provide a name and description for your application.
4. Locate the Redirect URIs field and insert your local development address: `https://<your_local_ip>:4200/`. 
5. Save your changes. 
6. Copy the generated **Client ID** from the application overview page. Set this aside for the next step.

**Application Configuration**

Once the Spotify API is configured, you must link the local application to your newly created Spotify App.
1. Clone the target repository to your local machine: 
    ```shell
    git clone https://github.com/trungvose/angular-spotify.git
    ```
2. Open the cloned `angular-spotify` directory in your preferred Integrated Development Environment (IDE).
3. Navigate to the following file path: `angular-spotify/libs/web/auth/data-access/src/lib/models/spotify-authorize.ts`.
4. Update the `CLIENT_ID` variable with the Client ID you copied from the Spotify Dashboard.
5. Navigate to the project configuration file: `angular-spotify/apps/angular-spotify/project.json` 
6. Locate the `serve` configuration block. Update the `host` key with your local IP address and add the `"ssl": true` property immediately below the `port` key.

The modified `serve` block should resemble the following structure
```json
"serve": {
  "executor": "@angular-devkit/build-angular:dev-server",
  "options": {
    "hmr": true,
    "buildTarget": "angular-spotify:build",
    "host": "192.168.20.4",
    "port": 4200,
    "ssl": true,
    "allowedHosts": ["spotify.local", "localhost"]
  },
  "configurations": {
    "production": {
      "buildTarget": "angular-spotify:build:production"
    }
  }
},
```

### Run the application
Once the configurations are saved, you can initialize the application.
1. Install the required Node dependencies. Due to the project structure, it is necessary to bypass potential peer dependency conflicts by running:
    ```shell
    npm install --legacy-peer-deps
    ```
   _Note: if the above command fails, you can use `npm install --force`._
2. Start the development server:
    ```shell
    npm start
    ```
3. Open your browser and navigate to `https://<your_local_ip>:4200/` to verify the application is running and accept the self-signed SSL certificate warning if prompted.

### Using the provided test suite
The tool includes a comprehensive test suite designed to evaluate the application's core functionality. To configure and execute these tests, follow the procedures outlined below.

**Test Environment Setup**
Before running the suite, you must configure the base testing classes to match your local environment.
1. Copy the `BaseTest` and `WebDriverFactory` classes provided in the `ext-test-classes` module.
2. Open the `BaseTest` class in your preferred IDE.
3. Update the `baseUrl` variable and update it with the Redirect URI previously configured in the Spotify Developer Dashboard.
4. In the `authentication` function within the same class. Replace the `"redacted"` placeholder with the email address associated with your Spotify Premium account.

To run individual tests or test groups from the `test-suite` directory, perform the following steps:
1. Select a target test area from the suite (eg: **area-1-sidebar**).
2. Choose a specific test case within that area (eg: **tc-side-01**).
3. Copy all class files from the chosen test case directory into your designated test execution module.
4. Open the `generator-config.json` file located at the root of the project.
5. Update the mutations key by replacing its current value with the contents of the provided `mutations.json` file, as detailed in the primary project README.

Once these configurations are complete, you can initiate the testing tool using the standard execution commands outlined in the main README documentation.
# AutomationFramework-Rajat

This project is a Java-based testing framework that uses Maven for dependency management and TestNG for testing. It is designed to automate testing processes and generate detailed reports.

## Prerequisites

To set up this project, you need:

- Java 8 or higher
- Maven
- IntelliJ IDEA 2023.3.5 or any other preferred IDE
- Git

## Setup

1. Clone the repository using Git:
**git clone https://github.com/sumitrsystems/AutomationFramework-Rajat.git**
2. Import the project into IntelliJ IDEA or your preferred IDE.
3. Make sure that the project is recognized as a Maven project.
4. Build the project using Maven.

## Running Tests

Tests can be run in two ways:

1. **Through Maven:** You can run the tests through the command line by navigating to the project directory and running the `mvn test` command.

2. **Through TestNG:** If you are using an IDE like IntelliJ IDEA or Eclipse, you can run the tests through the `testng.xml` file. Here's how you can do it:

   - Open the `testng.xml` file in your IDE.
   - Right-click anywhere in the file.
   - Click on `Run 'testng.xml'`.
   
   This will run all the test methods defined in the `testng.xml` file.

Remember to ensure that all your dependencies are correctly installed and that your environment variables are set up correctly before running the tests.

## Data Providers

This project uses both Excel and JSON data providers for test data:

- The Excel data is read from an Excel file located at `src/main/java/data/testdata.xlsx` using the `ExcelDataProvider` class in the `utility` package.
- The JSON data is read from a JSON file located at `src/main/java/data/testdata.json` using the `JsonDataProvider` class in the `utility` package.

  ## Project Object Model (POM)

The `pom.xml` file is the core of any Maven project. It includes project dependencies, build plugins, goals to be achieved, project version, developers, mailing list and more. This file is used by Maven to manage the project's build, reporting, and documentation.

## Listeners

The `TestListener` class in the `utility` package is used to perform actions before and after each test. It also generates logs for each test.

## Reporting

Test reports are generated using ExtentReports. The `ReportUtil` class in the `utility` package is responsible for creating the report and logging the test results. After running the tests, you can find the report in the `extent.html` file.

## Contributing

If you are interested in contributing to the project, you can clone the repository, make your changes, and submit a pull request. Please read the `CONTRIBUTING.md` file for details on the code of conduct and the process for submitting pull requests.

## License

This project is licensed under the MIT License. The details of the license can be found in the `LICENSE.md` file.

## Running Tests through Jenkins

1. Download the `jenkins.war` file from the official Jenkins website.

2. Navigate to the directory where the `jenkins.war` file is downloaded.

3. Run the following command to start Jenkins:

   ```bash
   java -jar jenkins.war --httpPort=9191

This command will start Jenkins on your local machine at port 9191.  
Open a web browser and go to http://localhost:9191. You should see the Jenkins dashboard.  
If you're running Jenkins for the first time, it will ask you to unlock Jenkins using an admin password. The console log will specify the location of the initial admin password. Copy the password from the mentioned location and paste it in the Jenkins dashboard.  
Install the suggested plugins and create an admin user.  
Once Jenkins is set up, click on New Item from the dashboard to create a new job.  
Enter a name for the job, select Freestyle project and click OK.  
In the job configuration page, go to the Source Code Management section and select Git. Enter the repository URL in the Repository URL field.  
In the Build section, click on Add build step and select Invoke top-level Maven targets.  
In the Goals field, enter test to run the tests.  
Click Save.  
To run the job, click Build Now from the job page.
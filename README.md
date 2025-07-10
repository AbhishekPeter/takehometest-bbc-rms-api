# Take-home Test for BBC RMS API Automation Framework

This is a Cucumber + Java + Rest Assured automation framework for testing the RMS API endpoint provided in the BBC SDET take-home task.

---

## Tech Stack

| Tool            | Purpose                              |
|-----------------|---------------------------------------|
| Java            | Programming language                  |
| Cucumber        | BDD-style testing (Feature files)     |
| Rest Assured    | API testing library                   |
| JUnit           | Test runner                           |
| Maven           | Dependency & project management       |
| SLF4J           | Logging utility                       |

---

## Scenarios Covered

1. Status code is 200 and response time is under 1000ms  
2. All elements have non-null IDs and type = "episode"  
3. Title in each episode is not null or empty  
4. Only one episode has `live = true`  
5. `transmission_start` is before `transmission_end`  
6. `Date` header is present in the response  
7. For an invalid date, API returns 404 with error details

---

## Project Structure

```
bbc-rms-api-test/
├── src/
│   ├── main/java/
│   │   └── utils/            # Logger utility
│   ├── test/java/
│   │   ├── model/            # POJOs for JSON parsing
│   │   ├── runner/           # TestRunner.java
│   │   └── steps/            # StepDefinitions
│   └── resources/
│       └── features/         # api.feature file (scenarios)
├── pom.xml                   # Maven config file
└── README.md                 # You're reading it!
```
---

## How to Run the Tests

### Prerequisites

- Java JDK 8+
- Maven 3.6+
- IDE like IntelliJ IDEA or Eclipse

### Steps

1. Clone or unzip the project
2. Open terminal in the root folder
3. Run:
   ```bash
   mvn clean test
   ```

---

## Reports

After execution, a HTML report is generated at:

```
target/cucumber-reports.html
```

## API Under Test

```
https://testapi.io/api/RMSTest/ibltest
```

## Authors
- Submitted by ABHISHEK PETER
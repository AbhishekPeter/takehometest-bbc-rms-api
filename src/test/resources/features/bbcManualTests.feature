
Feature: RMS API Manual Gherkin Scenarios

  #TC01_Validate the uniqueness of the element Id and episode Id's
  Scenario: 1.Validate uniqueness of element  IDs
    Given I send a GET request to "https://testapi.io/api/RMSTest/ibltest
    Then each element id should be unique

  Scenario: 2. Validate uniqueness of episode ids
    Given I send a GET request to "https://testapi.io/api/RMSTest/ibltest
    Then all episode ids should be unique

  #TC02_Validate that the date header in the response is not older than 24 hours from current system time
  Scenario: 3. Date header is recent and within last 24 hours
    Given  I send a GET request to "https://testapi.io/api/RMSTest/ibltest
    Then the response header "Date" should be present and its value should not be older than 24 hours from now


  #TC03_Validate that the API handles requests with extra unexpected query parameters without any errors
  Scenario: 4. API ignores unexpected query parameters without error
    Given I send a GET request to "https://testapi.io/api/RMSTest/ibltest
    Then the API should respond with status code 200
    And the response should be valid as per the schema

  #TC04_Validate API response contains expected headers (like Content-Type)
  Scenario: 5. Response contains Content-Type header as application/json
    Given  I send a GET request to "https://testapi.io/api/RMSTest/ibltest
    Then the response header "Content-Type" should be "application/json"

  #TC05_Validate behavior for unsupported HTTP methods (POST, PUT, DELETE)
  Scenario: 6. API rejects unsupported HTTP methods with 405
    When I send a POST request to the API endpoint "https://testapi.io/api/RMSTest/ibltest"
    Then the response code should be 405 Method Not Allowed

  Scenario: 7. API rejects unsupported HTTP methods with 405
    When I send a PUT request to the API endpoint "https://testapi.io/api/RMSTest/ibltest"
    Then the response code should be 405 Method Not Allowed

  Scenario: 8. API rejects unsupported HTTP methods with 405
    When I send a DELETE request to the API endpoint "https://testapi.io/api/RMSTest/ibltest"
    Then the response code should be 405 Method Not Allowed

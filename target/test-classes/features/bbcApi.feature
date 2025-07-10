Feature: API Tests for RMS

  Scenario: Scenario 1 - Basic response validation
    Given I send a GET request to the configured endpoint
    Then the response code should be 200
    And response time should be below 1000 milliseconds

  Scenario: Scenario 2 - ID and Episode type validation
    Given I send a GET request to the configured endpoint
    Then all elements should have non-empty id and episode type episode

  Scenario: Scenario 3 - Title field validation for Episode
    Given I send a GET request to the configured endpoint
    Then all episode titles should be non-null and non-empty

  Scenario: Scenario 4 - Only one episode is live validation
    Given I send a GET request to the configured endpoint
    Then only one episode should be live

  Scenario: Scenario 5 - Transmission date validation
    Given I send a GET request to the configured endpoint
    Then transmission start should be before transmission end

  Scenario: Scenario 6 - Response header check Date Validation
    Given I send a GET request to the configured endpoint
    Then response header should contain Date

  Scenario: Scenario 7 - 404 on invalid date - Validation of error fields on invalid path
    Given I send a GET request to the invalid path
    Then the response code should be 404
    And the response should contain "details"
    And the response should contain "http_response_code"

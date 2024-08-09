# Selenium and TestNG Automation Project findings

During the automation process of the API for creating a username, it was observed that the API responses do not include a body, regardless of whether the request was successful or not. Additionally, the API consistently returns an HTTP status code of 200 for all responses, including both successful operations and errors. This lack of distinction in status codes and absence of response bodies make it challenging to accurately determine the outcome of the API requests, as there is no clear indication of success or failure from the responses provided.

During the UI automation process, it was noted that the selectors used in the application were not very descriptive and were often too generic. This made it difficult to accurately target specific elements on the page, leading to potential instability and reduced reliability in the automated tests. The lack of unique and meaningful selectors increases the complexity of the automation script and may result in false positives or negatives during test execution.


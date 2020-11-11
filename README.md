# JUnit 4 & Mockito Examples

Examples of testing with JUnit 4 and Mockito test frameworks.

## Running tests
Run the tests using `mvn test`.

**Note:** The groupId field in the pom.xml will need to be populated for the build to be successful.

## Test frameworks

| Framework | Description                                                                |
| --------- | -------------------------------------------------------------------------- |
| JUnit     | Runs tests and performs assertions to verify the correct results           |
| Mockito   | Mocks expected behaviour of classes integrated with by the unit under test |

## App overview

The method `computeAndStoreResult` in the service is the main entry point. The arguments are: 

* The code (unique identifier) of the test
* The score achieved.

The score will be converted into a percentage and compared against the pass mark. The result will either be `PASS` or `FAIL`. The result will be stored within a data store (e.g. DB) by the DAO integration layer.

**Note:** This is a made-up example which is not intended to be used for production. The example was chosen to enable a range of JUnit assertions and Mockito mocking class to be used.
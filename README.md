# Test Design Kata - Tennis

This is an exercise to develop some heuristics on how to design and write excellent programmer tests.
The program is already implemented, with a set of tests, but the tests violate principles of good test design.

It's up to you to find the flaw in the tests and fix them. For bonus points leave a comment what violation the test had.

The original kata can be found [here](https://sammancoaching.org/kata_descriptions/tennis.html)

## Heuristics

### Be clear rather than clever

Tests exercise behavior in the system.
The key to making tests valuable over a long time is to make them easy to understand.
As such, we should always favor being clear over being clever.
That means we sometimes have to accept a little bit of duplication to aid readability and comprehension of the test.

- Favor DAMP (or moist) over DRY and WET
- Favor dumb tests over smart ones

### Tests should be independent

Each test should be independent of all other tests.
This makes the tests easier to understand and maintain.

- Do not mutate global state in tests
- Do not rely on other tests to run before or after a test
- Do not rely on the order of execution of tests
- Do not rely on state being set by other tests

### Tests should be an example

Tests they should tell a story.
They should be examples of the rules automated by the system.
If done well a test suite can act like technical documentation for anyone trying to understand the code.
To achieve this they should be written in a way that is easy to understand.

- names of test cases should describe what behavior is being tested.
- naming patterns such as `should x given y` highlight the behavior at a glance.
- following the AAA (Arrange/Act/Assert) pattern makes the test easy to understand. This separates setup, execution and verification in the test. Do not mix these steps.
- create helpful failure messages to quickly show what went wrong if a test fails.

### Tests should be small and focussed

Each test should test one thing.
This makes it easier to understand what the test is doing, and if it fails, it clearly shows what is broken.

- Do not test more than one thing in a test
- Avoid multiple assertions in a test

### Test behavior not implementation

Behavior is what makes a system valuable.
Our tests are a great way to document and verify the behavior of the system.
As such we want tests to highlight and test behavior, rather than implementation details.
This also makes the tests more robust to changes in the implementation.

- Express tests in behavioral, not implementation terms
- Start with the assertion you'd like to make, then work backwards to the setup.

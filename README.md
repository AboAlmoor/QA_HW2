# <p align="center">🚀 JUnit 5 Testing Assignment </p>
This repository contains the solution for Homework Assignment #2 for the course Software Testing and Quality Assurance at Najah University.

## 📌 Assignment Overview
This project implements a JUnit 5 test suite that covers the following classes from main.najah.code:
- Calculator.
- Product.
- UserService.
- RecipeBook.

Each test class includes:
- ✅ Tests for valid and invalid input.
- ✅ Use of @DisplayName for descriptive test names.
- ✅ @ParameterizedTest with (@ValuesSource, @CsvSource, @ CsvFileSource). 
- ✅ Timeout tests using assertTimeout.
- ✅ Multiple assertions.
- ✅ Ordered tests using @Order in CalculatorTest.
- ✅ Lifecycle hooks: @BeforeAll, @AfterAll, @BeforeEach, @AfterEach.
- ✅ One intentionally failing test marked with @Disabled and an explanation on how to fix it.
- ✅ A test suite using @Suite to run all tests together.
- ✅ One test class marked with @Execution(ExecutionMode.CONCURRENT) for parallel execution.

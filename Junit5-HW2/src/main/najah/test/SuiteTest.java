package main.najah.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.platform.suite.api.*;

@DisplayName("Suite Test.")
@Suite
@SelectClasses({CalculatorTest.class, ProductTest.class, RecipeBookTest.class, UserServiceSimpleTest.class })
public class SuiteTest {
	void printOnly() {
		System.out.println("All classes will be running.");
	}
}

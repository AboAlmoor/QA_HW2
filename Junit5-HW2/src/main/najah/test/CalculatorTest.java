package main.najah.test;

import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import main.najah.code.Calculator;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Tests.")
@TestMethodOrder(OrderAnnotation.class)
public class CalculatorTest {
	
	Calculator calculator; 
  
    @BeforeAll
    static void beforeAllCal() {
        System.out.println("Start Calculator Test. \n");
    }
    
    @AfterAll 
    static void afterAllCal() {
        System.out.println("All Calculator Tests Completed. \n");
    } 

    @BeforeEach
    void setUpCal() throws Exception {
    	calculator = new Calculator();
        System.out.println("Test setup complete.");
    }
    
    @AfterEach
    void tearDownCal() {
        System.out.println("After Calculator Test Method. \n");
    }


	@Test
	@Order(1)
	@DisplayName("Addition: Valid and Invalid addition.")
	void testAdd() {
		System.out.println("Perform the addition operation.");
		assertEquals(10, calculator.add(2,3,5));    //valid
		assertEquals(0, calculator.add());          //valid
		assertEquals(5, calculator.add(2,3));    //valid
		assertEquals(100, calculator.add(70,30));          //valid
		//assertEquals(5, calculator.add(3,1));       //invalid
	}
	
	@Test
	@Order(2)
	@DisplayName("Division: Valid and Invalid division.")
	void testDivide() {
		System.out.println("Perform the division operation.");
		assertEquals(5, calculator.divide(10,2));   //valid
		assertEquals(3, calculator.divide(6, 2));   //valid
		assertEquals(10, calculator.divide(20,2));   //valid 
		assertEquals(50, calculator.divide(100, 2));   //valid
		//assertEquals(4, calculator.divide(8, 8));   //invalid
	}
	
	@Test
	@Order(3)
	@DisplayName("Division: Divide by zero should throw exception.")
	void testDivideByZero() {
		System.out.println("Perform the division by zero operation.");
		assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
	}
	
    @ParameterizedTest
    @Order(4)
    @DisplayName("Factorial: Positive inputs.")
    @ValueSource(ints = {0, 1, 5, 6})
    void testFactorial(int input) {
    	System.out.println("Perform factorization on positive inputs.");
    	System.out.println("Input value= " + input);
    	assertTrue(calculator.factorial(input) > 0);
    }
    
    @Test
    @Order(5)
    @DisplayName("Factorial: Negative input should throw exception.")
    void testFactorialNegative() {
    	System.out.println("Perform factorization on negative inputs.");
    	assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-1));
    }
    
    @Test
    @Timeout(1)
    @Order(6)
    @DisplayName("Timeout Test: Ensure factorial runs within 1 second.")
    void testFactorialPerformance() {
    	System.out.println("Check time out.");
        calculator.factorial(10);
    }
    
     
    //We want factorial to apply the number= 3.
    //The correct result should be 6 but the result was 9, and this is called an intentional error.
    @Test
    @Disabled("Fix implementation.")
    @DisplayName("Disabled Test: wrong result.")
    void testDisabled() {
    	System.out.println("Use the disabled.");
    	assertEquals(9, calculator.factorial(3)); 
    }
    
    
}
package main.najah.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import main.najah.code.Product;
import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("Product Tests.")
public class ProductTest {

    Product product; 
 
    @BeforeAll
    static void initAllPro() {
        System.out.println("Initial Product Test. \n");
    }

    @AfterAll
    static void tearDownAllPro() {
        System.out.println("All Product Test Done. \n");
    }

    @BeforeEach
    void setUpPro() throws Exception {
        product = new Product("TestProduct", 1000);
        System.out.println("Before Product Test Method.");
    }

    @AfterEach
    void tearDownPro() {
        System.out.println("After Product Test Method.\n");
    }

    @Test
    @Timeout(1)
    @DisplayName("Get name: Valid product with time out.")
    void getNameValid() {
    	System.out.println("Get name, valid product.");
        assertEquals("TestProduct", product.getName()); 
        
    }
    
    @Test
    @DisplayName("Get price: Valid product.")
    void getPriceValid() {
    	System.out.println("Get price, valid product.");
        assertEquals(1000, product.getPrice());  
        
    }
    
    @Test
    @DisplayName("Get Discount: Valid product.")
    void getDiscountValid() {
    	System.out.println("Get discount, valid product.");
        assertEquals(0, product.getDiscount());  
        
    }

    @Test
    @DisplayName("Invalid product because negative price should throw exception.")
    void testNegativePrice() {
    	System.out.println("Invalid product because negative price.");
        assertThrows(IllegalArgumentException.class, () -> new Product("Laptop", -500));
    }

    @ParameterizedTest
    @DisplayName("Apply Discount: Valid discount values.")
    @CsvSource({"0,1000", "10,900", "20,800", "50,500"}) 
    void testApplyDiscount(double discount, double expectedPrice) {
    	System.out.println("Valid discount values.");
    	System.out.println("discount= " +discount);
        product.applyDiscount(discount);
        assertEquals(expectedPrice, product.getFinalPrice());
    }

    @Test
    @DisplayName("Apply Discount: Invalid discount should throw exception.")
    void testInvalidDiscount() {
    	System.out.println("Invalid discount value.");
        assertThrows(IllegalArgumentException.class, () -> product.applyDiscount(-10));
        assertThrows(IllegalArgumentException.class, () -> product.applyDiscount(60));
    }
 
}

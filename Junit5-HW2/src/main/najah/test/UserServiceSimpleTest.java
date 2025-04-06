package main.najah.test;

import org.junit.jupiter.api.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import main.najah.code.UserService;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("User Service Simple Test.")
@TestMethodOrder(OrderAnnotation.class)
public class UserServiceSimpleTest {
	  
	UserService userService;
     
	@BeforeAll
    static void beforeAllUser() {
        System.out.println("Initial User Service Test. \n");
    }
    
    @AfterAll 
    static void afterAllUser() {
        System.out.println("All User Service Tests Completed. \n");
    }

    @BeforeEach 
    void setupUser() throws Exception {
        userService = new UserService();
        System.out.println("Before User Service Test Method.");
    }
    
    @AfterEach
    void tearDownUser() {
        System.out.println("After User Service Test Method. \n");
    }
	
    @ParameterizedTest
    @Order(1)
    @DisplayName("Email Validation: Different email formats.") 
    @ValueSource(strings = {"ameersaleh@gmail.com", "abd@gmail.edu", "amro@123.com"})
    void testEmailValidation(String email) {
    	System.out.println("Emails Valid.");
    	System.out.println("Emails= "+ email);
        boolean expected = true;
        assertEquals(expected, userService.isValidEmail(email));
    }
    
    @ParameterizedTest 
    @Order(2)
    @DisplayName("Email Invalidation: Different email formats.")
    @ValueSource(strings = {"ameersaleh#gmail.com", "abd-gmail.edu", "amro_123.com"})
    void testEmailInvalidation(String email) {
    	System.out.println("Emails Invalid.");
    	System.out.println("Email= "+ email);
        boolean expected = false;
        assertEquals(expected, userService.isValidEmail(email));
    }
    
    @Test
    @Order(3)
    @DisplayName("Authentication: Valid information.")
    void testValidAuthentication() {
    	System.out.println("Valid information.");
        assertTrue(userService.authenticate("admin", "1234"));
    }
    
    @Test  
    @Order(4)
    @DisplayName("Authentication: Invalid information.")
    void testInvalidAuthentication() {
    	System.out.println("Invalid inforamtion.");
        assertFalse(userService.authenticate("user", "wrongpass"));
    }
    
    @Test
    @Order(5)
    @Timeout(1)
    @DisplayName("Timeout: Validate email.")
    void testEmailTimeout() {
    	System.out.println("Use Time out.");
        assertTrue(userService.isValidEmail("user@mail.com"));
    }
    
}
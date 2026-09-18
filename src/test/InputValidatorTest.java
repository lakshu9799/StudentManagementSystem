// tests/InputValidatorTest.java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    @Test
    void testValidInputs() {
        assertTrue(InputValidator.isValidId("ID-123"), "Valid alphanumeric ID");
        assertTrue(InputValidator.isValidAge("20"), "Valid age within range");
        assertTrue(InputValidator.isValidEmail("test.user@example.com"), "Valid email format");
        assertTrue(InputValidator.isValidMarks("100"), "Valid marks");
    }

    @Test
    void testInvalidInputs() {
        assertFalse(InputValidator.isValidId(""), "Empty ID is invalid");
        assertFalse(InputValidator.isValidAge("-5"), "Negative age is invalid");
        assertFalse(InputValidator.isValidAge("abc"), "Non-numeric age is invalid");
        assertFalse(InputValidator.isValidEmail("no-at-symbol"), "Missing @ invalid email");
        assertFalse(InputValidator.isValidMarks("101"), "Marks above 100 invalid");
        assertFalse(InputValidator.isValidMarks("-1"), "Negative marks invalid");
    }
}

// tests/StudentTest.java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    void testStudentCreationAndGetters() {
        // Assumed constructor: Student(String id, String name, int age, String gender, String email)
        Student s = new Student("ID001", "Alice", 20, "F", "alice@example.com");
        assertEquals("ID001", s.getId(), "ID should match");
        assertEquals("Alice", s.getName(), "Name should match");
        assertEquals(20, s.getAge(), "Age should match");
        assertEquals("F", s.getGender(), "Gender should match");
        assertEquals("alice@example.com", s.getEmail(), "Email should match");
    }
    
    @Test
    void testStudentToStringNotNull() {
        Student s = new Student("ID002", "Bob", 22, "M", "bob@example.com");
        assertNotNull(s.toString(), "toString() should not be null");
        assertTrue(s.toString().contains("ID002"), "toString should contain ID");
    }
}

// tests/StudentManagerTest.java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class StudentManagerTest {
    private StudentManager manager;

    @BeforeEach
    void setup() {
        manager = new StudentManager();
    }

    @Test
    void testAddAndViewStudents() {
        Student s1 = new Student("S01", "Charlie", 18, "M", "charlie@example.com");
        Student s2 = new Student("S02", "Dana", 19, "F", "dana@example.com");
        manager.addStudent(s1);
        manager.addStudent(s2);
        assertEquals(2, manager.getAllStudents().size(), "Should have 2 students");
        assertTrue(manager.getAllStudents().contains(s1), "List should contain Charlie");
        assertTrue(manager.getAllStudents().contains(s2), "List should contain Dana");
    }

    @Test
    void testFindAndDeleteStudent() {
        Student s = new Student("S03", "Eve", 20, "F", "eve@example.com");
        manager.addStudent(s);
        Student found = manager.findStudentById("S03");
        assertNotNull(found, "Existing student should be found");
        assertEquals("Eve", found.getName(), "Found student name matches");
        // Delete and verify removal
        manager.deleteStudent("S03");
        assertNull(manager.findStudentById("S03"), "Deleted student should not be found");
        assertEquals(0, manager.getAllStudents().size(), "List should be empty after deletion");
    }

    @Test
    void testUpdateStudent() {
        Student original = new Student("S04", "Frank", 21, "M", "frank@example.com");
        manager.addStudent(original);
        // Assume updateStudent replaces the student info for given ID
        Student updated = new Student("S04", "Franklin", 22, "M", "franklin@example.com");
        manager.updateStudent("S04", updated);
        Student fetched = manager.findStudentById("S04");
        assertEquals("Franklin", fetched.getName(), "Name should be updated");
        assertEquals(22, fetched.getAge(), "Age should be updated");
        assertEquals("franklin@example.com", fetched.getEmail(), "Email should be updated");
    }

    @Test
    void testSearchNonexistent() {
        assertNull(manager.findStudentById("UNKNOWN"), "Searching unknown ID should return null");
    }
}

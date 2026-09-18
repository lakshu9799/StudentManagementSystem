// tests/FileManagerTest.java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.nio.file.Files;
import java.util.List;

class FileManagerTest {
    private static final String TEST_FILE = "test_students.txt";
    private List<Student> students;

    @BeforeEach
    void setup() throws Exception {
        // Prepare some student data
        Student s1 = new Student("T01", "Gina", 23, "F", "gina@example.com");
        Student s2 = new Student("T02", "Henry", 24, "M", "henry@example.com");
        students = List.of(s1, s2);
        // Ensure no leftover file
        Files.deleteIfExists(new File(TEST_FILE).toPath());
    }

    @AfterEach
    void cleanup() throws Exception {
        Files.deleteIfExists(new File(TEST_FILE).toPath());
    }

    @Test
    void testSaveAndLoadStudents() throws Exception {
        // Save the list to a file
        FileManager.saveStudents(students, TEST_FILE);
        // Load from file
        List<Student> readStudents = FileManager.loadStudents(TEST_FILE);
        assertEquals(2, readStudents.size(), "Should read back 2 students");
        assertEquals("T01", readStudents.get(0).getId(), "First student ID should match");
        assertEquals("T02", readStudents.get(1).getId(), "Second student ID should match");
    }
}

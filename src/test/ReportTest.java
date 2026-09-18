// tests/ReportTest.java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ReportTest {
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testGenerateReportOutput() {
        Student s = new Student("R01", "Ivy", 25, "F", "ivy@example.com");
        Marks m = new Marks(80, 85, 90);
        // Assume generateReport prints to System.out
        Report.generateReport(s, m);
        String output = outContent.toString();
        assertTrue(output.contains("ID: R01"), "Report should contain student ID");
        assertTrue(output.contains("Name: Ivy"), "Report should contain student name");
        assertTrue(output.contains("Total:"), "Report should mention total");
        assertTrue(output.contains("Percentage:"), "Report should mention percentage");
        assertTrue(output.contains("Grade:"), "Report should mention grade");
    }
}


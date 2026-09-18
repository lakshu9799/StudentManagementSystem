// tests/MarksTest.java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class MarksTest {
    @Test
    void testTotalAndPercentageAndGrade() {
        // Assume constructor: Marks(int m1, int m2, int m3)
        Marks marks = new Marks(85, 90, 95);
        assertEquals(270, marks.getTotal(), "Total should be sum of marks");
        assertEquals(90.0, marks.getPercentage(), 0.01, "Percentage should be average score");
        assertEquals("A", marks.getGrade(), "Grade should be A for 90%");
    }

    @Test
    void testGradeBoundaries() {
        Marks marksA = new Marks(90, 90, 90);
        assertEquals("A", marksA.getGrade(), "90% should be grade A");
        Marks marksB = new Marks(80, 80, 80);
        assertEquals("B", marksB.getGrade(), "80% should be grade B");
        Marks marksF = new Marks(50, 50, 50);
        assertEquals("F", marksF.getGrade(), "50% should be grade F (fail)");
    }
}

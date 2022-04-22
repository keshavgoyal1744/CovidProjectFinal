package prj5;

public class CompareByAlphaTest extends student.TestCase {
    /**
     * This is the private field for CompareByAlpha test class
     */
    private CompareByAlpha alphaTest;

    /**
     * THis is the setUp method
     */
    public void setUp() {
        alphaTest = new CompareByAlpha();
    }


    /**
     * Testing the compare method
     */
    public void testCompare() {
        Race asian = new Race("Asian", 10, 5);
        Race white = new Race("White", 10, 5);
        assertEquals(alphaTest.compare(asian, white), -22);
        assertEquals(alphaTest.compare(white, asian), 22);
        assertEquals(alphaTest.compare(white, white), 0);

    }
}

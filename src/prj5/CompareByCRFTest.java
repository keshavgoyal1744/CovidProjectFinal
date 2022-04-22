package prj5;

/**
 * This is the test class for the CompareByCFR class
 * 
 * @author Keshav Goyal, Sharanya Pathakota, Gabriel Holder
 * @version 4/22/2022
 *
 */
public class CompareByCRFTest extends student.TestCase {
    /**
     * This is the private field for testing
     */
    private CompareByCFR test;

    /**
     * THis is the setUp method
     */
    public void setUp() {
        test = new CompareByCFR();
    }


    /**
     * Testing the compare method
     */
    public void testCompare() {
        Race asian = new Race("asian", 10, 2);
        Race latinx = new Race("latinx", 10, 5);

        assertEquals(test.compare(asian, latinx), -1);
        assertEquals(test.compare(latinx, asian), 1);
        assertEquals(test.compare(latinx, latinx), 0);
    }
}

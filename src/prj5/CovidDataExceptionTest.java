package prj5;

public class CovidDataExceptionTest extends student.TestCase {
    /**
     * This is the private field
     */
    private CovidDataException test;

    /**
     * This is the setUp method to instantiate the private field
     */
    public void setUp() {
        test = new CovidDataException("message");

    }


    /**
     * This is the test method which will display the text message to test the
     * CovidDataException class
     */
    public void test1() {
        assertEquals("message", test.getMessage());

    }
}

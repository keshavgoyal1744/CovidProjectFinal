package prj5;

/**
 * This is the testing class for the race class
 * 
 * @author Keshav Goyal, Sharanya Pathakota, Gabriel Holder
 * @version 4/22/2022
 *
 */
public class RaceTest extends student.TestCase {

    private Race raceNorm; // has all params
    private Race raceNoCases; // has na cases
    private Race raceNoDeaths; // has na deaths
    private Race raceNoBoth; // has na for both

    /**
     * This is the setUp method for the testing class
     */
    public void setUp() {
        raceNorm = new Race("white", 5, 2);
        raceNoCases = new Race("white", -1, 2);
        raceNoDeaths = new Race("white", 5, -1);
        raceNoBoth = new Race("white", -1, -1);
    }


    /**
     * Testing the getRatio method
     */
    public void testGetRatio() {
        // Tests if all params present
        assertEquals(raceNorm.getRatio(), 40, 0);

        // Tests if cases are below 0
        assertEquals(raceNoCases.getRatio(), -1, 0);

        // Tests if deaths are below 0
        assertEquals(raceNoDeaths.getRatio(), -1, 0);

        // Tests if both are below 0
        assertEquals(raceNoBoth.getRatio(), -1, 0);

    }


    /**
     * Testing the toString method
     */
    public void testToString() {
        assertEquals(raceNorm.toString(), "white: 5 cases, 40% CFR");
    }


    /**
     * Testing the equals method
     */

    public void testEquals() {
        // Tests if obj is null
        assertFalse(raceNorm.equals(null));
        // Tests if comparing to itself
        assertTrue(raceNorm.equals(raceNorm));
        // Tests if comparing to different class
        assertFalse(raceNorm.equals("otherClass"));
        // Tests if all params are same
        assertTrue(raceNorm.equals(new Race("white", 5, 2)));
        // Tests if all same except name
        assertFalse(raceNorm.equals(new Race("black", 5, 2)));
        // Tests if all same except cases
        assertFalse(raceNorm.equals(new Race("white", 2, 2)));
        // Tests if all same except deaths
        assertFalse(raceNorm.equals(new Race("white", 5, 1)));
    }


    /**
     * Testing the compareTo method
     */
    public void testCompareTo() {
        // Tests if left ratio is greater than right ratio
        assertEquals(raceNorm.compareTo(raceNoDeaths), 1);
        // Tests if left ratio is less than right ratio
        assertEquals(raceNoDeaths.compareTo(raceNorm), -1);
        // Tests if left ratio is equal to right ratio
        assertEquals(raceNorm.compareTo(new Race("white", 5, 2)), 0);
    }

}

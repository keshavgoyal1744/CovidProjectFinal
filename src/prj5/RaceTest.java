package prj5;

public class RaceTest extends student.TestCase {
    
    private Race raceNorm; //has all params
    private Race raceNoCases; //has na cases
    private Race raceNoDeaths; //has na deaths
    private Race raceNoBoth; //has na for both
    
    public void setUp() {
        raceNorm = new Race("white", 5, 2);
        raceNoCases = new Race("white", -1, 2);
        raceNoDeaths = new Race("white", 5, -1);
        raceNoBoth = new Race("white", -1, -1);
    }
    
    public void testGetRatio() {
        //Tests if cases are below 0
        assertEquals(raceNoCases.getRatio(), -1);
        
       //Tests if deaths are below 0
        assertEquals(raceNoDeaths.getRatio(), -1);
        
       //Tests if both are below 0
        assertEquals(raceNoBoth.getRatio(), -1);
        
        //Tests if all params present
        assertEquals(raceNorm.getRatio(), 2);
    }
    
    public void testToString() {
        assertEquals(raceNorm.toString(), "white: 5 cases, 40% CFR");
    }
    
    public void testEquals() {
        //Tests if obj is null
        assertFalse(raceNorm.equals(null));
        //Tests if comparing to itself
        assertTrue(raceNorm.equals(raceNorm));
        //Tests if comparing to different class
        assertFalse(raceNorm.equals("otherClass"));
        //Tests if all params are same
        assertTrue(raceNorm.equals(new Race("white", 5, 2)));
        //Tests if all same except name
        assertFalse(raceNorm.equals(new Race("black", 5, 2)));
        //Tests if all same except cases
        assertFalse(raceNorm.equals(new Race("white", 2, 2)));
        //Tests if all same except deaths
        assertFalse(raceNorm.equals(new Race("white", 5, 1)));
    }
    
    public void testCompareTo() {
        //Tests if left ratio is greater than right ratio
        assertEquals(raceNorm.compareTo(raceNoDeaths), 1);
        //Tests if left ratio is less than right ratio
        assertEquals(raceNoDeaths.compareTo(raceNorm), -1);
        //Tests if left ratio is equal to right ratio
        assertEquals(raceNorm.compareTo(new Race("white", 5, 2)), 0);
    }

}

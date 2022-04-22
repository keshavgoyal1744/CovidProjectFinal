package prj5;

public class StateTest extends student.TestCase {
    
    private State state;
    
    public void setUp() {
        LinkedList<Race> races = new LinkedList<Race>();
        races.add(new Race("white", 5, 2));
        races.add(new Race("black", 5, 2));
        state = new State("DC", races);
    }
    
    public void testToString() {
        assertEquals(state.toString(), "DC, [white: 5 cases, 40% CFR, black: 5 cases, 40% CFR]");
    }
    
    public void testSortAlpha() {
        //assertEquals(state.SortAlpha({"white", "black",  "asian"}, 0, 2), "");
    }
    
    public void testSortCFR() {
        //assertEquals(state.SortAlpha({"white", "black",  "asian"}, 0, 2), "");
    }
    
    public void testEquals() {
        
    }

}

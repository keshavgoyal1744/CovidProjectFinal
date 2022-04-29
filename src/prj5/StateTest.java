package prj5;

/**
 * This is the testing class for the State class
 * 
 * @author Keshav Goyal, Sharanya Pathakota, Gabriel Holder
 * @version 4/21/2022
 *
 */
public class StateTest extends student.TestCase {

    private State state;
    private LinkedList<Race> races;

    /**
     * This is the setUp method for the test class
     */
    public void setUp() {
        races = new LinkedList<Race>();
        races.add(new Race("asian", 10, 5));
        races.add(new Race("white", 10, 6));
        races.add(new Race("latinx", 10, 2));
        races.add(new Race("black", 10, 8));
        state = new State("MD", races);
    }


    /**
     * Testing the getName method
     */
    public void testGetName() {
        assertEquals(state.getName(), "MD");
    }


    /**
     * Testing the getRace method
     */
    public void testGetRace() {
        assertEquals(state.getRace().toString(),
            "[asian: 10 cases, 50% CFR, white: 10 cases, 60% CFR, "
                + "latinx: 10 cases, 20% CFR, black: 10 cases, 80% CFR]");
        state.setRace(races);
    }


    /**
     * Testing the toString method
     */
    public void testToString() {
        assertEquals(state.toString(), "MD, [asian: 10 cases, 50% CFR, "
            + "white: 10 cases, 60% CFR, latinx: 10 cases, 20% CFR, "
            + "black: 10 cases, 80% CFR]");
    }


    /**
     * Testing the equals method
     */
    public void testEquals() {
        assertTrue(state.equals(state));
        State nullState = null;
        assertFalse(state.equals(nullState));
        Object test = new Object();
        assertFalse(state.equals(test));
        State newState = new State("MD", races);
        assertTrue(state.equals(newState));
        newState = new State("VA", races);
        assertFalse(state.equals(newState));
        LinkedList<Race> race1 = new LinkedList<Race>();
        races.add(new Race("N/a", 10, 5));
        races.add(new Race("Black", 10, 6));
        newState = new State("VA", race1);
        assertFalse(state.equals(newState));
        newState = new State("MD", race1);
        assertFalse(state.equals(newState));
    }


    /**
     * Testing the sortAlpha method
     */
    public void testSortAlpha() {
        String[] array4 = { "B", "A", "C", "Z", "M", "F", "T" };
        state.sortAlpha(array4, 0, 6);
        assertEquals(state.getName(), "MD");
    }


    /**
     * Testing the SortByCFR method
     */
    public void testSortByCFR() {
        int[] array = { 1, 5, 7 };
        state.sortByCFR(array, 0, 2);
        int[] array2 = { 6, 7, 1, 0, -1 };
        state.sortByCFR(array2, 0, 4);
        assertEquals(state.getName(), "MD");

    }

}

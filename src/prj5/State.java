package prj5;

/**
 * This is the state class and it deals with getting the name of the state. This
 * class also helps in sorting the states in alphabetical order and on the basis
 * of their CFR.
 * 
 * @author Keshav Goyal, Sharanya Pathakota, Gabriel Holder
 * @version 4/21/2022
 *
 */
public class State {
    private String name;
    private LinkedList<Race> race;

    /**
     * Default Constructor of State class
     * 
     * @param name
     *            is the parameter for the name of the state
     * @param race
     *            is the LinnkedList of type Race
     */
    public State(String name, LinkedList<Race> race) {

        this.name = name;
        this.race = race;
    }


    /**
     * This method will return the name of the state
     * 
     * @return will return the name of the state
     */
    public String getName() {

        return this.name;
    }


    /**
     * This method will set the list to a different one
     * 
     * @param other
     *            is the parameter we have set the Race to
     */
    public void setRace(LinkedList<Race> other) {
        race = other;
    }


    /**
     * This method will return the list of the race
     * 
     * @return will return the list of races
     */
    public LinkedList<Race> getRace() {

        return this.race;
    }


    /**
     * This method generates a string representation
     * 
     * @return will return the string as name of the state, list of race
     */
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append(name + ", " + race);
        return builder.toString();
    }


    /**
     * Private Sorting method which will help us to sort the data of ethnicity
     * names i.e. raceNames in alphabetical order i.e. in ascending order. This
     * method will be called in SortAlpha method
     * 
     * @param ethnicityName
     *            is the name of the ethnicity
     * @param nameArray
     *            is the array of all the names of the ethnicities.
     * @param begin
     *            is the first position of the array to start sorting from.
     * @param end
     *            is the last position of the array to end sorting.
     */
    private void insertionSortAscending(
        String ethnicityName,
        String[] nameArray,
        int begin,
        int end) {
        int index = end;

        while ((index >= begin) && (ethnicityName.compareTo(
            nameArray[index])) == -1) {
            nameArray[index + 1] = nameArray[index];
            index--;
        }

        nameArray[index + 1] = ethnicityName;
    }


    /**
     * This method uses insertion sort from above and sorts the states in
     * alphabetical order.
     * 
     * @param names
     *            is the array of names of the states that we have to sort in
     *            alphabetical order
     * @param first
     *            is the first positon of the array to start sorting from.
     * @param last
     *            is the last positon of the array to end sorting.
     */
    public void sortAlpha(String[] names, int first, int last) {

        for (int i = first; i <= last; i++) {
            insertionSortAscending(names[i], names, first, i - 1);
        }
    }


    /**
     * Sorting method to arrange CRF values in descending order
     * 
     * @param valueOfCFR
     *            is the value of the CFR
     * @param valuesArray
     *            is the array of all the CFR values
     * @param begin
     *            is the first positon of the array to start sorting from.
     * @param end
     *            is the last positon of the array to end sorting.
     */
    private void insertionSortDescending(
        int valueOfCFR,
        int[] valuesArray,
        int begin,
        int end) {

        int index = end;
        while ((index >= begin) && (valueOfCFR < valuesArray[index])) {
            valuesArray[index] = valuesArray[index + 1];
            index--;
        }
        valuesArray[index + 1] = valueOfCFR;
    }


    /**
     * This method uses insertion sort Descending and sorts the data on the
     * basis of CFR in descending order
     * 
     * @param values
     *            is the CFR values in the array.
     * @param first
     *            is the first positon of the array to start sorting from.
     * @param last
     *            is the last positon of the array to end sorting.
     */
    public void sortByCFR(int[] values, int first, int last) {

        for (int i = first; i <= last; i++) {
            insertionSortDescending(values[i], values, first, i - 1);
        }
    }


    /**
     * This method compares two state objects and returns true if they are equal
     * in all respects.
     * 
     * @param obj
     *            is the parameter of type Object which will be checked if its
     *            equal to a state or no.
     * @return will return true if the states are equal else will return false
     */
    public boolean equals(Object obj) {
        // Check if we are comparing the same object
        if (this == obj) {
            return true;
        }

        // Return false if the input object is null
        if (obj == null) {
            return false;
        }

        // Check if both objects belong to same class
        if (this.getClass() == obj.getClass()) {
            State state = (State)obj;
            // If name of the state and the list of race is equal then the two
            // states are equal.
            if (this.getName().equals(state.getName()) && this.getRace().equals(
                state.getRace())) {
                return true;
            }
        }
        return false;
    }
}

package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class reads the input files and begins the GUIWindow
 * 
 * @author Keshav Goyal, Sharanya Pathakota, Gabriel Holder
 * @version 4/20/2022
 *
 */
public class FileReader {
    private LinkedList<State> statesList;
    public static final int NUM_STATES = 6;
    public static final String[] RACES = {"white", "black", "latinx", "asian", "other"};

    /**
     * Class constructor that takes one parameter i.e. the name of the file to
     * read from
     * 
     * @param fileName
     *            the name of the file
     * @throws FileNotFoundException
     *             when the file is not found
     */
    public FileReader(String fileName)
        throws FileNotFoundException {

        // Use the List
        statesList = new LinkedList<State>();

        // Scan the File
        Scanner file = new Scanner(new File(fileName));
        String lineRead = file.nextLine();

        while (file.hasNextLine()) {
            LinkedList<Race> races = new LinkedList<Race>();
            lineRead = file.nextLine();
            String[] lineData = lineRead.split(", *");

            // Check for the data and store it in array of the value
            for (int j = 0; j < 5; j++) {
                int numCases = checkNA(lineData[j + 1]);
                int numDeaths = checkNA(lineData[j + 6]);

                // Using the raceName from above and using it for Race class
                Race race = new Race(RACES[j], numCases, numDeaths);
                races.add(race);
            }
            // Adding the data to the state class
            State state = new State(lineData[0], races);
            statesList.add(state);
        }
    }


    /**
     * Getter method for statesList
     * 
     * @return list of the states
     */
    public LinkedList<State> getStates() {

        return statesList;
    }


    /**
     * Helper method that checks if a String is "NA"
     * 
     * @param item
     *            the String that is to be checked which might contain NA
     * @return -1 if the String is "NA" or the integer value of the String
     */
    private int checkNA(String item) {

        if (item.equals("NA")) {
            return -1;
        }
        else {
            return Integer.valueOf(item);
        }
    }

}

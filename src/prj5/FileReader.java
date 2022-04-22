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

    /**
     * Class constructor that takes one parameter i.e. the name of the file to
     * read from
     * 
     * @param fileName
     *            the name of the file
     * @throws FileNotFoundException
     *             when the file is not found
     * @throws CovidDataException
     *             when there is some missing data
     */
    public FileReader(String fileName)
        throws CovidDataException,
        FileNotFoundException {

        // Use the List
        statesList = new LinkedList<State>();

        // Scan the File
        Scanner file = new Scanner(new File(fileName));
        String lineRead = "";
        lineRead = file.nextLine();

        for (int i = 0; i < NUM_STATES; i++) {
            LinkedList<Race> races = new LinkedList<Race>();
            lineRead = file.nextLine();
            String[] lineData = lineRead.split(", *");
            checkMissingData(lineData);

            // Check for the data and store it in array of the value
            for (int j = 0; j < 5; j++) {
                int value1 = checkNA(lineData[j + 1]);
                int value2 = checkNA(lineData[j + 6]);
                String raceName = "";
                if (j == 0) {
                    raceName = "white";
                }
                else if (j == 1) {
                    raceName = "black";
                }
                else if (j == 2) {
                    raceName = "latinx";
                }
                else if (j == 3) {
                    raceName = "asian";
                }
                else {
                    raceName = "other";
                }

                // Using the raceName from above and using it for Race class
                Race race = new Race(raceName, value1, value2);
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
     * Helper method that checks if there is data missing and then throw an
     * exception on the basis of that
     * 
     * @param array
     *            an array of String values obtained from the file which is
     *            being checked
     * @throws CovidDataException
     *             when a line in the file is missing data then throw
     *             DataException
     * 
     */
    private void checkMissingData(String[] array) throws CovidDataException {

        for (int i = 0; i < array.length; i++) {
            if (array[i].isEmpty()) {
                throw new CovidDataException(
                    "There is some data missing from the input file");
            }
        }
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

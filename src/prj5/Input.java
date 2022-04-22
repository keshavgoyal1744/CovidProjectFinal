package prj5;

import java.io.FileNotFoundException;
import prj5.LinkedList.Node;

/**
 * This class takes the input, helps reading file and then execute the code and
 * produces the desired output.
 * 
 * @author Keshav Goyal, Sharanya Pathakota, Gabriel Holder
 * @version 4/21/2022
 *
 */
public class Input {
    /**
     * Main method of ProjectRunner class
     * 
     * @param args
     *            Parameter is the input in the String array format
     * @throws CovidDataException
     *             will display the message of the exception
     * @throws FileNotFoundException
     *             when the file is not found
     */
    public static void main(String[] args) throws 
        FileNotFoundException {
        if (args.length == 1) {
            FileReader reader = new FileReader(args[0]);
            LinkedList<State> listOfStates = reader.getStates();

            Node<State> currentNode = listOfStates.getFirstNode();

            while (currentNode != null) {
                State currentState = currentNode.getData();
                LinkedList<Race> races = currentState.getRace();

                // First printing data by sorting them in alphabetical order
                races = races.sortAlpha(0, 5);
                System.out.println(currentState.getName());
                for (int i = 0; i <= 4; i++) {
                    System.out.println(races.getEntry(i).toString());
                }

                System.out.println("=====");

                // Sorting races on the basis of their CFR in descending order
                races = races.sortByCFR(0, 5);
                for (int i = 0; i <= 4; i++) {
                    System.out.println(races.getEntry(i).toString());
                }
                System.out.println("=====");

                currentNode = currentNode.getNext();
            }
        }
        else {
            new FileReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }
    }
}

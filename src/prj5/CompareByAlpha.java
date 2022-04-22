package prj5;

import java.util.Comparator;

/**
 * @author Keshav Goyal, Sharanya Pathakota, Gabriel Holder
 * @version 4/20/2022
 *
 */
public class CompareByAlpha implements Comparator<Race> {
    /**
     * Compare two Race objects based on alphabetical order
     * 
     * @param left
     *            is the left side of the comparison
     * @param right
     *            is the right side of the comparison which will be compared
     *            to the left one
     * @return -1 if the Left Race precedes the right Race
     *         0 if they have the same alphabetical order
     *         and 1 if the right Race precedes the left Race
     */
    @Override
    public int compare(Race left, Race right) {

        return left.getName().compareTo(right.getName());
    }
}

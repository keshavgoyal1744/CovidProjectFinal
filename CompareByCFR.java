package prj5;

import java.util.Comparator;

/**
 * @author Keshav Goyal, Sharanya Pathakota, Gabriel Holder
 * @version 4/20/2022
 *
 */
public class CompareByCFR implements Comparator<Race> {
    /**
     * Compare two Race objects based on CFR
     * 
     * @param left
     *            is the left side of the comparison
     * @param right
     *            is the right side of the comparison which will be compared
     *            to the left one
     * @return -1 if the CFR of the left Race is less than the right
     *         0 if the CFR's are the same, and in this case it will compare the
     *         names of the races alphabetically
     *         and this method will return 1 if the left CFR is more than the
     *         right CFR
     */
    @Override
    public int compare(Race left, Race right) {

        // Getting both the values in percentage to compare
        double leftCFR = left.getPercentage();
        double rightCFR = right.getPercentage();

        // Compare if Left CFR is less than Right CFR and return -1
        if (leftCFR < rightCFR) {
            return -1;
        }

        // Check if both CFR are equal and then compare on the basis of name of
        // races to break the tie.
        else if (leftCFR == rightCFR) {
            return left.getName().compareTo(right.getName());
        }

        // Compare if Left CFR is more than Right CFR and return 1
        else {
            return 1;
        }
    }
}

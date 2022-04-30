package prj5;

import java.util.Comparator;

/**
 * This is the compare by CFR class which is a helped class that we used in
 * linkedList class for sorting
 * 
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
        double leftCFR = left.getRatio();
        double rightCFR = right.getRatio();

        // Compare if Left CFR is less than Right CFR and return -1
        if (leftCFR < rightCFR) {
            return -1;
        }

        // Check if both CFR are equal and return 0
        else if (leftCFR == rightCFR) {
            return 0;
        }

        // Compare if Left CFR is more than Right CFR and return 1
        else {
            return 1;
        }
    }
}

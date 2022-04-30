package prj5;

// import java.text.DecimalFormat;

/**
 * This class deals with different races and its cases, deaths. This class will
 * also help to calculate the ratio i.e. CFR.
 * 
 * 
 * @author Keshav Goyal, Sharanya Pathakota, Gabriel Holder
 * @version 4/20/2022
 *
 */
public class Race {

    private String raceName;
    private int cases;
    private int deaths;
    /**
     * @param FINAL_PERCENT
     *            is the final number to multiply the ratio to get the
     *            percentage
     */
    public static final int FINAL_PERCENT = 100;

    /**
     * This is the default constructor of the the Race Class.
     * 
     * @param name
     *            is the name of the race whose values we want
     * @param cases
     *            is the number of Covid cases of that particular race
     * @param death
     *            is the number of Covid deaths of that particular race
     */
    public Race(String name, int cases, int death) {

        raceName = name;
        this.cases = cases;
        this.deaths = death;
    }


    /**
     * This method will return the name of the race
     * 
     * @return the name of the race
     */
    public String getName() {

        return this.raceName;
    }


    /**
     * This method returns the number of cases of a particular race
     * 
     * @return the number of cases of that particular race
     */
    public int getCases() {

        return this.cases;
    }


    /**
     * This method returns the number of deaths of a particular race due to
     * Covid
     * 
     * @return the number of deaths of that particular race
     */
    public int getDeaths() {

        return this.deaths;
    }


    /**
     * This method calculates the percentage of death among the number of Covid
     * cases
     * 
     * @return the percentage of death
     *         among Covid Cases in double format
     */
    public double getRatio() {

        // If invalid value is provided return -1
        if (cases < 0 || deaths < 0) {
            return -1;
        }

        // Calculate the ratio i.e CFR 
        double ratio = (((double)deaths / (double)cases)) * FINAL_PERCENT;

        String num = String.format("%,.1f", ratio);

        // Parsing double value from the above string
        return Double.parseDouble((num));
    }


    /**
     * This method generates a string representation of the race: numberOfCases
     * cases, CFR%
     * 
     * @return will return the string of the race name, number of cases and the
     *         CFR percent
     */
    public String toString() {

        // Using string builder to concatentate strings
        StringBuilder builder = new StringBuilder();

        // Taking value of the getPercentage method
        String ratio = String.valueOf(getRatio());
        ratio = ratio.replaceAll("\\.0*$", "");

        // Generating the string as required in given format
        // asian: 5407 cases, 4.7% CFR
        builder.append(raceName + ": " + cases + " cases, " + ratio + "% CFR");
        return builder.toString();
    }


    /**
     * This method compares two objects and returns true if they are equal
     * 
     * @param obj
     *            is the parameter that we have to check if it is equal or not
     * @return will return true if both the objects are equals in all respects
     */
    public boolean equals(Object obj) {

        // Return false when the object is null
        if (obj == null) {
            return false;
        }
        // Return true if both are the same objects
        if (this == obj) {
            return true;
        }
        // If they belong to the same class enter the if statement
        if (this.getClass() == obj.getClass()) {
            Race race = (Race)obj;

            // If all the parameters are same then return true else return false
            if (this.getName().equals(race.getName())) {
                if (this.getCases() == race.getCases()) {
                    if (this.getDeaths() == race.getDeaths()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    /**
     * This method compares the death ratio of one race to another race
     * 
     * @param other
     *            is the race that we have to compare the ratio of to the
     *            default race
     * @return 1 if the death ratio of the left Race is more than the right
     *         -1 if the left death ratio is less than the right death ratio
     *         0 if the death ratios are the equal.
     * 
     */
    public int compareTo(Race other) {

        if (this.getRatio() > other.getRatio()) {
            return 1;
        }
        else if (this.getRatio() < other.getRatio()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}

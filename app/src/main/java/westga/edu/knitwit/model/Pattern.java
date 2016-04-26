package westga.edu.knitwit.model;

/**
 * Pattern Class
 * Created by Kaleigh on 4/25/2016.
 */
public class Pattern {

    private int repeatRows;
    private int patternRepeats;

    /**
     * Constructor
     */
    public Pattern() {

    }

    //Accessor Methods//

    /**
     * Gets the number of rows per pattern repeat.
     * @return the number of rows.
     */
    public int getRepeatRows() {
        return this.repeatRows;
    }

    /**
     * Gets the number of pattern repeats in the pattern.
     * @return the number of pattern repeats.
     */
    public int getPatternRepeats() {
        return this.patternRepeats;
    }

    //Mutator Methods//

    /**
     * Sets the number of rows per pattern repeat.
     * @param repeatRows the number of rows.
     */
    public void setRepeatRows(int repeatRows) {
        this.repeatRows = repeatRows;
    }

    /**
     * Sets the number of pattern repeats in the pattern.
     * @param patternRepeats the number of pattern repeats.
     */
    public void setPatternRepeats(int patternRepeats) {
        this.patternRepeats = patternRepeats;
    }

    /**
     * Returns a string representation of the pattern object.
     * @return a string representation of the pattern object.
     */
    @Override
    public String toString() {
        return this.repeatRows + ", " + this.patternRepeats;
    }

}

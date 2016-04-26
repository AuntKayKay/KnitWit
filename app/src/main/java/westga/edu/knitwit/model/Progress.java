package westga.edu.knitwit.model;

/**
 * Created by Kaleigh on 4/25/2016.
 */
public class Progress {

    public int rowsCompleted;
    public int patternRowsCompleted;
    public int patternRepeatsCompleted;

    /**
     * Constructor
     */
    public Progress() {

    }

    /**
     * Returns the number of pattern repeats remaining.
     * @param patternRepeats the number of pattern repeats.
     * @return the number of pattern repeats remaining.
     */
    public int patternRepeatsRemaining(int patternRepeats) {
        return patternRepeats - this.patternRepeatsCompleted;
    }

    //Accessor Methods//

    /**
     * Gets the number of rows completed.
     * @return the number of rows completed.
     */
    public int getRowsCompleted() {
        return this.rowsCompleted;
    }

    /**
     * Gets the number of pattern rows completed.
     * @return the number of pattern rows completed.
     */
    public int getPatternRowsCompleted() {
        return this.patternRowsCompleted;
    }

    /**
     * Gets the number of pattern repeats completed.
     * @return the number of pattern repeats completed.
     */
    public int getPatternRepeatsCompleted() {
        return this.patternRepeatsCompleted;
    }

    //Mutator Methods//

    /**
     * Sets the number of rows completed.
     * @param rowsCompleted the number of rows completed.
     */
    public void setRowsCompleted(int rowsCompleted) {
        this.rowsCompleted = rowsCompleted;
    }

    /**
     * Sets the number of pattern rows completed.
     * @param patternRowsCompleted the number of pattern rows completed.
     */
    public void setPatternRowsCompleted(int patternRowsCompleted) {
        this.patternRowsCompleted = patternRowsCompleted;
    }

    /**
     * Sets the number of pattern repeats completed.
     * @param patternRepeatsCompleted the number of pattern repeats completed.
     */
    public void setPatternRepeatsCompleted(int patternRepeatsCompleted) {
        this.patternRepeatsCompleted = patternRepeatsCompleted;
    }

    /**
     * Returns a string representation of the progress object.
     * @return a string represenation of the progress object.
     */
    @Override
    public String toString() {
        return this.rowsCompleted + ", " + this.patternRowsCompleted + ", " + this.patternRepeatsCompleted;
    }

}

package westga.edu.knitwit.model;

/**
 * Gauge Class
 * Created by Kaleigh on 4/25/2016.
 */
public class Gauge {

    public int stitchesPerRow;
    public int rowsPerUnit;
    public String unit;

    /**
     *  Constructor
     */
    public Gauge() {

    }

    //Accessor Methods//

    /**
     *  Gets the number of stitches per row.
     *  @return the number of stitches per row.
     */
    public int getStitchesPerRow() {
        return this.stitchesPerRow;
    }

    /**
     * Gets the number of rows per unit.
     * @return the number of rows per unit.
     */
    public int getRowsPerUnit() {
        return this.rowsPerUnit;
    }

    /**
     * Gets the unit of measurement (in/cm).
     * @return the unit of measurement.
     */
    public String getUnit() {
        return this.unit;
    }

    //Mutator Methods//

    /**
     * Sets the number of stitches per row.
     * @param stitchesPerRow the number of stitches per row.
     */
    public void setStitchesPerRow(int stitchesPerRow) {
        this.stitchesPerRow = stitchesPerRow;
    }

    /**
     * Sets the number of rows per unit.
     * @param rowsPerUnit the number of rows per unit.
     */
    public void setRowsPerUnit(int rowsPerUnit) {
        this.rowsPerUnit = rowsPerUnit;
    }

    /**
     * Sets the unit of measurement (in/cm).
     * @param unit the unit of measurement.
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * Returns a string representation of the gauge object.
     * @return a string representation of the gauge object.
     */
    @Override
    public String toString() {
        return this.stitchesPerRow + ", " + this.rowsPerUnit + ", " + this.unit;
    }

}

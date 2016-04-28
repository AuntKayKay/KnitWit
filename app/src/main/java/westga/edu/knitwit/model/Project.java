package westga.edu.knitwit.model;

/**
 * Project Class
 * Created by Kaleigh on 4/25/2016.
 */
public class Project {

    private int projectID;
    private String projectName;
    private String yarn;
    private int needleSize;
    private int gaugeID;
    private int patternID;
    private int progressID;

    /**
     * Constructor
     */
    public Project() {

    }

    //Accessor Methods//

    /**
     * Gets the project name.
     * @return the project name.
     */
    public String getProjectName() {
        return this.projectName;
    }

    /**
     * Gets the yarn.
     * @return the yarn.
     */
    public String getYarn() {
        return this.yarn;
    }

    /**
     * Gets the needle size.
     * @return the needle size.
     */
    public int getNeedleSize() {
        return this.needleSize;
    }

    public int getProjectID() {
        return this.projectID;
    }

    public int getGaugeID() {
        return this.gaugeID;
    }

    public int getPatternID() {
        return this.patternID;
    }

    public int getProgressID() {
        return this.progressID;
    }

    //Mutator Methods//

    /**
     * Sets the project name.
     * @param projectName the project name.
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * Sets the yarn.
     * @param yarn the yarn.
     */
    public void setYarn(String yarn) {
        this.yarn = yarn;
    }

    /**
     * Sets the needle size.
     * @param needleSize the needle size.
     */
    public void setNeedleSize(int needleSize) {
        this.needleSize = needleSize;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public void setGaugeID(int gaugeID) {
        this.gaugeID = gaugeID;
    }

    public void setPatternID(int patternID) {
        this.patternID = patternID;
    }

    public void setProgressID(int progressID) {
        this.progressID = progressID;
    }

    /**
     * Returns a string representation of the project object.
     * @return a string representation of the project object.
     */
    @Override
    public String toString() {
        return this.projectName + ", " + this.yarn + ", " + this.needleSize;
    }

}

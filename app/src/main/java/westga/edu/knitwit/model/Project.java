package westga.edu.knitwit.model;

/**
 * Project Class
 * Created by Kaleigh on 4/25/2016.
 */
public class Project {

    private String projectName;
    private String yarn;
    private double needleSize;

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
        return this.getYarn();
    }

    /**
     * Gets the needle size.
     * @return the needle size.
     */
    public double getNeedleSize() {
        return this.getNeedleSize();
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
    public void setNeedleSize(double needleSize) {
        this.needleSize = needleSize;
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

package westga.edu.knitwit.controller;

import westga.edu.knitwit.model.Gauge;
import westga.edu.knitwit.model.Pattern;
import westga.edu.knitwit.model.Progress;
import westga.edu.knitwit.model.Project;

/**
 * Controller Class
 * Created by Kaleigh on 4/26/2016.
 */
public class Controller {

    private Gauge theGauge;
    private Pattern thePattern;
    private Project theProject;
    private Progress theProgress;

    /**
     * Constructor
     */
    public Controller(){

    }

    //Accessor Methods//

    /**
     * Gets the gauge object.
     * @return the gauge object.
     */
    public Gauge getTheGauge() {
        return this.theGauge;
    }

    /**
     * Gets the pattern object.
     * @return the pattern object.
     */
    public Pattern getThePattern() {
        return this.thePattern;
    }

    /**
     * Gets the project object.
     * @return the project object.
     */
    public Project getTheProject() {
        return this.theProject;
    }

    /**
     * Gets the progress object.
     * @return the progress object.
     */
    public Progress getTheProgress() {
        return this.theProgress;
    }

    //Mutator Methods//

    /**
     * Sets the gauge object.
     * @param theGauge the gauge object.
     */
    public void setTheGauge(Gauge theGauge) {
        this.theGauge = theGauge;
    }

    /**
     * Sets the pattern object.
     * @param thePattern the pattern object.
     */
    public void setThePattern(Pattern thePattern) {
        this.thePattern = thePattern;
    }

    /**
     * Sets the project object.
     * @param theProject the project object.
     */
    public void setTheProject(Project theProject) {
        this.theProject = theProject;
    }

    /**
     * Sets the progress object.
     * @param theProgress the progress object.
     */
    public void setTheProgress(Progress theProgress) {
        this.theProgress = theProgress;
    }


}

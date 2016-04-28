package westga.edu.knitwit.viewcontroller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import westga.edu.knitwit.R;
import westga.edu.knitwit.controller.Controller;
import westga.edu.knitwit.database.KnitDatabase;
import westga.edu.knitwit.model.Pattern;
import westga.edu.knitwit.model.Progress;
import westga.edu.knitwit.model.Project;
/**
 * Stitch Counter View Controller Class
 * Created by Kaleigh on 4/26/2016.
 */
public class stitch_counter_viewcontroller extends AppCompatActivity {

    private Controller myController = new Controller();
    private Project myProject = new Project();
    private Progress myProgress = new Progress();
    private Pattern myPattern = new Pattern();
    private int recordID;
    private int patternID;
    private int projectID;

    private void load(){
        Bundle bundle = getIntent().getExtras();
        this.recordID = bundle.getInt("recordID");
        this.patternID = bundle.getInt("patternID");
        this.projectID = bundle.getInt("projectID");
        Log.i("TAG:: recordID:", "" + this.recordID);
        Log.i("TAG:: patternID:", "" + this.patternID);
        Log.i("TAG:: projectID:", "" + this.projectID);
        this.myProject = this.myController.getTheProject();
        this.myProgress = this.myController.getTheProgress();
        this.myPattern = this.myController.getThePattern();

        // TODO :: GET Project from DB
        //TODO :: GET Pattern from DB
    }

    private void rowCount(){
        // TODO :: SET value to value from DB if it exists
    }

    private void patternRowCount() {
        // TODO :: SET value to value from DB if it exists
    }

    private void repeatsCompleteCount(){
        // TODO :: SET value to value from DB if it exists
    }

    private void repeatsRemainingCount(){
        // TODO :: SET value to value from DB if it exists
    }

    private void addRowButton(){
        Button button = (Button) findViewById(R.id.addRowButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView rowCountTextView = (TextView)
                        findViewById(R.id.rowCount);
                int count = Integer.parseInt(rowCountTextView.toString());
                rowCountTextView.setText(count + 1);
                myProgress.setRowsCompleted(count + 1);
                myProgress.patternRepeatsRemaining(myPattern.getPatternRepeats());
            }
        });
    }

    private void removeRowButton() {
        Button button = (Button) findViewById(R.id.removeRowButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView rowCountTextView = (TextView)
                        findViewById(R.id.rowCount);
                int count = Integer.parseInt(rowCountTextView.toString());
                rowCountTextView.setText(count - 1);
                myProgress.setRowsCompleted(count - 1);
                myProgress.patternRepeatsRemaining(myPattern.getPatternRepeats());
            }
        });
    }

    private void addPatternRowButton() {
        Button button = (Button) findViewById(R.id.addPatterRowButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView rowCountTextView = (TextView)
                        findViewById(R.id.patternRowCount);
                int count = Integer.parseInt(rowCountTextView.toString());
                rowCountTextView.setText(count + 1);
                myProgress.setPatternRowsCompleted(count + 1);
                myProgress.patternRepeatsRemaining(myPattern.getPatternRepeats());
            }
        });
        //TODO:: ADD longClick listener (increase by number of rows in repeat)
    }

    private void removePatternRowButton() {
        Button button = (Button) findViewById(R.id.removePatternRowButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView rowCountTextView = (TextView)
                        findViewById(R.id.patternRowCount);
                int count = Integer.parseInt(rowCountTextView.toString());
                rowCountTextView.setText(count - 1);
                myProgress.setPatternRowsCompleted(count - 1);
                myProgress.patternRepeatsRemaining(myPattern.getPatternRepeats());
            }
        });

        //TODO:: ADD longClick listener (decrease by number of rows in repeat)
    }

    private void saveButton() {
        final KnitDatabase db = new KnitDatabase(this, null, null, 1);
        Button button = (Button) findViewById(R.id.saveButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myController.setTheProgress(myProgress);
                db.addProgressToDB(myProgress);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stitch_counter);
        this.load();
        this.rowCount();
        this.patternRowCount();
        this.repeatsCompleteCount();
        this.repeatsRemainingCount();
        this.addRowButton();
        this.removeRowButton();
        this.addPatternRowButton();
        this.removePatternRowButton();
        this.saveButton();
    }
}
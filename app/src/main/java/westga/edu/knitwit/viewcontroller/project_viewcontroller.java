package westga.edu.knitwit.viewcontroller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import westga.edu.knitwit.R;
import westga.edu.knitwit.controller.Controller;
import westga.edu.knitwit.database.KnitDatabase;
import westga.edu.knitwit.model.Pattern;
import westga.edu.knitwit.model.Project;


/**
 * Project View Controller Class
 * Created by Kaleigh on 4/26/2016.
 */
public class project_viewcontroller extends AppCompatActivity {
    private Controller myController = new Controller();
    private Project myProject= new Project();
    private Pattern myPattern = new Pattern();
    private int recordID;
    private int patternID;
    private int projectID;

    private void name() {
        TextView nameTextView = (TextView)
                findViewById(R.id.nameEditText);
        nameTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (s.length() != 0 ) {
                    myProject.setProjectName(s.toString());
                }
            }
        });
    }

    private void yarn() {
        TextView yarnTextView = (TextView)
                findViewById(R.id.yarnEditText);
        yarnTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (s.length() != 0 ) {
                    myProject.setYarn(s.toString());
                }
            }
        });
    }

    private void sizeSpinner(){
        // TODO :: GET sizeSpinner Data
    }

    private void rowSpinner(){
        // TODO :: GET rowSpinner Data
    }

    private void repeatSpinner(){
        //TODO :: GET repeatSpinner Data
    }

    private void checkAllFields(){
        if (this.myProject != null){
            Button button = (Button) findViewById(R.id.projectButton);
            button.setEnabled(true);
            this.myProject.setGaugeID(recordID);
            this.myProject.setProgressID(0);
            this.myProject.setPatternID(this.patternID);
            KnitDatabase db = new KnitDatabase(this, null, null, 1);
            Log.i("project:", this.myProject.toString());
            Log.i("pattern:", this.myPattern.toString());
            this.myController.setTheProject(this.myProject);
            db.addProjectToDB(this.myProject);
            this.projectID= db.getRecordID(this.myProject);
            this.myController.setThePattern(this.myPattern);
            db.addPatternToDB(this.myPattern);
            this.patternID= db.getRecordID(this.myPattern);
        }
    }

    private void nextScreenProject() {
        checkAllFields();
        //Starts a new Intent
        Intent nextActivity = new Intent(getApplicationContext(), stitch_counter_viewcontroller.class);
        nextActivity.putExtra("recordID", this.recordID);
        nextActivity.putExtra("patternID", this.patternID);
        nextActivity.putExtra("projectID", this.projectID);

        //http://developer.android.com/reference/android/util/Log.html
        Log.i("Send to ", "stitch counter");

        startActivity(nextActivity);
    }

    private void buttonClick() {
        Button button = (Button) findViewById(R.id.projectButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextScreenProject();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project);
        this.name();
        this.yarn();
        this.sizeSpinner();
        this.rowSpinner();
        this.repeatSpinner();
        this.buttonClick();
    }
}

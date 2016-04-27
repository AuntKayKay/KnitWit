package westga.edu.knitwit.viewcontroller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import westga.edu.knitwit.R;
import westga.edu.knitwit.controller.Controller;
import westga.edu.knitwit.model.Gauge;

/**
 * Digital Gauge View Controller Class
 * Created by Kaleigh on 4/26/2016.
 */
public class digital_gauge_viewcontroller extends AppCompatActivity {

    private Controller myController = new Controller();
    private Gauge myGauge = new Gauge();

    private void load(){
        this.myGauge = this.myController.getTheGauge();
        // TODO :: GET Gauge from DB
    }

    private void setStitchesTextView() {
        TextView swatchWidthTextView = (TextView)
                findViewById(R.id.stitchesTextView);
        swatchWidthTextView.setText(this.myGauge.getStitchesPerRow());
    }

    private void setRowsTextView() {
        TextView rowsTextView = (TextView)
                findViewById(R.id.rowsTextView);
        rowsTextView.setText(this.myGauge.getRowsPerUnit());
    }

    private void setWidthTextView() {
        TextView widthTextView = (TextView)
                findViewById(R.id.widthTextView);
        widthTextView.setText(this.myGauge.getSwatchWidth());
    }

    private void setHeightTextView() {
        TextView heightTextView = (TextView)
                findViewById(R.id.heightTextView);
        heightTextView.setText(this.myGauge.getSwatchHeight());
    }

    private void setStitchesGaugeTextView() {
        TextView stitchesGaugeTextView = (TextView)
                findViewById(R.id.stitchesGaugeTextView);
        stitchesGaugeTextView.setText(this.myGauge.getStitchesPerRow()/this.myGauge.getSwatchWidth());
    }

    private void setRowsGaugeTextView() {
        TextView  rowsGaugeTextView = (TextView)
                findViewById(R.id. rowsGaugeTextView);
        rowsGaugeTextView.setText(this.myGauge.getRowsPerUnit()/this.myGauge.getSwatchHeight());
    }

    private void setMeasurementTextView() {
        TextView measurementTextView = (TextView)
                findViewById(R.id.measurementTextView);
        measurementTextView.setText(this.myGauge.getUnit());
    }


    private void nextScreen() {
        //Starts a new Intent
        Intent nextActivity = new Intent(getApplicationContext(), project_viewcontroller.class);

        //http://developer.android.com/reference/android/util/Log.html
        Log.i("Send to ", "Project Layout");

        startActivity(nextActivity);
    }

    private void buttonClick() {
        Button button = (Button) findViewById(R.id.createButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextScreen();
            }
        });
    }

    private void backScreen() {
        //Starts a new Intent
        Intent nextActivity = new Intent(getApplicationContext(), gauge_viewcontroller.class);

        //http://developer.android.com/reference/android/util/Log.html
        Log.i("Send to ", "gauge_calculator Layout");

        startActivity(nextActivity);
    }

    private void buttonClickBack() {
        Button button = (Button) findViewById(R.id.modifyButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backScreen();
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.digital_gauge);
        this.load();
        this.setStitchesTextView();
        this.setRowsTextView();
        this.setWidthTextView();
        this.setHeightTextView();
        this.setStitchesGaugeTextView();
        this.setRowsGaugeTextView();
        this.setMeasurementTextView();
        this.buttonClick();
        this.buttonClickBack();
    }
}

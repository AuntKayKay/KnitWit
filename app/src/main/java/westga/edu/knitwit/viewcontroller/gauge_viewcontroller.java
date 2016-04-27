package westga.edu.knitwit.viewcontroller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import westga.edu.knitwit.R;
import westga.edu.knitwit.controller.Controller;
import westga.edu.knitwit.model.Gauge;

/**
 * Gauge View Controller Class
 * Created by Kaleigh on 4/26/2016.
 */
public class gauge_viewcontroller extends AppCompatActivity {

    private Controller myController = new Controller();
    private Gauge myGauge = new Gauge();

    private void stitches() {
        TextView stitchesTextView = (TextView)
                findViewById(R.id.stitches);
        stitchesTextView.addTextChangedListener(new TextWatcher() {
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
                if (s.length() != 0 && checkInt(s.toString())) {
                    int stitch = parseInt(s.toString());
                    myGauge.setStitchesPerRow(stitch);
                    checkAllFields();
                }
            }
        });
    }

    private void rows() {
        TextView rowsTextView = (TextView)
                findViewById(R.id.rows);
        rowsTextView.addTextChangedListener(new TextWatcher() {
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
                if (s.length() != 0 && checkInt(s.toString())) {
                    int row = parseInt(s.toString());
                    myGauge.setRowsPerUnit(row);
                    checkAllFields();
                }
            }
        });
    }

    private void swatchHeight() {
        TextView swatchHeightTextView = (TextView)
                findViewById(R.id.swatchHeight);
        swatchHeightTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (s.length() != 0 && checkInt(s.toString())) {
                    int height = parseInt(s.toString());
                    myGauge.setSwatchHeight(height);
                    checkAllFields();
                }
            }
        });

    }

    private void swatchWidth() {
        TextView swatchWidthTextView = (TextView)
                findViewById(R.id.swatchWidth);
        swatchWidthTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (s.length() != 0 && checkInt(s.toString())) {
                    int width = parseInt(s.toString());
                    myGauge.setSwatchWidth(width);
                    checkAllFields();
                }
            }
        });
    }

    private void unit() {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.unitRadioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.i("TAG:: chk:", "id" + checkedId);
                if (checkedId == R.id.inchesRadioButton) {
                    myGauge.setUnit("in");
                    Log.i("TAG:: unit:", "in");
                } else {
                    myGauge.setUnit("cm");
                    Log.i("TAG:: unit:", "cm");
                }
                checkAllFields();
            }
        });
    }

    private void checkAllFields(){
        if (this.myGauge.getRowsPerUnit() > 0 && this.myGauge.getStitchesPerRow() > 0 && this.myGauge.getSwatchHeight() > 0 && this.myGauge.getSwatchWidth() > 0 && this.myGauge.getUnit() != null){
            Button button = (Button) findViewById(R.id.calculateButton);
            button.setEnabled(true);
            this.myController.setTheGauge(this.myGauge);
            this.myController.addGaugeToDB();
        }
    }

    private void nextScreen() {
        //Starts a new Intent
        Intent nextActivity = new Intent(getApplicationContext(), digital_gauge_viewcontroller.class);

        //http://developer.android.com/reference/android/util/Log.html
        Log.i("Send to ", "digital_gauge Layout");

        startActivity(nextActivity);
    }

    private void buttonClick() {
        Button button = (Button) findViewById(R.id.calculateButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextScreen();
            }
        });
    }

    private boolean checkInt(String check){
        boolean result = true;
        try{
            Integer.parseInt(check);
        }catch (Throwable e) {
            result = false;
        }
        return result;
    }

    private int parseInt(String check){
        int result = 0;
        try{
            result = Integer.parseInt(check);
        }catch (Throwable e) {
        e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gauge_calculator);
        this.stitches();
        this.rows();
        this.swatchWidth();
        this.swatchHeight();
        this.unit();
        this.buttonClick();
    }
}

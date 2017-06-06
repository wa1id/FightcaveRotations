package com.example.walid.fightcaverotations;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class SetupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        Button buttonNext1 = (Button) findViewById(R.id.buttonNext1);

        buttonNext1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if (checkHowManyChecked() == 0) {
                    Snackbar.make(view, getString(R.string.error_checked_zero), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                } else if (checkHowManyChecked() > 1) {
                    Snackbar.make(view, getString(R.string.error_checked_two), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                } else if (checkHowManyChecked() == 1) {
                    Intent intent = new Intent(getApplicationContext(), Setup2Activity.class);
                    intent.putExtra("checked", checkWhatIsChecked());
                    startActivity(intent);
                } else {
                    Snackbar.make(view, getString(R.string.error_unknown), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }

            }
        });

    }

    private int checkHowManyChecked() {
        CheckBox checkNW = (CheckBox) findViewById(R.id.checkNW);
        CheckBox checkCenter = (CheckBox) findViewById(R.id.checkCenter);
        CheckBox checkSW = (CheckBox) findViewById(R.id.checkSW);
        CheckBox checkSouth = (CheckBox) findViewById(R.id.checkSouth);
        CheckBox checkSE = (CheckBox) findViewById(R.id.checkSE);

        int counter = 0;

        if (checkNW.isChecked())
            counter++;

        if (checkCenter.isChecked())
            counter++;

        if (checkSW.isChecked())
            counter++;

        if (checkSouth.isChecked())
            counter++;

        if (checkSE.isChecked())
            counter++;

        return counter;
    }

    private int checkWhatIsChecked() {
        CheckBox checkNW = (CheckBox) findViewById(R.id.checkNW);
        CheckBox checkCenter = (CheckBox) findViewById(R.id.checkCenter);
        CheckBox checkSW = (CheckBox) findViewById(R.id.checkSW);
        CheckBox checkSouth = (CheckBox) findViewById(R.id.checkSouth);
        CheckBox checkSE = (CheckBox) findViewById(R.id.checkSE);

        int checkbox = 0;

        if (checkNW.isChecked())
            checkbox = 1;

        if (checkCenter.isChecked())
            checkbox = 2;

        if (checkSE.isChecked())
            checkbox = 3;

        if (checkSouth.isChecked())
            checkbox = 4;

        if (checkSW.isChecked())
            checkbox = 5;

        return checkbox;
    }


}

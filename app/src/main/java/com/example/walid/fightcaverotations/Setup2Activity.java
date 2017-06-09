package com.example.walid.fightcaverotations;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Setup2Activity extends AppCompatActivity {

    private CheckBox checkNW;
    private CheckBox checkCenter;
    private CheckBox checkSW;
    private CheckBox checkSouth;
    private CheckBox checkSE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup2);

        Button buttonNext = (Button) findViewById(R.id.buttonNext);
        checkNW = (CheckBox) findViewById(R.id.checkNW);
        checkCenter = (CheckBox) findViewById(R.id.checkCenter);
        checkSW = (CheckBox) findViewById(R.id.checkSW);
        checkSouth = (CheckBox) findViewById(R.id.checkSouth);
        checkSE = (CheckBox) findViewById(R.id.checkSE);

        buttonNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (getStart() == -1) {
                    Snackbar.make(view, getString(R.string.error_wrong_selection), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                } else if (getStart() == 99) {
                    Intent intent = new Intent(Setup2Activity.this, Setup3Activity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(Setup2Activity.this, FinalActivity.class);
                    intent.putExtra("start", getStart());
                    startActivity(intent);
                }
            }
        });

        ShowCorrectCheckboxes();
    }

    private void ShowCorrectCheckboxes() {

        if (getIntent().getIntExtra("checked", 0) == 0) {
            //TODO: Print error, it cannot be 0...
        }

        //Show correct checkboxes
        if (getIntent().getIntExtra("checked", 0) == 1) {
            checkNW.setVisibility(View.INVISIBLE);
            checkCenter.setVisibility(View.VISIBLE);
            checkSW.setVisibility(View.VISIBLE);
            checkSouth.setVisibility(View.VISIBLE);
            checkSE.setVisibility(View.VISIBLE);
        }

        if (getIntent().getIntExtra("checked", 0) == 2) {
            checkNW.setVisibility(View.VISIBLE);
            checkCenter.setVisibility(View.INVISIBLE);
            checkSW.setVisibility(View.VISIBLE);
            checkSouth.setVisibility(View.VISIBLE);
            checkSE.setVisibility(View.VISIBLE);
        }

        if (getIntent().getIntExtra("checked", 0) == 3) {
            checkNW.setVisibility(View.VISIBLE);
            checkCenter.setVisibility(View.VISIBLE);
            checkSW.setVisibility(View.VISIBLE);
            checkSouth.setVisibility(View.VISIBLE);
            checkSE.setVisibility(View.INVISIBLE);
        }

        if (getIntent().getIntExtra("checked", 0) == 4) {
            checkNW.setVisibility(View.VISIBLE);
            checkCenter.setVisibility(View.VISIBLE);
            checkSW.setVisibility(View.VISIBLE);
            checkSouth.setVisibility(View.INVISIBLE);
            checkSE.setVisibility(View.VISIBLE);
        }

        if (getIntent().getIntExtra("checked", 0) == 5) {
            checkNW.setVisibility(View.VISIBLE);
            checkCenter.setVisibility(View.VISIBLE);
            checkSW.setVisibility(View.INVISIBLE);
            checkSouth.setVisibility(View.VISIBLE);
            checkSE.setVisibility(View.VISIBLE);
        }
    }

    private int getStart() {
        int start = -1;
        int spawnWave1 = getIntent().getIntExtra("checked", 0);

        /** 1 **/
        //SW && SE
        if (!checkNW.isChecked() && checkSW.isChecked() && !checkCenter.isChecked() && checkSE.isChecked() && !checkSouth.isChecked() && spawnWave1 == 1) {
            start = 3;
        }

        //Center && SE
        else if (!checkNW.isChecked() && !checkSW.isChecked() && checkCenter.isChecked() && checkSE.isChecked() && !checkSouth.isChecked() && spawnWave1 == 1) {
            start = 7;
        }
        //Center && South
        else if (!checkNW.isChecked() && !checkSW.isChecked() && checkCenter.isChecked() && !checkSE.isChecked() && checkSouth.isChecked() && spawnWave1 == 1) {
            start = 12;
        }

        /** 2 **/
        //NW && SW
        else if (checkNW.isChecked() && checkSW.isChecked() && !checkCenter.isChecked() && !checkSE.isChecked() && !checkSouth.isChecked() && spawnWave1 == 2) {
            start = 2;
        }

        //SE && SW
        else if (!checkNW.isChecked() && checkSW.isChecked() && !checkCenter.isChecked() && checkSE.isChecked() && !checkSouth.isChecked() && spawnWave1 == 2) {
            start = 8;
        }

        //South && SE
        else if (!checkNW.isChecked() && !checkSW.isChecked() && !checkCenter.isChecked() && checkSE.isChecked() && checkSouth.isChecked() && spawnWave1 == 2) {
            start = 8;
        }

        /** 3 **/
        //SW && Center
        else if (!checkNW.isChecked() && checkSW.isChecked() && checkCenter.isChecked() && !checkSE.isChecked() && !checkSouth.isChecked() && spawnWave1 == 3) {
            start = 0;
        }

        //South && NW
        else if (checkNW.isChecked() && !checkSW.isChecked() && !checkCenter.isChecked() && !checkSE.isChecked() && checkSouth.isChecked() && spawnWave1 == 3) {
            start = 5;
        }

        //SW && South
        else if (!checkNW.isChecked() && checkSW.isChecked() && !checkCenter.isChecked() && !checkSE.isChecked() && checkSouth.isChecked() && spawnWave1 == 3) {
            start = 9;
        }

        /** 4 **/
        //SW && SE
        else if (!checkNW.isChecked() && checkSW.isChecked() && !checkCenter.isChecked() && checkSE.isChecked() && !checkSouth.isChecked() && spawnWave1 == 4) {
            start = 14;
        }

        //NW && Center
        else if (checkNW.isChecked() && !checkSW.isChecked() && checkCenter.isChecked() && !checkSE.isChecked() && !checkSouth.isChecked() && spawnWave1 == 4) {
            start = 99;
        }

        /** 5 **/
        //NW && Center
        else if (checkNW.isChecked() && !checkSW.isChecked() && checkCenter.isChecked() && !checkSE.isChecked() && !checkSouth.isChecked() && spawnWave1 == 5) {
            start = 1;
        }

        //South && SE
        else if (!checkNW.isChecked() && !checkSW.isChecked() && !checkCenter.isChecked() && checkSE.isChecked() && checkSouth.isChecked() && spawnWave1 == 5) {
            start = 4;
        }

        //NW && South
        else if (checkNW.isChecked() && !checkSW.isChecked() && !checkCenter.isChecked() && !checkSE.isChecked() && checkSouth.isChecked() && spawnWave1 == 5) {
            start = 10;
        }

        return start;
    }
}

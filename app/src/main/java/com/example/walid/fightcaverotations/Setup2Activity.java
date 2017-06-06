package com.example.walid.fightcaverotations;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Setup2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup2);

        Button buttonNext = (Button) findViewById(R.id.buttonNext);

        buttonNext.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if (getStart() == -1) {
                    Snackbar.make(view, getString(R.string.error_wrong_selection), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                } else if (getStart() == 99) {
                    //TODO: go to next intent and setup handicap wave
                } else {
                    Intent intent = new Intent(getApplicationContext(), FinalActivity.class);
                    intent.putExtra("start", getStart());
                    startActivity(intent);
                }
            }
        });

        ShowCorrectCheckboxes();
    }

    private void ShowCorrectCheckboxes() {
        CheckBox checkNW = (CheckBox) findViewById(R.id.checkNW);
        CheckBox checkCenter = (CheckBox) findViewById(R.id.checkCenter);
        CheckBox checkSW = (CheckBox) findViewById(R.id.checkSW);
        CheckBox checkSouth = (CheckBox) findViewById(R.id.checkSouth);
        CheckBox checkSE = (CheckBox) findViewById(R.id.checkSE);

        if (getIntent().getIntExtra("checked", 0) == 0) {
            //TODO: Print error
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
        CheckBox checkNW = (CheckBox) findViewById(R.id.checkNW);
        CheckBox checkCenter = (CheckBox) findViewById(R.id.checkCenter);
        CheckBox checkSW = (CheckBox) findViewById(R.id.checkSW);
        CheckBox checkSouth = (CheckBox) findViewById(R.id.checkSouth);
        CheckBox checkSE = (CheckBox) findViewById(R.id.checkSE);

        int start = -1;
        int spawnWave1 = getIntent().getIntExtra("checked", 0);

        /** 1 **/
        //SW && SE
        if (!checkNW.isChecked() && checkSW.isChecked() && !checkCenter.isChecked() && checkSE.isChecked() && !checkSouth.isChecked() && spawnWave1 == 1) {
            start = 3;
        }

        //Center && SE
        if (!checkNW.isChecked() && !checkSW.isChecked() && checkCenter.isChecked() && checkSE.isChecked() && !checkSouth.isChecked() && spawnWave1 == 1) {
            start = 7;
        }
        //Center && South
        if (!checkNW.isChecked() && !checkSW.isChecked() && checkCenter.isChecked() && !checkSE.isChecked() && checkSouth.isChecked() && spawnWave1 == 1) {
            start = 12;
        }

        /** 2 **/
        //NW && SW
        if (checkNW.isChecked() && checkSW.isChecked() && !checkCenter.isChecked() && !checkSE.isChecked() && !checkSouth.isChecked() && spawnWave1 == 2) {
            start = 2;
        }

        //SE && SW
        if (!checkNW.isChecked() && checkSW.isChecked() && !checkCenter.isChecked() && checkSE.isChecked() && !checkSouth.isChecked() && spawnWave1 == 2) {
            start = 8;
        }

        //South && SE
        if (!checkNW.isChecked() && !checkSW.isChecked() && !checkCenter.isChecked() && checkSE.isChecked() && checkSouth.isChecked() && spawnWave1 == 2) {
            start = 8;
        }

        /** 3 **/
        //SW && Center
        if (!checkNW.isChecked() && checkSW.isChecked() && checkCenter.isChecked() && !checkSE.isChecked() && !checkSouth.isChecked() && spawnWave1 == 3) {
            start = 0;
        }

        //South && NW
        if (checkNW.isChecked() && !checkSW.isChecked() && !checkCenter.isChecked() && !checkSE.isChecked() && checkSouth.isChecked() && spawnWave1 == 3) {
            start = 5;
        }

        //SW && South
        if (!checkNW.isChecked() && checkSW.isChecked() && !checkCenter.isChecked() && !checkSE.isChecked() && checkSouth.isChecked() && spawnWave1 == 3) {
            start = 9;
        }

        /** 4 **/
        //SW && SE
        if (!checkNW.isChecked() && checkSW.isChecked() && !checkCenter.isChecked() && checkSE.isChecked() && !checkSouth.isChecked() && spawnWave1 == 4) {
            start = 14;
        }

        //NW && Center
        if (checkNW.isChecked() && !checkSW.isChecked() && checkCenter.isChecked() && !checkSE.isChecked() && !checkSouth.isChecked() && spawnWave1 == 4) {
            start = 99;
        }

        /** 5 **/
        //NW && Center
        if (checkNW.isChecked() && !checkSW.isChecked() && checkCenter.isChecked() && !checkSE.isChecked() && !checkSouth.isChecked() && spawnWave1 == 5) {
            start = 1;
        }

        //South && SE
        if (!checkNW.isChecked() && !checkSW.isChecked() && !checkCenter.isChecked() && checkSE.isChecked() && checkSouth.isChecked() && spawnWave1 == 5) {
            start = 4;
        }

        //NW && South
        if (checkNW.isChecked() && !checkSW.isChecked() && !checkCenter.isChecked() && !checkSE.isChecked() && checkSouth.isChecked() && spawnWave1 == 5) {
            start = 10;
        }

        return start;
    }
}

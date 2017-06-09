package com.example.walid.fightcaverotations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Setup3Activity extends AppCompatActivity {

    private CheckBox checkCenter;
    private CheckBox checkSouth;
    private CheckBox checkSE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup3);

        checkCenter = (CheckBox) findViewById(R.id.checkCenter);
        checkSouth = (CheckBox) findViewById(R.id.checkSouth);
        checkSE = (CheckBox) findViewById(R.id.checkSE);
        checkCenter.setVisibility(View.VISIBLE);
        checkSouth.setVisibility(View.VISIBLE);
        checkSE.setVisibility(View.VISIBLE);
        Button buttonNextWave = (Button) findViewById(R.id.buttonNext);

        buttonNextWave.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });
    }
}

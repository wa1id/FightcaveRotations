package com.example.walid.fightcaverotations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);



    }

    private void PrintWave(int start, int wave) {
        TextView textCurrentWave = (TextView) findViewById(R.id.textCurrentWave);

        int i = 0;
        int currentWave = wave;
        textCurrentWave.setText(Integer.toString(wave));

        if (currentWave == 63) {
            //TODO: Jad stuff
        }

        while (currentWave > 0) {

        }
    }
}

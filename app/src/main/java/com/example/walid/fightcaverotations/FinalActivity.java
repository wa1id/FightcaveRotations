package com.example.walid.fightcaverotations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        final int start = getIntent().getIntExtra("start", -1);
        Button buttonNextWave = (Button) findViewById(R.id.buttonNext);

        buttonNextWave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PrintWave(start + 2, 3);

            }
        });


    }

    private void PrintWave(int start, int wave) {
        TextView textCurrentWave = (TextView) findViewById(R.id.textCurrentWave);

        int i = 0;
        int currentWave = wave;
        textCurrentWave.setText(Integer.toString(wave));

        if (currentWave == 63) {
            //TODO: Jad stuff
            Log.d("jad", "hit wave 63");
        }

        while (currentWave > 0) {
            currentWave = getSpawnNPC(currentWave);
            getSpawnLocation((start + i) % 15);
            i++;
        }
        return;
    }

    private int getSpawnNPC(int wave) {
        if (wave >= 31) {
            Log.d("printspawn", "360");
            return wave - 31;
        }
        if (wave >= 15) {
            Log.d("printspawn", "180");
            return wave - 15;
        }
        if (wave >= 7) {
            Log.d("printspawn", "90");
            return wave - 7;
        }
        if (wave >= 3) {
            Log.d("printspawn", "45");
            return wave - 3;
        }
        return wave - 1;
    }

    private void getSpawnLocation(int location) {
        int[] spawnArray = new int[]{3, 5, 2, 1, 5, 3, 4, 1, 2, 3, 5, 4, 1, 2, 4};
        int sval = spawnArray[location];
        if (sval == 1) {
            Log.d("printloc", "NW");
        }
        if (sval == 2) {
            Log.d("printloc", "Center");
        }
        if (sval == 3) {
            Log.d("printloc", "SE");
        }
        if (sval == 4) {
            Log.d("printloc", "S");
        }
        if (sval == 5) {
            Log.d("printloc", "SW");
        }
    }
}

package com.example.walid.fightcaverotations;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class FinalActivity extends AppCompatActivity {

    int start = -1;
    int wave = 4;
    TextView textNW;
    TextView textSouth;
    TextView textSE;
    TextView textCenter;
    TextView textSW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Button buttonNextWave = (Button) findViewById(R.id.buttonNext);
        Button buttonPrevWave = (Button) findViewById(R.id.buttonPrev);
        start = getIntent().getIntExtra("start", -1);
        textNW = (TextView) findViewById(R.id.textNW);
        textSouth = (TextView) findViewById(R.id.textSouth);
        textSE = (TextView) findViewById(R.id.textSE);
        textCenter = (TextView) findViewById(R.id.textCenter);
        textSW = (TextView) findViewById(R.id.textSW);

        if (start != 6 && start != 11) {
            PrintWave(start + 2, 3);
            start = start + 3;
        } else {
            start = start + 4;
            wave = 5;
            PrintWave(start, wave);
        }

        buttonNextWave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (wave >= 63) {
                    //TODO: change button, reset to start, ???
                } else {
                    wave++;
                    start++;
                    clearAllLabelsAndLists();
                    PrintWave(start, wave);
                }
            }
        });

        buttonPrevWave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (wave > 1) {
                    wave--;
                    start--;
                    clearAllLabelsAndLists();
                    PrintWave(start, wave);
                }
            }
        });


    }

    private List<String> monsters = new ArrayList<>();
    private List<String> locations = new ArrayList<>();

    private void PrintWave(int start, int wave) {
        TextView textCurrentWave = (TextView) findViewById(R.id.textCurrentWave);

        int i = 0;
        int currentWave = wave;
        textCurrentWave.setText(String.format("%d", wave));

        if (currentWave == 63) {
            JadSpawn((start) % 15);
            return;
        }

        while (currentWave > 0) {
            currentWave = getSpawnNPC(currentWave);
            getSpawnLocation((start + i) % 15);
            i++;
        }
        PrintSpawns();
    }

    private void JadSpawn(int start) {
        int i = 1;
        monsters.add("JAD");
        getSpawnLocation(start);
        while (i < 5) {
            monsters.add("Healer");
            getSpawnLocation((start + i) % 15);
            i++;
        }
        PrintSpawns();
    }

    private int getSpawnNPC(int wave) {
        if (wave >= 31) {
            monsters.add("360");
            return wave - 31;
        } else if (wave >= 15) {
            monsters.add("180");
            return wave - 15;
        } else if (wave >= 7) {
            monsters.add("90");
            return wave - 7;
        } else if (wave >= 3) {
            monsters.add("45");
            return wave - 3;
        } else {
            monsters.add("22");
        }
        return wave - 1;
    }

    private void getSpawnLocation(int location) {
        int[] spawnArray = new int[]{3, 5, 2, 1, 5, 3, 4, 1, 2, 3, 5, 4, 1, 2, 4};
        int sval = spawnArray[location];
        if (sval == 1) {
            locations.add("NW");
        }
        if (sval == 2) {
            locations.add("Center");
        }
        if (sval == 3) {
            locations.add("SE");
        }
        if (sval == 4) {
            locations.add("South");
        }
        if (sval == 5) {
            locations.add("SW");
        }
    }

    private int getColor(String monster) {
        int color;
        switch (monster) {
            case "22":
                color = Color.rgb(255, 229, 15);
                break;
            case "45":
                color = Color.rgb(225, 192, 50);
                break;
            case "90":
                color = Color.rgb(112, 173, 71);
                break;
            case "180":
                color = Color.rgb(237, 125, 49);
                break;
            case "360":
                color = Color.rgb(68, 114, 196);
                break;
            case "JAD":
                color = Color.RED;
                break;
            case "Healer":
                color = Color.rgb(225, 192, 50);
                break;
            default:
                color = Color.BLACK;
                break;
        }
        return color;
    }

    private void PrintSpawns() {
        for (int j = 0; j < monsters.size(); j++) {
            switch (locations.get(j)) {
                case "NW":
                    if (!textNW.getText().equals("")) {
                        textNW.append(" | " + monsters.get(j));
                    } else {
                        textNW.setText(monsters.get(j));
                        textNW.setTextColor(getColor(monsters.get(j)));
                    }
                    break;
                case "South":
                    if (!textSouth.getText().equals("")) {
                        textSouth.append(" | " + monsters.get(j));
                    } else {
                        textSouth.setText(monsters.get(j));
                        textSouth.setTextColor(getColor(monsters.get(j)));
                    }
                    break;
                case "SE":
                    if (!textSE.getText().equals("")) {
                        textSE.append(" | " + monsters.get(j));
                    } else {
                        textSE.setText(monsters.get(j));
                        textSE.setTextColor(getColor(monsters.get(j)));
                    }
                    break;
                case "Center":
                    if (!textCenter.getText().equals("")) {
                        textCenter.append(" | " + monsters.get(j));
                    } else {
                        textCenter.setText(monsters.get(j));
                        textCenter.setTextColor(getColor(monsters.get(j)));
                    }
                    break;
                case "SW":
                    if (!textSW.getText().equals("")) {
                        textSW.append(" | " + monsters.get(j));
                    } else {
                        textSW.setText(monsters.get(j));
                        textSW.setTextColor(getColor(monsters.get(j)));
                    }
                    break;
                default:
                    //TODO: Catch error / Print error
                    break;
            }
        }
    }

    private void clearAllLabelsAndLists() {
        textNW.setText("", TextView.BufferType.NORMAL);
        textSouth.setText("", TextView.BufferType.NORMAL);
        textSE.setText("", TextView.BufferType.NORMAL);
        textCenter.setText("", TextView.BufferType.NORMAL);
        textSW.setText("", TextView.BufferType.NORMAL);
        monsters.clear();
        locations.clear();
    }
}

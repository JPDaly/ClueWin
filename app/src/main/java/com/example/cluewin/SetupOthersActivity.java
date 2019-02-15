package com.example.cluewin;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SetupOthersActivity extends AppCompatActivity {

    Player me;
    int play_iteration;
    int n_players;
    Player[] players;
    public String playerName;
    Resources res;

    Button next_b;
    TextView title_tv;
    EditText cards_et;
    EditText order_et;
    EditText name_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_others);
        play_iteration = 1;
        res = getResources();
        me = getIntent().getParcelableExtra("PlayerMe");
        n_players = getIntent().getIntExtra("NoPlayers", 0);

        next_b = findViewById(R.id.play_next_butt);
        title_tv = findViewById(R.id.title_tv);
        title_tv.setText(res.getString(R.string.init_player_title, play_iteration));
        cards_et = findViewById(R.id.play_cards_et);
        order_et = findViewById(R.id.name_et);
        name_et = findViewById(R.id.play_order_et);

        next_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(play_iteration >= n_players-1) {
                    Toast.makeText(getApplicationContext(), "No more", Toast.LENGTH_SHORT).show();
                    return;
                }
//                TODO: add check to see if there is input in each field
//                TODO: create a player class for each player
//                TODO: add a back button so that you can edit player if you mae a mistake
                play_iteration++;
                title_tv.setText(res.getString(R.string.init_player_title, play_iteration));
                cards_et.getText().clear();
                name_et.getText().clear();
                order_et.getText().clear();
            }
        });
    }
}

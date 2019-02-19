package com.example.cluewin;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SetupOthersActivity extends AppCompatActivity {

    Player me;
    int play_iteration;
    int n_players;
    ArrayList<Player> players;
    public String playerName;
    Resources res;

    Button next_b;
    Button back_b;
    TextView title_tv;
    EditText cards_et;
    EditText order_et;
    EditText name_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_others);

        play_iteration = 0;
        res = getResources();
        me = getIntent().getParcelableExtra("PlayerMe");
        n_players = getIntent().getIntExtra("NoPlayers", 0);
        players = new ArrayList<>();

        next_b = findViewById(R.id.play_next_butt);
        back_b = findViewById(R.id.play_back_butt);
        title_tv = findViewById(R.id.title_tv);
        title_tv.setText(res.getString(R.string.init_player_title, play_iteration+1));

        cards_et = findViewById(R.id.play_cards_et);
        order_et = findViewById(R.id.play_order_et);
        name_et = findViewById(R.id.name_et);

        back_b.setVisibility(View.INVISIBLE);


        next_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cards_et.getText().toString().equals("") || name_et.getText().toString().equals("") || order_et.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Fill in all fields.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int order = Integer.parseInt(order_et.getText().toString());
                String name = name_et.getText().toString();
                int n_cards = Integer.parseInt(cards_et.getText().toString());

                players.add(new Player(order, name, n_cards, new ArrayList<Integer>()));

                play_iteration++;

                if(play_iteration >= n_players-1) {
                    Intent intent = new Intent(SetupOthersActivity.this, PlayActivity.class);
                    startActivity(intent);
                    return;
                } else if(play_iteration == 1) {
                    back_b.setVisibility(View.VISIBLE);
                }


                title_tv.setText(res.getString(R.string.init_player_title, play_iteration+1));
                cards_et.getText().clear();
                name_et.getText().clear();
                order_et.getText().clear();
            }
        });

        back_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play_iteration--;
                title_tv.setText(res.getString(R.string.init_player_title, play_iteration+1));
                cards_et.setText(String.valueOf(players.get(play_iteration).getN_cards()));
                order_et.setText(String.valueOf(players.get(play_iteration).getOrder_num()));
                name_et.setText(players.get(play_iteration).getName());

                players.remove(play_iteration);
            }
        });
    }

}

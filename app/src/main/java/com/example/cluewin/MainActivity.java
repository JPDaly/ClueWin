package com.example.cluewin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    public int n_players;
    public TextView no_players_tv;
    public Button higher_butt_b;
    public Button lower_butt_b;
    public Button next_b;


    public MainActivity() {
        n_players = Game.MAX_PLAYERS;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        higher_butt_b = findViewById(R.id.higher_button);
        no_players_tv = findViewById(R.id.no_plys);
        lower_butt_b =  findViewById(R.id.lower_button);
        next_b =  findViewById(R.id.next_button);


        higher_butt_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(n_players != 6) {
                    n_players++;
                }
                no_players_tv.setText(String.format(Locale.getDefault(),"%d",n_players));
            }
        });
        lower_butt_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(n_players != 1) {
                    n_players--;
                }
                no_players_tv.setText(String.format(Locale.getDefault(),"%d",n_players));
            }
        });
        next_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SetupMeActivity.class);
                intent.putExtra("TotalPlayers", n_players);
                startActivity(intent);
            }
        });
    }









    /*public void onButtonTap(View v) {
        name = editTxt.getText().toString();
        Toast myToast = Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT);
        myToast.show();
    }*/

}


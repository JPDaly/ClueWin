package com.example.cluewin;

import android.content.ClipData;
import android.graphics.Color;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SetupMeActivity extends AppCompatActivity {


    public int n_players;
    public EditText card_et;
    ListView cards_lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_me);
        n_players = getIntent().getIntExtra("TotalPlayers", 0);
        card_et = findViewById(R.id.order_et);
        card_et.setHint(String.format(Locale.getDefault(), "1-%d", n_players));


        cards_lv = findViewById(R.id.cards_lv);
        this.changeListView(cards_lv, 0);

        cards_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //((TextView)(view.findViewById(android.R.id.text1))).getText().toString()
            }
        });




    }

    private void changeListView(ListView cards_lv, int theme) {

        String[] cards = getResources().getStringArray(R.array.classic_cards);

        ListAdapter cardsAdapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_multiple_choice, cards);
        cards_lv.setAdapter(cardsAdapter);
    }
}

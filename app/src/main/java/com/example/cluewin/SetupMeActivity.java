package com.example.cluewin;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    public EditText order_et;
    public Button next_b;
    ListView cards_lv;
    ArrayList<Card> cards;
    String[] card_names;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_me);
        n_players = getIntent().getIntExtra("TotalPlayers", 0);

        cards = new ArrayList<>();
        card_names = getResources().getStringArray(R.array.classic_cards);

        cards_lv = findViewById(R.id.cards_lv);
        next_b = findViewById(R.id.next_butt);
        order_et = findViewById(R.id.order_et);

        cards.add(new Card(Card.PERSON, card_names[0], -1));
        for(int i=1; i<card_names.length; i++) {
            if(i <= 6) {
                cards.add(new Card(Card.PERSON, card_names[i], i));
            } else if(i==7) {
                cards.add(new Card(Card.WEAPON, card_names[i], -1));
            } else if (i <= 13) {
                cards.add(new Card(Card.WEAPON, card_names[i], i-1));
            } else if(i == 14) {
                cards.add(new Card(Card.PERSON, card_names[i], -1));
            } else {
                cards.add(new Card(Card.ROOM, card_names[i], i-2));
            }
        }

        CardListAdapter cardAdapter = new CardListAdapter(this, R.layout.card_adapter, cards);
        cards_lv.setAdapter(cardAdapter);

        cards_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Card card = cards.get(position);
                card.selected = !card.selected;
                if(card.selected) {
                    view.setBackgroundColor(Color.CYAN);
                } else {
                    view.setBackgroundColor(Color.WHITE);
                }
            }
        }); // 1 4 8 12 13 14 21

        next_b.setOnClickListener(new View.OnClickListener() {
            Player me;

            @Override
            public void onClick(View v) {
                if(order_et.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "You haven't entered your order number.", Toast.LENGTH_SHORT).show();
                    return;
                }

                ArrayList<Integer> selected = new ArrayList<>();

                for(Card card : cards) {
                    if(card.selected) {
                        selected.add(card.getId());
                    }
                }

                if(selected.size() == 0) {
                    Toast.makeText(getApplicationContext(), "You haven't selected any cards.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int order_num = Integer.parseInt(order_et.getText().toString());

                me = new Player(order_num, "Me", selected.size(), selected);

                Intent intent = new Intent(SetupMeActivity.this, SetupOthersActivity.class);
                intent.putExtra("PlayerMe", me);
                intent.putExtra("NoPlayers", n_players);
                startActivity(intent);
            }
        });
    }
//
//    private void changeListView(ListView cards_lv, int theme) {
//
//        String[] cards = getResources().getStringArray(R.array.classic_cards);
//
//        ListAdapter cardsAdapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_multiple_choice, cards);
//        cards_lv.setAdapter(cardsAdapter);
//    }
}

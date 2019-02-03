package com.example.cluewin;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class CardListAdapter extends ArrayAdapter<Card> {

    public CardListAdapter(Context context, int resource, List<Card> objects) {
        super(context, resource, objects);
    }
}

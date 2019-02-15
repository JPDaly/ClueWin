package com.example.cluewin;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class CardListAdapter extends ArrayAdapter<Card> {

    private Context context;
    private int resource;

    public CardListAdapter(Context context, int resource, ArrayList<Card> objects) {
        super(context, resource, objects);
        this.context = context;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        int type = getItem(position).getType();
        int id = getItem(position).getId();
        boolean selected = getItem(position).selected;


        LayoutInflater inflator = LayoutInflater.from(this.context);

        TextView description;

        if(id != -1) {
            convertView = inflator.inflate(R.layout.card_adapter, parent, false);
            description = convertView.findViewById(R.id.card_desc_tv);

        } else {
            convertView = inflator.inflate(R.layout.header_adapter, parent, false);
            description = convertView.findViewById(R.id.header_tv);
        }
        if(selected) {
            convertView.setBackgroundColor(Color.CYAN);
        } else {
            convertView.setBackgroundColor(Color.WHITE);
        }

        description.setText(name);

        return convertView;
    }
}

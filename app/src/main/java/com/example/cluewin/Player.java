package com.example.cluewin;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player implements Parcelable {

    private int order_num;
    private String name;
    private ArrayList<Integer> cards;
    private int n_cards;

    public Player(int order_num, String name, int n_cards, ArrayList<Integer> cards) {
        this.order_num = order_num;
        this.name = name;
        this.n_cards = n_cards;
        this.cards = cards;
    }

    public Player(Parcel parcel){
        this.cards = new ArrayList<>();
        this.order_num = parcel.readInt();
        this.n_cards = parcel.readInt();
        this.name = parcel.readString();
        ArrayList<?> temp = parcel.readArrayList(Integer.class.getClassLoader());
        for(int i=0; i<temp.size(); i++) {
            this.cards.add(Integer.parseInt(temp.get(i).toString()));
        }
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.order_num);
        dest.writeInt(this.n_cards);
        dest.writeString(this.name);
        dest.writeList(this.cards);
    }

    public static final Parcelable.Creator<Player> CREATOR= new Parcelable.Creator<Player>() {

        @Override
        public Player createFromParcel(Parcel source) {
            // TODO Auto-generated method stub
            return new Player(source);  //using parcelable constructor
        }

        @Override
        public Player[] newArray(int size) {
            // TODO Auto-generated method stub
            return new Player[size];
        }
    };

    public void updateCards(int card) {
        this.cards.add(card);
    }

    public int getOrder_num() {
        return order_num;
    }

    public String getName() {
        return name;
    }

    public int getCard(int index) {
        return this.cards.get(0);
    }

    public int getN_cards() {
        return n_cards;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setN_cards(int n_cards) {
        this.n_cards = n_cards;
    }
}

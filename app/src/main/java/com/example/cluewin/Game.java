package com.example.cluewin;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Locale;

public class Game {
    public static final int MAX_PLAYERS = 6;
    public static final int TOTAL_CARDS = 21;

    private int n_players;
    public Player[] players;
    public  Event[] events;

    public Game(int n_players) {
        this.n_players = n_players;
    }

}

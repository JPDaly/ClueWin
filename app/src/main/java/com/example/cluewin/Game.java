package com.example.cluewin;

import android.os.Parcelable;

import java.util.Locale;

public class Game  {
    public static final int MAX_PLAYERS = 6;
    public static final int TOTAL_CARDS = 21;

    public int n_players;
    Player[] players;
    Event[] events;

    Game(int n_players) {
        this.n_players = n_players;
    }

    public String get_n_players() {
        return String.format(Locale.getDefault(), "%d", this.n_players);
    }
}

package com.example.lesson1_a3.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.lesson1_a3.R;
import com.example.lesson1_a3.domain.Card;
import com.example.lesson1_a3.domain.Game;

import java.util.List;

public class EmojiGame {

    private final Game<String> game;
    private final Context context;

    @RequiresApi(api = Build.VERSION_CODES.R)
    public EmojiGame(Context context) {
        this.context = context;
        game = new Game<>(List.of("👻", "🎃", "👹"));
    }

    public void choose(Card<String> card){
        game.choose(card);
       ifGameOver();
    }

    public void ifGameOver() {
        if (game.isGameOver()){
       message();
        }
    }

    private void message() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(R.layout.message_dialog).show();
    }

    public List<Card<String>> getCards(){
        return game.getCards();
    }
}

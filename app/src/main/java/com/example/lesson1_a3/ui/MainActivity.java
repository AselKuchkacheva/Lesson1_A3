package com.example.lesson1_a3.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.lesson1_a3.R;
import com.example.lesson1_a3.domain.Card;
import com.example.lesson1_a3.ui.adapter.EmojiAdapter;

public class MainActivity extends AppCompatActivity implements EmojiAdapter.Listener {
    private RecyclerView recyclerView;
    private EmojiAdapter emojiAdapter;

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_cards);
        emojiAdapter = new EmojiAdapter(this,new EmojiGame(this));
        recyclerView.setAdapter(emojiAdapter);
    }

    @Override
    public void cardClick(Card<String> card) {
        Log.d("tag", String.valueOf(card.getId()));
        emojiAdapter.notifyDataSetChanged();
    }
}
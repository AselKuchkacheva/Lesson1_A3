package com.example.lesson1_a3.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson1_a3.R;
import com.example.lesson1_a3.domain.Card;
import com.example.lesson1_a3.ui.EmojiGame;

@RequiresApi(api = Build.VERSION_CODES.R)
public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.EmojiHolder> {

    private EmojiGame emojiGame;
    private Listener listener;

    public EmojiAdapter(Listener listener, EmojiGame emojiGame) {
        this.listener = listener;
        this.emojiGame = emojiGame;
    }

    @NonNull
    @Override
    public EmojiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);
        return new EmojiHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiHolder holder, int position) {
        holder.onBind(emojiGame.getCards().get(position));
    }

    @Override
    public int getItemCount() {
        return emojiGame.getCards().size();
    }

    class EmojiHolder extends RecyclerView.ViewHolder {
        private final TextView tvCard;


        public EmojiHolder(@NonNull View itemView) {
            super(itemView);
            tvCard = itemView.findViewById(R.id.tv_card_content);

        }

        public void onBind(Card<String> card) {
            if (card.isFaceUp()) {
                tvCard.setBackgroundColor(Color.WHITE);
                tvCard.setText(card.getContent());
            } else {
                tvCard.setBackgroundColor(Color.BLUE);
                tvCard.setText("");
            }
            itemView.setOnClickListener(v -> {
                emojiGame.choose(card);
                listener.cardClick(card);
            });


        }
    }

    public interface Listener {
        void cardClick(Card<String> card);
    }
}
package com.example.lesson1_a3.domain;

import android.util.Log;
import android.widget.Toast;

import com.example.lesson1_a3.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static android.widget.Toast.LENGTH_LONG;

public class Game<Content> {

    private List<Card<Content>> cards = new ArrayList<>();

    private boolean isGameOver = false;

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public Game(List<Content> contents) {
        for (int i = 0; i < contents.size(); i++) {
            cards.add(new Card<>((i * 2) + 1, false, false, contents.get(i)));
            cards.add(new Card<>(i * 2, false, false, contents.get(i)));
        }
        Collections.shuffle(cards);
    }

    public void choose(Card<Content> card) {
        card.setFaceUp(!card.isFaceUp());
        if (card.isFaceUp()) {
            checkPairs(card);
        }
        gameOver();
    }

    public void gameOver(){
        if (cards.isEmpty()){
            setGameOver(true);
        }
    }

    private void checkPairs(Card<Content> card) {
        for (Card<Content> anotherCard : cards) {
            if (card.isFaceUp() && anotherCard.isFaceUp()) {
                if (card.equals(anotherCard) && card.getId() != anotherCard.getId()) {
                    card.setMatched(true);
                    anotherCard.setMatched(true);
                    Log.d("tag", "MATCH!");
                } else if (!card.equals(anotherCard)){
                    card.setFaceUp(false);
                    anotherCard.setFaceUp(false);
                    Log.d("tag", "NOT MATCH!");
                }
            }
        }
        remove();
    }

    private void remove() {
        List<Card<Content>> resultCards = new ArrayList<>(cards);
        for (Card<Content> c : cards) {
            if (c.isMatched()) {
                resultCards.remove(c);
            }
        }
        cards.clear();
        cards.addAll(resultCards);
    }

    public List<Card<Content>> getCards() {
        return cards;
    }

}

package com.example.lesson1_a3.domain;

import java.util.Objects;

public class Card<Content>{

    private int id;
    private boolean isFaceUp;
    private boolean isMatched;
    private Content content;

    public Card(int id, boolean isFaceUp, boolean isMatched, Content content) {
        this.id = id;
        this.isFaceUp = isFaceUp;
        this.isMatched = isMatched;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void setFaceUp(boolean faceUp) {
        isFaceUp = faceUp;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card<?> card = (Card<?>) o;
        return Objects.equals(content, card.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}

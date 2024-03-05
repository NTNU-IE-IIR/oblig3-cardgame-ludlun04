package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.Collection;

public class HandOfCards {

  private Collection<PlayingCard> hand;
  private final int handSize;

  public HandOfCards(int handSize) {
    this.hand = new ArrayList<>();
    this.handSize = handSize;
  }

  public void setHand(Collection<PlayingCard> newHand) {
    if (newHand.size() != this.handSize) {
      throw new IllegalArgumentException("New hand must be of size " + this.handSize);
    }

    this.hand = newHand;
  }

  public Collection<PlayingCard> getHand() {
    return this.hand;
  }

  public int getSumOfFaces() {
    int sum = 0;

    for (PlayingCard card : this.hand) {
      sum += card.getFace();
    }

    return sum;
  }

  public boolean isFlush()  {
    if (hand.isEmpty()) {
      return false;
    }
    boolean isFlush = true;
    char suit = this.hand.iterator().next().getSuit(); //suit of first card
    for (PlayingCard card : this.hand) {
      if (card.getSuit() != suit) {
        isFlush = false;
      }
    }
    return isFlush;
  }

}

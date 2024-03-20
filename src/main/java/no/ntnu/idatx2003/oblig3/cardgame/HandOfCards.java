package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

    return this.hand
        .stream()
        .mapToInt(PlayingCard::getFace)
        .sum();
  }

  public boolean isFlush()  {

    return this.hand
        .stream()
        .map((PlayingCard::getSuit))
        .distinct().limit(2).count() == 1;
    // count of distinct suits is one, gives up after another suit shows up (limit of 2)
  }

  public Collection<PlayingCard> getHearts() {

    return this.hand
        .stream()
        .filter((PlayingCard card) -> card.getSuit() == 'H')
        .toList();
  }

  public boolean hasQueenOfSpades() {

    return this.hand
        .stream()
        .filter((c) -> (c.getSuit() == 'S' && c.getFace() == 12))
        .toList()
        .size() > 0;
  }

}

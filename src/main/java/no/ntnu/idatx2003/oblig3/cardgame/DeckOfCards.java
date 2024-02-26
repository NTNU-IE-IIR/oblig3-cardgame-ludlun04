package no.ntnu.idatx2003.oblig3.cardgame;
import java.util.Scanner;
public class DeckOfCards {
  private PlayingCard[] cards;
  private int count = 52;
  char[] suits = {'S', 'H', 'D', 'C'};
  private int minVal = 1;
  private int maxVal = 13;

  public DeckOfCards() {

    this.cards = new PlayingCard[this.count];


    instantiateDeck();

  }

  private void instantiateDeck() {

    int suitsCount = this.suits.length;

    for (int i = 0; i < this.count; i++) {
      int value = (int) (Math.random() * (maxVal + 1 - minVal) + minVal);
      int suitIndex = (int) (Math.random() * suitsCount);
      char suit = this.suits[suitIndex];
      cards[i] = new PlayingCard(suit, value);
    }
  }

}

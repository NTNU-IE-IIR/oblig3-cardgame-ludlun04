package no.ntnu.idatx2003.oblig3.cardgame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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

    int deckIndex = 0;
    for (int i = 0; i < this.suits.length; i++) {
      for (int j = minVal; j <= maxVal; j++) {
        PlayingCard newCard = new PlayingCard(this.suits[i], j);
        this.cards[deckIndex] = newCard;
        deckIndex++;
      }
    }

  }

  public Collection<PlayingCard> dealHand(int amountOfCards) {
    if (amountOfCards < 1 || amountOfCards > this.count) {
      throw new IllegalArgumentException("Must be in range 1-" + this.count);
    }
    ArrayList<PlayingCard> cardsToBeDealt= new ArrayList<>();
    ArrayList<PlayingCard> cardsCopy = new ArrayList<>(Arrays.asList(this.cards));

    System.out.println(cardsCopy.size());

    for (int i = 0; i < amountOfCards; i++) {
      int randIndex = (int) (Math.random() * (cardsCopy.size()));
      PlayingCard randomCard = cardsCopy.get(randIndex);
      cardsToBeDealt.add(randomCard);
      cardsCopy.remove(randIndex);

    }
    return cardsToBeDealt;
  }

}

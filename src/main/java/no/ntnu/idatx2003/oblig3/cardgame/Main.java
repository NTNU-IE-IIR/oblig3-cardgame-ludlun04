package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.Collection;
import javafx.stage.Stage;

public class Main {
  public static void main(String[] args) {
    //MainWindow.appMain(args);
    DeckOfCards deck = new DeckOfCards();
    Collection<PlayingCard> dealt = deck.dealHand(40);
    for (PlayingCard card : dealt) {
      System.out.println(card.getFace() + ", " + card.getSuit());
    }
  }
}

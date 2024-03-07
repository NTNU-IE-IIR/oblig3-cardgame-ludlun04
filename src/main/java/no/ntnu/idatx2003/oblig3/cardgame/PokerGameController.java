package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javafx.scene.image.Image;

public class PokerGameController {

  private MainWindow window;
  private PokerGameLogic game;
  public PokerGameController(MainWindow window) {
    this.window = window;
    this.game = new PokerGameLogic();
  }

  public void dealHand() {
    game.dealHand();
    HandOfCards newHand = game.getHand();
    window.setCenterPaneImages(getHandImages(newHand));
  }

  private Collection<Image> getHandImages(HandOfCards newHand) {
    ArrayList<Image> images = new ArrayList<>();

    for (PlayingCard card : newHand.getHand()) {
      String cardPath = PlayingCardPathFinder.getPlayingCardPath(card);
      images.add(new Image(cardPath));
    }
    return images;
  }

  public void checkHand() {
    HandOfCards hand = game.getHand();
    window.updateCardsOfHeartsLabel(getHeartsText(hand));
    window.updateSumOfFacesLabel(String.valueOf(hand.getSumOfFaces()));
    window.updateFlushLabel(getFlushText(hand));
    window.updateQueenOfSpadesLabel(getQueenOfSpadesText(hand));
  }

  private String getQueenOfSpadesText(HandOfCards hand) {
    String result = "No";

    if (hand.hasQueenOfSpades()) {
      result = "Yes";
    }
    return result;
  }

  private String getFlushText(HandOfCards hand) {
    String result = "No";

    if (hand.isFlush()) {
      result = "Yes";
    }
    return result;
  }

  private String getHeartsText(HandOfCards hand) {
    String result = "";

    Iterator<PlayingCard> hearts = hand.getHearts().iterator();

    if (!hearts.hasNext()) {
      result = "None";
    } else {
      while(hearts.hasNext()) {
        PlayingCard card = hearts.next();
        result += card.getAsString();
        if (hearts.hasNext()) {
          result += ", ";
        }
      }
    }
    return result;
  }
}

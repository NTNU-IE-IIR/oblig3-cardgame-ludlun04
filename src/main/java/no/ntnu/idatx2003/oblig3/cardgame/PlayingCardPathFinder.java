package no.ntnu.idatx2003.oblig3.cardgame;

public class PlayingCardPathFinder {


  public static String getPlayingCardPath(PlayingCard card) {
    String filename = card.getFace() + "" + card.getSuit() + ".png";
    String filePath = "cards_images/" + filename;

    return filePath;
  }

  public static String getJokerPath() {
    return "cards_images/joker.png";
  }
}

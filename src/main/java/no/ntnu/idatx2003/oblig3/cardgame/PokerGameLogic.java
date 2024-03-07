package no.ntnu.idatx2003.oblig3.cardgame;

public class PokerGameLogic {

  private HandOfCards hand;
  private DeckOfCards deck;

  private int handSize = 5;
  public PokerGameLogic() {
    this.deck = new DeckOfCards();
    this.hand = new HandOfCards(handSize);
  }

  public HandOfCards getHand() {
    return this.hand;
  }

  public void dealHand() {
    this.hand.setHand(this.deck.dealHand(handSize));
  }

}

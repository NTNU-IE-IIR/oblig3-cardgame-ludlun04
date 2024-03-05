package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Flow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class MainWindow extends Application{

  private DeckOfCards deck;
  private BorderPane rootNode;

  private HandOfCards hand;

  public MainWindow() {
    this.deck = new DeckOfCards();
    this.hand = new HandOfCards(5);
  }

  /**
   * Starts the main window.
   *
   * @param stage the stage to put scenes onto
   * @throws Exception if bad
   */
  @Override
  public void start(Stage stage) throws Exception {

    VBox rightPane = getRightPane();

    GridPane bottomPane = getBottomPane();

    FlowPane topPane = getTopPane();

    rootNode = new BorderPane();
    rootNode.setCenter(getDefaultCenterPane());
    rootNode.setRight(rightPane);
    rootNode.setBottom(bottomPane);
    rootNode.setTop(topPane);
    rootNode.setStyle("-fx-background-color: #176f80");

    Scene scene = new Scene(rootNode, 600, 600);
    stage.setScene(scene);
    stage.setTitle("Card game for professional poker players");
    stage.show();
  }

  private FlowPane getTopPane() {

    FlowPane topPane = new FlowPane();

    Label keepGamblingLabel = new Label("Keep Gambling");
    topPane.getChildren().add(keepGamblingLabel);

    Image keepGamblingImage = new Image("gambling.jpeg");
    ImageView imageView = new ImageView(keepGamblingImage);
    imageView.setFitHeight(100);
    imageView.setPreserveRatio(true);
    topPane.getChildren().add(imageView);

    topPane.setHgap(100);
    topPane.setAlignment(Pos.CENTER);
    topPane.setStyle("-fx-font-size: 20; -fx-background-color: #b8eee3");

    return topPane;
  }

  private GridPane getBottomPane() {
    GridPane bottomPane = new GridPane();

    Label sumOfFacesDescriptor = new Label("Sum of the faces: ");
    bottomPane.add(sumOfFacesDescriptor, 0, 0);

    int sumOfFaces = this.hand.getSumOfFaces();

    Label sumofFacesLabel = new Label(String.valueOf(sumOfFaces));
    bottomPane.add(sumofFacesLabel, 1, 0);



    Label flushDescriptor = new Label("Flush: ");
    bottomPane.add(flushDescriptor,0, 1);

    String flushStatus = "";

    if (this.hand.isFlush()) {
      flushStatus = "Yes";
    } else {
      flushStatus = "No";
    }

    Label flushLabel = new Label(flushStatus);
    bottomPane.add(flushLabel, 1, 1);

    Label cardsOfHeartsDescriptor = new Label("Cards of hearts: ");
    bottomPane.add(cardsOfHeartsDescriptor, 2, 0);

    String heartString = "";

    Iterator<PlayingCard> hearts = this.hand.getHearts().iterator();

    if (!hearts.hasNext()) {
      heartString = "None";
    } else {
      while(hearts.hasNext()) {
        PlayingCard card = hearts.next();
        heartString += card.getAsString();
        if (hearts.hasNext()) {
          heartString += ", ";
        }
      }
    }

    Label cardOfHeartsLabel = new Label(heartString);
    bottomPane.add(cardOfHeartsLabel, 3, 0);

    Label queenOfSpadesDescriptor = new Label("Queen of spades: ");
    bottomPane.add(queenOfSpadesDescriptor, 2, 1);

    String queenOfSpadesStatus = "";

    if (this.hand.hasQueenOfSpades()) {
      queenOfSpadesStatus = "Yes";
    } else {
      queenOfSpadesStatus = "No";
    }

    Label queenOfSpadesLabel = new Label(queenOfSpadesStatus);
    bottomPane.add(queenOfSpadesLabel, 3, 1);

    bottomPane.setAlignment(Pos.CENTER);
    bottomPane.setHgap(10);
    bottomPane.setVgap(10);
    bottomPane.setPadding(new Insets(10));
    bottomPane.setStyle("-fx-background-color: #b8eee3; -fx-font-family: 'Comic Sans MS'");
    return bottomPane;
  }

  private FlowPane getCenterPane() {

    FlowPane centerPane = new FlowPane();
    for (PlayingCard card : this.hand.getHand()) {

      Image image = new Image(PlayingCardPathFinder.getPlayingCardPath(card));
      ImageView imageView = new ImageView(image);
      imageView.setFitHeight(200);
      imageView.setPreserveRatio(true);
      centerPane.getChildren().add(imageView);
    }

    centerPane.setAlignment(Pos.CENTER);
    centerPane.setHgap(10);
    centerPane.setVgap(10);
    return centerPane;
  }

  private FlowPane getDefaultCenterPane() {


    FlowPane centerPane = new FlowPane();

    for (int i = 0; i < 5; i++) {
      ImageView imageView = new ImageView(new Image(PlayingCardPathFinder.getJokerPath()));
      imageView.setFitHeight(200);
      imageView.setPreserveRatio(true);
      centerPane.getChildren().add(imageView);
    }
    centerPane.setAlignment(Pos.CENTER);
    centerPane.setHgap(10);
    centerPane.setVgap(10);

    return centerPane;
  }

  private VBox getRightPane() {
    Button dealHandButton = new Button("Deal Hand");
    dealHandButton.setMinSize(80, 50);
    dealHandButton.setOnAction((ActionEvent event) -> {
    this.hand.setHand(this.deck.dealHand(5));
    this.rootNode.setCenter(getCenterPane());
    });

    Button checkHandButton = new Button("Check Hand");
    checkHandButton.setMinSize(80, 50);
    checkHandButton.setOnAction((ActionEvent event) -> {
      this.rootNode.setBottom(getBottomPane());
    });


    VBox rightPane = new VBox();
    rightPane.getChildren().addAll(dealHandButton, checkHandButton);
    rightPane.setAlignment(Pos.CENTER);
    rightPane.setSpacing(20);
    rightPane.setPadding(new Insets(20));
    return rightPane;
  }


  public static void appMain(String[] args) {
    launch();
  }
}

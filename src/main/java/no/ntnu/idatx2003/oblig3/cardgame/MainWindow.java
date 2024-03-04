package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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

  public MainWindow() {
    this.deck = new DeckOfCards();
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


    rootNode = new BorderPane();
    rootNode.setCenter(getDefaultCenterPane());
    rootNode.setRight(rightPane);
    rootNode.setBottom(bottomPane);
    rootNode.setStyle("-fx-background-color: #0b1352");

    Scene scene = new Scene(rootNode, 600, 600);
    stage.setScene(scene);
    stage.setTitle("Card game for professional poker players");
    stage.show();
  }

  private GridPane getBottomPane() {
    GridPane bottomPane = new GridPane();



    return bottomPane;
  }

  private FlowPane getCenterPane(Collection<PlayingCard> cards) {

    FlowPane centerPane = new FlowPane();
    for (PlayingCard card : cards) {
      String filename = card.getFace() + "" + card.getSuit() + ".png";
      String filePath = "cards_images/" + filename;
      Image image = new Image(filePath);
      ImageView imageView = new ImageView(image);
      imageView.setFitHeight(200);
      imageView.setPreserveRatio(true);
      centerPane.getChildren().add(imageView);
    }

    centerPane.setAlignment(Pos.CENTER);
    centerPane.setPadding(new Insets(5));
    return centerPane;
  }

  private FlowPane getDefaultCenterPane() {


    FlowPane centerPane = new FlowPane();

    for (int i = 0; i < 5; i++) {
      ImageView imageView = new ImageView(new Image("cards_images/joker.png"));
      imageView.setFitHeight(200);
      imageView.setPreserveRatio(true);
      centerPane.getChildren().add(imageView);
    }
    centerPane.setAlignment(Pos.CENTER);
    centerPane.setPadding(new Insets(5));

    return centerPane;
  }

  private VBox getRightPane() {
    Button dealHandButton = new Button("Deal Hand");
    dealHandButton.setOnAction((ActionEvent event) -> {
      Collection<PlayingCard> hand = this.deck.dealHand(5);
      this.rootNode.setCenter(getCenterPane(hand));
    });
    Button checkHandButton = new Button("Check Hand");

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

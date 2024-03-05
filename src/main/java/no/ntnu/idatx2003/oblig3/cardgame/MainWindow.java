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

    bottomPane.setStyle("-fx-background-color: white");
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
    dealHandButton.setOnAction((ActionEvent event) -> {
    this.hand.setHand(this.deck.dealHand(5));
    this.rootNode.setCenter(getCenterPane());
    });

    Button checkHandButton = new Button("Check Hand");
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

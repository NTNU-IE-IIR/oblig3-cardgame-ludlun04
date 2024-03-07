package no.ntnu.idatx2003.oblig3.cardgame;


import java.util.Collection;
import java.util.Iterator;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow extends Application{

  private PokerGameController controller;
  private FlowPane centerPane;
  private Label sumofFacesLabel;
  private Label flushLabel;
  private Label cardsOfHeartsLabel;
  private Label queenOfSpadesLabel;


  /**
   * Starts the main window.
   *
   * @param stage the stage to put scenes onto
   * @throws Exception if bad
   */
  @Override
  public void start(Stage stage) throws Exception {

    this.controller = new PokerGameController(this);
    this.centerPane = getDefaultCenterPane();

    VBox rightPane = getRightPane();

    GridPane bottomPane = getBottomPane();

    FlowPane topPane = getTopPane();



    BorderPane rootNode = new BorderPane();
    rootNode.setCenter(this.centerPane);
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

    Label keepGamblingLabel = new Label("Fun fact: 90% of gamblers quit right before they make" +
        " it big");
    topPane.getChildren().add(keepGamblingLabel);

    Image keepGamblingImage = new Image("gambling.jpeg");
    ImageView imageView = new ImageView(keepGamblingImage);
    imageView.setFitHeight(150);
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

    this.sumofFacesLabel = new Label("");
    bottomPane.add(this.sumofFacesLabel, 1, 0);

    Label flushDescriptor = new Label("Flush: ");
    bottomPane.add(flushDescriptor,0, 1);

    this.flushLabel = new Label("");
    bottomPane.add(this.flushLabel, 1, 1);

    Label cardsOfHeartsDescriptor = new Label("Cards of hearts: ");
    bottomPane.add(cardsOfHeartsDescriptor, 2, 0);

    this.cardsOfHeartsLabel = new Label("");
    bottomPane.add(this.cardsOfHeartsLabel, 3, 0);

    Label queenOfSpadesDescriptor = new Label("Queen of spades: ");
    bottomPane.add(queenOfSpadesDescriptor, 2, 1);

    this.queenOfSpadesLabel = new Label("");
    bottomPane.add(this.queenOfSpadesLabel, 3, 1);

    bottomPane.setAlignment(Pos.CENTER);
    bottomPane.setHgap(10);
    bottomPane.setVgap(10);
    bottomPane.setPadding(new Insets(10));
    bottomPane.setStyle("-fx-background-color: #b8eee3; -fx-font-family: 'Comic Sans MS'");
    return bottomPane;
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
      this.controller.dealHand();
    });

    Button checkHandButton = new Button("Check Hand");
    checkHandButton.setMinSize(80, 50);
    checkHandButton.setOnAction((ActionEvent event) -> {
      this.controller.checkHand();
    });

    dealHandButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    checkHandButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

    VBox rightPane = new VBox();
    rightPane.setFillWidth(true);

    rightPane.getChildren().addAll(dealHandButton, checkHandButton);
    rightPane.setAlignment(Pos.CENTER);
    rightPane.setSpacing(20);
    rightPane.setPadding(new Insets(20));
    return rightPane;
  }

  public void updateSumOfFacesLabel(String text) {
    if (text == null) {
      throw new IllegalArgumentException("Text cannot be null");
    }
    this.sumofFacesLabel.setText(text);
  }

  public void updateFlushLabel(String text) {
    if (text == null) {
      throw new IllegalArgumentException("Text cannot be null");
    }
    this.flushLabel.setText(text);
  }

  public void updateCardsOfHeartsLabel(String text) {
    if (text == null) {
      throw new IllegalArgumentException("Text cannot be null");
    }
    this.cardsOfHeartsLabel.setText(text);
  }

  public void updateQueenOfSpadesLabel(String text) {
    if (text == null) {
      throw new IllegalArgumentException("Text cannot be null");
    }
    this.queenOfSpadesLabel.setText(text);
  }

  public void setCenterPaneImages(Collection<Image> images) {
    this.centerPane.getChildren().clear();
    for (Image i : images) {
      ImageView imageView = new ImageView(i);
      imageView.setFitHeight(200);
      imageView.setPreserveRatio(true);
      this.centerPane.getChildren().add(imageView);
    }
  }


  public static void appMain(String[] args) {
    launch();
  }
}

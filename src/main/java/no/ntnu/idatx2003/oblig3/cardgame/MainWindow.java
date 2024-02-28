package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow extends Application{

  /**
   * Starts the main window.
   *
   * @param stage the stage to put scenes onto
   * @throws Exception if bad
   */
  @Override
  public void start(Stage stage) throws Exception {


    Button dealHandButton = new Button("Deal Hand");
    Button checkHandButton = new Button("Check Hand");

    VBox rightPane = new VBox();
    rightPane.getChildren().addAll(dealHandButton, checkHandButton);
    rightPane.setAlignment(Pos.CENTER);
    rightPane.setSpacing(20);
    rightPane.setPadding(new Insets(20));

    TextArea t1 = new TextArea("test");
    TextArea t2 = new TextArea("test");
    TextArea t3 = new TextArea("test");
    TextArea t4 = new TextArea("test");
    TextArea t5 = new TextArea("test");

    ArrayList<TextArea> cardsAsText = new ArrayList<>(Arrays.asList(t1, t2, t3, t4, t5));

    VBox centerPane = new VBox();
    centerPane.getChildren().addAll(cardsAsText);
    centerPane.setAlignment(Pos.CENTER);


    BorderPane rootNode = new BorderPane();
    rootNode.setRight(rightPane);
    rootNode.setCenter(centerPane);

    Scene scene = new Scene(rootNode, 200, 300);
    stage.setScene(scene);
    stage.setTitle("Card game for professional poker players");
    stage.show();
  }

  public static void appMain(String[] args) {
    launch();
  }
}

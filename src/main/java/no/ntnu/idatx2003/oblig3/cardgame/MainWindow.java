package no.ntnu.idatx2003.oblig3.cardgame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
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
    BorderPane rootNode = new BorderPane();

    Scene scene = new Scene(rootNode, 1, 100);
    stage.setScene(scene);
    stage.setTitle("Card game for professional poker players");
    stage.show();
  }

  public static void appMain(String[] args) {
    launch();
  }
}

package project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Piotrek on 22.01.2017.
 */
public class WinWindow extends Application{
    private Button okButton;
    private Button exitButton;

    @Override
    public void start(Stage gameStage) {
        gameStage.setTitle("KENYO");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(15, 15, 15, 15));

        okButton = new Button();
        okButton.setText("ZAGRAJ JESZCZE RAZ");
        HBox hbLoginButton = new HBox(10);
        hbLoginButton.setAlignment(Pos.TOP_RIGHT);
        hbLoginButton.getChildren().add(okButton);
        grid.add(hbLoginButton, 0, 3);

        Text sceneTitle = new Text("KENYO");
        grid.add(sceneTitle, 0, 0);

        Text userName = new Text("PRZEGRAŁEŚ");
        grid.add(userName, 0, 1);

        exitButton = new Button();
        exitButton.setText("WYJŚCIE");
        HBox hbExitButton = new HBox(10);
        hbExitButton.setAlignment(Pos.BOTTOM_RIGHT);
        hbExitButton.getChildren().add(exitButton);
        grid.add(hbExitButton, 0, 4);

        Scene scene = new Scene(grid, 300, 250);
        gameStage.setScene(scene);
        gameStage.show();

        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    gameStage.close();
                    System.exit(0);
                } catch (Exception ex) {
                    Logger.getLogger(WelcomeWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }

}

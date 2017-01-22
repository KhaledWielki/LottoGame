package project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Piotrek on 22.01.2017.
 */
public class WelcomeWindow extends Application{
    private Button loginButton;
    private Button exitButton;

    @Override
    public void start(Stage welcomeStage) {
        welcomeStage.setTitle("KENYO");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(15, 15, 15, 15));
        loginButton = new Button();
        loginButton.setText("ZAGRAJ");
        HBox hbLoginButton = new HBox(10);
        hbLoginButton.setAlignment(Pos.TOP_RIGHT);
        hbLoginButton.getChildren().add(loginButton);
        grid.add(hbLoginButton, 1, 1);
        Text sceneTitle = new Text("NAZWA UŻYTKOWNIKA:");
        grid.add(sceneTitle, 0, 0);
        TextField firstNameField = new TextField();
        grid.add(firstNameField, 1, 0);
        exitButton = new Button();
        exitButton.setText("WYJŚCIE");
        HBox hbExitButton = new HBox(10);
        hbExitButton.setAlignment(Pos.BOTTOM_RIGHT);
        hbExitButton.getChildren().add(exitButton);
        grid.add(hbExitButton, 1, 2);

        Scene scene = new Scene(grid, 300, 250);
        welcomeStage.setScene(scene);
        welcomeStage.show();

        /*loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                Login login = new Login();
                try {
                    login.start(stage);
                    welcomeStage.hide();
                } catch (Exception ex) {
                    Logger.getLogger(Bank2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });*/

        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    welcomeStage.close();
                    System.exit(0);
                } catch (Exception ex) {
                    Logger.getLogger(WelcomeWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}

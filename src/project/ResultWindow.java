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
public class ResultWindow extends Application {
    private Button playButton;
    private Button exitButton;

    @Override
    public void start(Stage gameStage) {
        gameStage.setTitle("KENYO");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(15, 15, 15, 15));

        playButton = new Button();
        playButton.setText("WYNIK");
        HBox hbLoginButton = new HBox(10);
        hbLoginButton.setAlignment(Pos.TOP_RIGHT);
        hbLoginButton.getChildren().add(playButton);
        grid.add(hbLoginButton, 0, 3);

        Text sceneTitle = new Text("KENYO");
        grid.add(sceneTitle, 0, 0);

        Text userName = new Text("Użytkownik: ");
        grid.add(userName, 0, 1);

        Text player = new Text(WelcomeWindow.user);
        grid.add(player, 1, 1);

        Text numbers = new Text("Liczby: ");
        grid.add(numbers, 0, 2);

        Text number1 = new Text(Integer.toString(Client.userList.get(0)));
        grid.add(number1, 1, 2);

        Text number2 = new Text(Integer.toString(Client.userList.get(1)));
        grid.add(number2, 2, 2);

        Text number3 = new Text(Integer.toString(Client.userList.get(2)));
        grid.add(number3, 3, 2);

        Text number4 = new Text(Integer.toString(Client.userList.get(3)));
        grid.add(number4, 4, 2);

        Text number5 = new Text(Integer.toString(Client.userList.get(4)));
        grid.add(number5, 5, 2);

        Text number6 = new Text(Integer.toString(Client.userList.get(5)));
        grid.add(number6, 6, 2);

        exitButton = new Button();
        exitButton.setText("WYJŚCIE");
        HBox hbExitButton = new HBox(10);
        hbExitButton.setAlignment(Pos.BOTTOM_RIGHT);
        hbExitButton.getChildren().add(exitButton);
        grid.add(hbExitButton, 0, 4);

        Scene scene = new Scene(grid, 500, 250);
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

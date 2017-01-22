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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Piotrek on 22.01.2017.
 */
public class WelcomeWindow extends Application{
    private Button loginButton;
    private Button exitButton;
    static String user;
    static List<Integer> resultList = new ArrayList<>();
    static List<String> helpList2 = new ArrayList<>();

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
        TextField userName = new TextField();
        grid.add(userName, 1, 0);
        exitButton = new Button();
        exitButton.setText("WYJŚCIE");
        HBox hbExitButton = new HBox(10);
        hbExitButton.setAlignment(Pos.BOTTOM_RIGHT);
        hbExitButton.getChildren().add(exitButton);
        grid.add(hbExitButton, 1, 2);

        Scene scene = new Scene(grid, 300, 250);
        welcomeStage.setScene(scene);
        welcomeStage.show();

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                Client client = new Client();
                try {
                    user = userName.getText();
                    client.start(stage);
                    welcomeStage.hide();

                    connectToServer();
                } catch (IOException e) {
                    e.printStackTrace();
                }catch (Exception ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

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

    public static List<Integer> connectToServer() throws IOException{
        Socket socket = new Socket("127.0.0.1", 9898);
        while (true)
        {
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            pw.println("Client name: ROMAN");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String answer = input.readLine();
            String answer2 = input.readLine();

            System.out.println(answer);
            helpList2 = LottoController.convertToList(answer2);
            resultList = LottoController.getIntegerArray(answer2);
            System.out.println(resultList);


            try{
                Thread.sleep(2000);
                return resultList;
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

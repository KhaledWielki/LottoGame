package project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Piotrek on 22.01.2017.
 */
public class Client extends Application{

    static List<Integer> userList = new ArrayList<>();
    static List<Integer> resultList = new ArrayList<>();
    static List<String> helpList = new ArrayList<>();

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
        playButton.setText("ZAGRAJ");
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

        TextField number1 = new TextField();
        grid.add(number1, 1, 2);

        TextField number2 = new TextField();
        grid.add(number2, 2, 2);

        TextField number3 = new TextField();
        grid.add(number3, 3, 2);

        TextField number4 = new TextField();
        grid.add(number4, 4, 2);

        TextField number5 = new TextField();
        grid.add(number5, 5, 2);

        TextField number6 = new TextField();
        grid.add(number6, 6, 2);

        exitButton = new Button();
        exitButton.setText("Wyjscie");
        HBox hbExitButton = new HBox(10);
        hbExitButton.setAlignment(Pos.BOTTOM_RIGHT);
        hbExitButton.getChildren().add(exitButton);
        grid.add(hbExitButton, 0, 4);

        Scene scene = new Scene(grid, 500, 250);
        gameStage.setScene(scene);
        gameStage.show();
    }

    private static void connectToServer() throws IOException {
        Socket socket = new Socket("127.0.0.1", 9898);
        while (true)
        {
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            pw.println("Client name: ROMAN");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String answer = input.readLine();
            String answer2 = input.readLine();

            System.out.println(answer);
            helpList = LottoController.convertToList(answer2);
            resultList = LottoController.getIntegerArray(answer2);
            System.out.println(resultList);
            System.out.println(LottoController.lottoCompare(userList, resultList));

            try{
                Thread.sleep(2000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
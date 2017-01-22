package project;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Piotrek on 22.01.2017.
 */
public class Client {

    static List<Integer> userList = new ArrayList<>();
    static List<Integer> resultList = new ArrayList<>();
    static List<String> helpList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        userList.add(3);
        userList.add(7);
        userList.add(23);
        userList.add(35);
        userList.add(41);
        userList.add(47);

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
package project;

import project.LottoController;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import static project.LottoController.lottoRandomize;

/**
 * Created by Piotrek on 22.01.2017.
 */
public class Server {
    static ArrayList<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.out.println("Uruchomiono serwer.");
        int connectionNumber = 0;
        ServerSocket listener = new ServerSocket(9898);
        try {
            while (true) {
                connection c = new connection(listener.accept(), connectionNumber++);
                c.start();
            }
        } finally {
            listener.close();
        }
    }

    static class connection extends Thread {
        private Socket socket;
        private int connectionNumber;

        public connection(Socket socket, int connectionNumber){
            this.socket = socket;
            this.connectionNumber = connectionNumber;
            log("Connection number id: " + connectionNumber);
        }

        public void run() {
            String result = LottoController.lottoRandomize();
            try {
                BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                pw.println("nr: " + connectionNumber + ".");

                while (true) {
                    String input = in.readLine();
                    System.out.println("\t\t"+connectionNumber+" : "+input);
                    pw.println(result);
                }
            }
            catch (IOException e) {
                log("error number: " + connectionNumber + ": " + e);
            }
            finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    log("Cannot close");
                }
                log("Connection nr: " + connectionNumber + " closed");
            }
        }

        private void log(String a) {

            System.out.println(a);
        }
    }
}

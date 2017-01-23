package project;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import project.LottoController;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static project.LottoController.lottoRandomize;

/**
 * Created by Piotrek on 22.01.2017.
 */
public class Server {
    static ArrayList<Integer> resultList = new ArrayList<>();
    private static int portFromConfig;

    public static void main(String[] args) throws Exception {
        if(!readConfigFile("config.xml")) {
            System.err.println("Error during parse config file! Server stopped.");
            System.exit(1);
        }else {
            System.out.println("Uruchomiono serwer.");
            int connectionNumber = 0;
            ServerSocket listener = new ServerSocket(portFromConfig);
            try {
                while (true) {
                    connection c = new connection(listener.accept(), connectionNumber++);
                    c.start();
                }
            } finally {
                listener.close();
            }
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

    private static boolean readConfigFile(String fileName) {
        try {
            File fXmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("config");

            Node nNode = nList.item(0);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                portFromConfig= Integer.parseInt(eElement.getElementsByTagName("port").item(0).getTextContent());
            }
            return true;
        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }
}

import client.PrinterScanner;
import client.UDPClient;

import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try {
            UDPClient client = new UDPClient();//создание объекта client
            client.runClient();//вызов метода объекта client
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}
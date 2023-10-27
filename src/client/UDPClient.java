package client;

import java.net.*;
import java.io.*;
public class UDPClient {
    private String DATA;
    public void runClient() throws IOException {
        DatagramSocket s = null;
        try {
            byte[] buf = new byte[64];
            s = new DatagramSocket();

            System.out.println("UDPClient: Started");
            String COUNT_CMD = "COUNT";
            DatagramPacket sendPacket = new DatagramPacket(COUNT_CMD.getBytes(), COUNT_CMD.getBytes().length, InetAddress.getByName("127.0.0.1"), 8001);
            s.send(sendPacket);
            PrinterScanner printScan = new PrinterScanner();
            DATA = printScan.toString();
            sendPacket = new DatagramPacket(DATA.getBytes(), DATA.getBytes().length, InetAddress.getByName("127.0.0.1"), 8001);
            s.send(sendPacket);
            DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);//создание дейтаграммы для получения данных
            s.receive(recvPacket);
            String answer = new String(recvPacket.getData()).trim();
            System.out.println("Answer is: " + answer);
            byte[] quitCmd = {'Q', 'U', 'I', 'T'};
            sendPacket.setData(quitCmd);//установить массив посылаемых данных
            sendPacket.setLength(quitCmd.length);//установить длину посылаемых
// данных
            s.send(sendPacket); //послать данные серверу
            System.out.println("UDPClient: Ended");
        } finally {
            if (s != null) {
                s.close();//закрытие сокета клиента
            }
        }

    }
}

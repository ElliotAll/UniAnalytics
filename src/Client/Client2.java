package Client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Client2 {
    public static void main(String[] ar) {
        ArrayList<String> dirlist = new ArrayList<String>();
        int serverPort = 3128; // здесь обязательно нужно указать порт к которому привязывается сервер.
        String address = "127.0.0.1"; // это IP-адрес компьютера, где исполняется наша серверная программа.
        // Здесь указан адрес того самого компьютера где будет исполняться и клиент.
        File directory = new File("C:\\Eftpos 3.0\\Logs");
        File[] filelist = directory.listFiles();
        for (File file : filelist) {
            if(file.isDirectory()) {
            }
            }
                try {
                    InetAddress ipAddress = InetAddress.getByName(address); // создаем объект который отображает вышеописанный IP-адрес.
                    System.out.println("Any of you heard of a socket with IP address " + address + " and port " + serverPort + "?");
                    Socket socket = new Socket(ipAddress, serverPort); // создаем сокет используя IP-адрес и порт сервера.
                    System.out.println("Yes! I just got hold of the program.");

                    InputStream sin = socket.getInputStream();
                    OutputStream sout = socket.getOutputStream();

                    DataInputStream in = new DataInputStream(sin);
                    DataOutputStream out = new DataOutputStream(sout);

                    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
                    String line = null;
                    System.out.println("Type in something and press enter. Will send it to the server and tell ya what it thinks.");
                    System.out.println();



                        System.out.println("Sending this line to the server...");
                        //for(int i= 0; i < filelist.length; i++) {
                    for (File file2 : filelist) {

                            out.writeUTF(file2.getName()); // отсылаем введенную строку текста серверу.
                            out.flush(); // заставляем поток закончить передачу данных.
                            //line = in.readUTF(); // ждем пока сервер отошлет строку текста.
                            }
                       // }

                        line = in.readUTF();

                        System.out.println("The server was very polite. It sent me this : " + line);
                        System.out.println("Looks like the server is pleased with us. Go ahead and enter more lines.");
                        System.out.println();
                    } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
            }




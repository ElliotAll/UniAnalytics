package Client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class ClientPATHScanner {
    public static Socket socket;
    public static void main(String[] args) throws IOException {
        ArrayList<String> dirlist = new ArrayList<String>();
        File directory = new File("C:\\Eftpos 3.0\\Logs");
        File[] filelist = directory.listFiles();
        for (File file : filelist) {

            if (file.isDirectory()) {

                try {
                    dirlist.add(file.getName());
                    String SomethingtoRead = file.getName();

                    String host = "127.0.0.1";
                    int port = 3128;
                    InetAddress address = InetAddress.getByName(host);
                    socket = new Socket(address, port);

                    OutputStream os = socket.getOutputStream();
                    OutputStreamWriter osw = new OutputStreamWriter(os);
                    BufferedWriter bw = new BufferedWriter(osw);
                    OutputStream socketOutputStream = socket.getOutputStream();
                    socketOutputStream.write(SomethingtoRead.getBytes());
                    //socketOutputStream.flush();
                } catch (Exception e) {
                    System.out.println("init error: " + e);
                } // вывод исключений
            }

                }
            }
        }



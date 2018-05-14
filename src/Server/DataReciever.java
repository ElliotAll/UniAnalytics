package Server;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class DataReciever {

   public static List<String> recievings = new ArrayList<String>();
    public static void main(String[] ar)    {
        int port = 3128; // случайный порт (может быть любое число от 1025 до 65535)
        try {
            ServerSocket ss = new ServerSocket(port); // создаем сокет сервера и привязываем его к вышеуказанному порту
            System.out.println("Waiting for a client...");

            Socket socket = ss.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
            System.out.println("Got a client :) ... Finally, someone saw me through all the cover!");
            System.out.println();

            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиенту.
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            String line = null;
            while(true) {
                    line = in.readUTF(); // ожидаем пока клиент пришлет строку текста.
                    //recievings.add(in.readUTF());
                //for (int i = 0; i < 3; i++)
               // {
                    //recievings.add(line);}


                    System.out.println("The dumb client just sent me this line : " + line);
                    System.out.println("I'm sending it back...");
                    //out.writeUTF("ACK"); // отсылаем клиенту обратно ту самую строку текста.
                    //out.flush(); // заставляем поток закончить передачу данных.
                    System.out.println("Waiting for the next line...");
                System.out.println(recievings.get(0));
                System.out.println(recievings.get(1));
                }
        } catch(Exception x) { x.printStackTrace();
        }

    }

}
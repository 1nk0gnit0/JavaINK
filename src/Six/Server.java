package Six;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.util.Scanner;

public class Server {
    private static Socket socket;


    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            System.out.println("Сервер запущен, ждёт подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outPutStream = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        String strFromClient = dataInputStream.readUTF();
                        if (strFromClient.equalsIgnoreCase("/end")) {
                            break;
                        }

                        System.out.println("Client (" + LocalDate.now() + "): " + strFromClient);
                        outPutStream.writeUTF("Client (" + LocalDate.now() + "): " + strFromClient);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            while (true) {
                Scanner in = new Scanner(System.in);
                String str = in.nextLine();
                outPutStream.writeUTF("Server (" + LocalDate.now() + "): " + str);
                System.out.println("Server (" + LocalDate.now() + "): " + str);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package Seven.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class StartServer {

    public static void main(String[] args) throws IOException {
        new Server();
    }
}

class Server {
    private List<ClientHandler> peers;

    Server(){
        AuthService authService = new AuthServiceImpl();
        peers = new CopyOnWriteArrayList<>();
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            authService.connect();
            serverSocket = new ServerSocket(8182);
            System.out.println("Сервер запущен!");
            while (true) {
                socket = serverSocket.accept();

                System.out.println("Клиент подключился!");

                ClientHandler clientHandler = new ClientHandler(this, socket);
                System.out.println(clientHandler.getNick());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            authService.disconnect();
        }
    }

    void broadcast(String message) {
        for (ClientHandler clientHandler : peers) {
            clientHandler.sendMsg(message);
        }
    }

    void prvMsg(String nick, String message) {
        for (ClientHandler clientHandler : peers) {
            if(clientHandler.getNick().equals(nick)){
                clientHandler.sendMsg(clientHandler.getNick()+ ": " + message);
            }
        }
    }

    void subscribe(ClientHandler clientHandler) {
        peers.add(clientHandler);
    }

    void unsubscribe(ClientHandler clientHandler) {
        peers.remove(clientHandler);
    }
}

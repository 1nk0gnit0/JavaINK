package Seven_Eight.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ClientHandler {

    private Socket socket;
    private Server server;
    private AuthService authService;
    private DataOutputStream out;
    private DataInputStream in;
    private String nick;
    private List<String> blackList;
    private boolean LogIn = false;

    public String getNick() {
        return nick;
    }

    public ClientHandler(Server server, Socket socket){
        try {
            this.socket = socket;
            this.server = server;
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            this.authService = new AuthServiceImpl();
            this.blackList = new CopyOnWriteArrayList<>();
            new Thread(() ->{
                try {
                    autorization();
                    read();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    close();
                }
            }).start();
            if (!LogIn){
                Thread.sleep(120*1000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void read() {
        while (true) {
            try {
                String str = in.readUTF();
                if (str.equalsIgnoreCase("/end")) {
                    sendMsg("/serverclosed");
                    break;
                }else if (str.startsWith("/w")) {
                    String[] token = str.split(" ");
                    String string = " ";
                    for (String message : token) {
                        if (message == token[1]) string = "<" + message + "> ";
                        else string += " " + message;
                    }
                    System.out.println(nick + ": " + string);
                    sendMsg(nick + ": " + string);
                    server.prvMsg(token[1], string);
                }else if((str.startsWith("/blacklist "))){
                    String[] tokens = str.split(" ");
                    blackList.add(tokens[1]);
                    sendMsg(
                            "Вы добавили пользователя с ником " + tokens[1] + " в черный список!");
                }else {
                    server.broadcast(this,nick + ": " + str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void autorization() throws IOException {
        while (true) {
            String str = in.readUTF();
            if (str.startsWith("/auth")) {
                String[] tokens = str.split(" ");
                String newNick = authService.getNick(tokens[1], tokens[2]);
                if (newNick != null) {
                    nick = newNick;
                    sendMsg("/authOK");
                    server.subscribe(this);
                    break;
                } else {
                    sendMsg("Неверный логин/пароль");
                }
                LogIn = true;
            }
        }
    }

    private void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        server.unsubscribe(this);
    }

    void sendMsg(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    boolean checkBlackList(String nick) {
        return blackList.contains(nick);
    }
}

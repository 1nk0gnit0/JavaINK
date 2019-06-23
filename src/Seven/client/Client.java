package Seven.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class ClientApp {
    public static void main(String[] args) {
        Client w = new Client();
    }
}

class Client extends JFrame {

    JTextField jtf;
    JTextArea jta;

    final String SERVER_ADDR = "localhost";
    final int SERVER_PORT = 8182;
    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    public Client() {
        try {
            openConnection();
        } catch (IOException e) {
            System.out.println("Error connection");
            e.printStackTrace();
        }
        drawGUI();
    }

    private void authGUI() {
        setBounds(400, 400, 400, 100);
        setTitle("Authorization");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel authPanel = new JPanel(new GridLayout());
        JButton jbAuth = new JButton("OK");
        JTextField jtfLog = new JTextField("Login");
        JTextField jtfPass = new JTextField("Password");

        authPanel.add(jtfLog);
        authPanel.add(jtfPass);
        authPanel.add(jbAuth);
        add(authPanel, BorderLayout.NORTH);

        jta = new JTextArea();
        jta.setEditable(false);
        jta.setLineWrap(true);
        add(new JScrollPane(jta), BorderLayout.CENTER);

        setVisible(true);
    }

    private void chatGUI() {
        setBounds(400, 400, 400, 400);
        setTitle("Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jta = new JTextArea();
        jta.setEditable(false);
        jta.setLineWrap(true);
        add(new JScrollPane(jta), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton sendMessageButton = new JButton("Send");
        bottomPanel.add(sendMessageButton, BorderLayout.EAST);
        jtf = new JTextField();
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(jtf, BorderLayout.CENTER);
        sendMessageButton.addActionListener(e -> sendMessage());
        jtf.addActionListener(e -> sendMessage());

        setVisible(true);
    }

    private void closeConnection() {
        try {
            in.close();
        } catch (IOException e) {
            System.out.println("DataInputStream is already closed");
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            System.out.println("DataOutputStream is already closed");
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("Socket is already closed");
            e.printStackTrace();
        }
    }

    //        setBounds(600, 300, 500, 500);
//        setTitle("Client");
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jta = new JTextArea();
//        jta.setEditable(false);
//        jta.setLineWrap(true);
//        JScrollPane jsp = new JScrollPane(jta);
//        add(jsp, BorderLayout.CENTER);
//
//        JPanel bottomPanel = new JPanel(new BorderLayout());
//        JPanel authPanel = new JPanel(new GridLayout());
//
//        JTextField jtfLogin = new JTextField("Login");
//        JTextField jtfPass = new JTextField("Password");
//        JButton jbAuth = new JButton("Auth");
//        authPanel.add(jtfLogin);
//        authPanel.add(jtfPass);
//        authPanel.add(jbAuth);
//        jtfLogin.setToolTipText("Login");
//        jtfPass.setToolTipText("Password");
//        add(authPanel, BorderLayout.NORTH);
//
//        jbAuth.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                connect("auth\t" + jtfLogin.getText() + "\t" + jtfPass.getText());
//            }
//        });
//
//        add(bottomPanel, BorderLayout.SOUTH);
//        JButton jbSend = new JButton("SEND");
//        bottomPanel.add(jbSend, BorderLayout.EAST);
//        jtf = new JTextField();
//        bottomPanel.add(jtf, BorderLayout.CENTER);
//
//        jbSend.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                sendMsg();
//                jtf.grabFocus();
//            }
//        });
//
//        jtf.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                sendMsg();
//            }
//        });
//
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosed(WindowEvent e) {
//                super.windowClosed(e);
//                try {
//                    out.writeUTF("end");
//                    out.flush();
//                    out.close();
//                    in.close();
//                } catch (IOException exc) {
//                } finally {
//                    try {
//                        socket.close();
//                    } catch (IOException ex) {
//                    }
//                }
//            }
//        });
//
//        setVisible(true);
//    }
//
//    public void connect(String cmd) {
//        try {
//            socket = new Socket(SERVER_ADDR, SERVER_PORT);
//            in = new DataInputStream(socket.getInputStream());
//            out = new DataOutputStream(socket.getOutputStream());
//            out.writeUTF(cmd);
//            out.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    while (true) {
//                        String w = in.readUTF();
//                        if (w != null) {
//                            if (w.equalsIgnoreCase("end session")) break;
//                            jta.append(w);
//                            jta.append("\n");
//                            jta.setCaretPosition(jta.getDocument().getLength());
//                        }
//                        Thread.sleep(100);
//                    }
//                } catch (Exception e) {
//                }
//            }
//        }).start();
//    }
//
    private void sendMessage() {
        if (!jtf.getText().trim().isEmpty()) {
            try {
                out.writeUTF(jtf.getText());
                jtf.setText("");
                jtf.grabFocus();
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Send message error");
            }
        }
    }
}


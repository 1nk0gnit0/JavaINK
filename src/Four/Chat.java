package Four;

import javax.swing.*;
import java.awt.*;

class Chat extends JFrame {
    JPanel jp1 = new JPanel(new GridLayout());
    JPanel jp2 = new JPanel(new GridLayout());
    JButton jb = new JButton("Отправить");
    JTextField jtf = new JTextField(25);
    JTextArea jta = new JTextArea();
    JScrollPane jsp = new JScrollPane(jta);
    public Chat(){
        super("Окно чата");
        setSize(400,400);
        setMinimumSize(new Dimension(400,400));

        jp1.add(jsp);

        jp2.add(jtf);
        jp2.add(jb);

        add(jp1);
        add("South", jp2);

        jta.setLineWrap(true);
        jta.setEditable(false);

        jb.addActionListener(e ->{
            Message();
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    void Message() {
        String out = jtf.getText();
        jta.append(out + " \n");
        jtf.setText("");
    }
}

class Main{
    public static void main(String[] args){
        new Chat();
    }
}


package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class theWindow extends JFrame implements ActionListener {
    private JTextField textField;
    private JTextArea textArea;
    private String newline = "\n";

    private final Player joueur1 = new Player("J1");
    private final Player joueur2 = new Player("J2");
    private final Player joueur3 = new Player("J3");
    private final Player joueur4 = new Player("J4");

    public theWindow() {
        this.setSize(800, 600);
        this.setLocation(0,0);
        this.setTitle("Battleship");
    }

    public void initGUI() {
        /// NORTH ///
        JPanel MyPanel1 = new JPanel();

        MyPanel1.setLayout( new BorderLayout() );

        JButton x1 = new JButton("I am x1");
        JButton x2 = new JButton("I am x2");
        JButton x3 = new JButton("I am x3");
        JButton x4 = new JButton("I am x4");
        JButton x5 = new JButton("I am x5");

        MyPanel1.add(x1, "North");
        MyPanel1.add(x2, "South");
        MyPanel1.add(x3, "East");
        MyPanel1.add(x4, "West");
        MyPanel1.add(x5, "Center");

        this.getContentPane().add( MyPanel1, "North");   // Add MyPanel1 to North

        // -----------------------------------------------------------
        // Make another Panel with 5 button
        // -----------------------------------------------------------
        JPanel MyPanel2 = new JPanel();

        MyPanel2.setLayout( new BorderLayout() );

        JButton x6 = new JButton("I am x6");
        JButton x7 = new JButton("I am x7");
        JButton x8 = new JButton("I am x8");
        JButton x9 = new JButton("I am x9");
        JButton x10 = new JButton("I am x10");

        MyPanel2.add(x6, "North");
        MyPanel2.add(x7, "South");
        MyPanel2.add(x8, "East");
        MyPanel2.add(x9, "West");
        MyPanel2.add(x10, "Center");


        // Add personal and opponent(s) grids
        JTabbedPane myOnglet = new JTabbedPane();

        this.addGrid(myOnglet, joueur1);
        this.addGrid(myOnglet, joueur2);
        this.getContentPane().add(myOnglet, BorderLayout.WEST);

        JTabbedPane opponentOnglet = new JTabbedPane();

        this.addGrid(opponentOnglet, joueur3);
        this.addGrid(opponentOnglet, joueur4);
        this.getContentPane().add(opponentOnglet, BorderLayout.EAST);

        // Add Chat
        this.addChat();

        this.setVisible(true);
        }

        public void addGrid(JTabbedPane tabbedPane, Player player){
            JPanel card = new JPanel();
            card.add(player.gridPlayer);
            tabbedPane.addTab(player.namePlayer, card);
        }


    public void addChat(){
        /*
        @Author : Tom
        Function to implement chat
         */
        JPanel pChat = new JPanel();
        pChat.setLayout(new BorderLayout());

        textField = new JTextField(20);
        textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        /*
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(this);
        pChat.add(sendButton, "East");          // send message button
        */

        textField.addActionListener(this);

        pChat.add(scrollPane, "Center");         // Zone de texte
        pChat.add(textField, "South");         // Zone d'édition
        this.getContentPane().add(pChat, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime now = LocalTime.now();

        String text = textField.getText(); // Get the text in zone d'édition
        textArea.append(now + " Player 1: " + text + newline); // Write the text in zone de visuel <- message à envoyer
        textField.setText(""); // Empty the zone d'édition
    }

}


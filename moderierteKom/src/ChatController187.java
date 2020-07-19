import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ChatController187 extends JFrame
{
    private GridBagConstraints c = new GridBagConstraints();

    private List<Chat> chatList = new ArrayList<Chat>();

    private JPanel panel = new JPanel();

    private JTextField chatAuswahl = new JTextField("0-0");
    private JTextField id = new JTextField("id");
    private JTextField nachricht = new JTextField("nachricht");
    private JTextField name = new JTextField("name");

    private JLabel label = new JLabel();

    private JButton ban = new JButton("ban");
    private JButton unban = new JButton("unban");
    private JButton modMode = new JButton("modmode");
    private JButton addMod = new JButton("+mod");
    private JButton deleteMod = new JButton("-mod");
    private JButton send = new JButton("ok");
    private JButton deleteMessage = new JButton("löschen");

    ChatController187(List<Chat> chats)
    {
        chatList = chats;

        int cc = chats.size()-1;
        String s = "0-"+cc;

        chatAuswahl.setText(s);

        chatAuswahl.setPreferredSize(new Dimension(100,20));
        id.setPreferredSize(new Dimension(100,20));
        nachricht.setPreferredSize(new Dimension(100,20));
        name.setPreferredSize(new Dimension(100,20));

        label.setText("Info: bei löschen bei ´id´ id von nachricht (1. nachricht = 0)");

        setSize(new Dimension(500,500));
        panel.setLayout(new GridBagLayout());
        c.gridx = 0; c.gridy = 0;
        panel.add(chatAuswahl, c);
        c.gridx = 1;
        panel.add(nachricht, c);
        c.gridx = 2;
        panel.add(name, c);
        c.gridx = 3;
        panel.add(id, c);
        c.gridx = 0; c.gridy = 1;
        panel.add(ban, c);
        c.gridx = 1;
        panel.add(unban, c);
        c.gridx = 2;
        panel.add(addMod, c);
        c.gridx = 3;
        panel.add(deleteMod, c);
        c.gridy = 2; c.gridx = 0;
        panel.add(modMode, c);
        c.gridx = 1;
        panel.add(send, c);
        c.gridx = 2;
        panel.add(deleteMessage, c);
        c.gridy = 3; c.gridx = 0; c.gridwidth = 4;
        panel.add(label, c);

        ban.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    chatList.get(Integer.valueOf(chatAuswahl.getText())).addBan(Integer.valueOf(id.getText()), 187); // bzw. System aber 187
                    label.setText("");
                }
                catch(IndexOutOfBoundsException e1)
                {
                    label.setText("Zu hohe Zahl bei chatAuswahl, beachte angegebene Zahlen");
                    chatAuswahl.setText(s);
                }
                catch(NumberFormatException e1)
                {
                    label.setText("Buchstaben statt Zahlen?");
                    name.setText("name");
                    nachricht.setText("nachricht");
                    id.setText("id");
                }
            }
        });
        unban.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    chatList.get(Integer.valueOf(chatAuswahl.getText())).deleteBan(Integer.valueOf(id.getText()), 187); // bzw. System aber 187
                    label.setText("");
                }
                catch(IndexOutOfBoundsException e1)
                {
                    label.setText("Zu hohe Zahl bei chatAuswahl, beachte angegebene Zahlen");
                    chatAuswahl.setText(s);
                }
                catch(NumberFormatException e1)
                {
                    label.setText("Buchstaben statt Zahlen?");
                    name.setText("name");
                    nachricht.setText("nachricht");
                    id.setText("id");
                }
            }
        });
        modMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    chatList.get(Integer.valueOf(chatAuswahl.getText())).modModus(187); // bzw. System aber 187
                    label.setText("");
                }
                catch(IndexOutOfBoundsException e1)
                {
                    label.setText("Zu hohe Zahl bei chatAuswahl, beachte angegebene Zahlen");
                    chatAuswahl.setText(s);
                }
                catch(NumberFormatException e1)
                {
                    label.setText("Buchstaben statt Zahlen?");
                    name.setText("name");
                    nachricht.setText("nachricht");
                    id.setText("id");
                }
            }
        });
        addMod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    chatList.get(Integer.valueOf(chatAuswahl.getText())).addModerator(Integer.valueOf(id.getText()), 187); // bzw. System aber 187
                    label.setText("");
                }
                catch(IndexOutOfBoundsException e1)
                {
                    label.setText("Zu hohe Zahl bei chatAuswahl, beachte angegebene Zahlen");
                    chatAuswahl.setText(s);
                }
                catch(NumberFormatException e1)
                {
                    label.setText("Buchstaben statt Zahlen?");
                    name.setText("name");
                    nachricht.setText("nachricht");
                    id.setText("id");
                }
            }
        });
        deleteMod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    chatList.get(Integer.valueOf(chatAuswahl.getText())).deleteModerator(Integer.valueOf(id.getText()), 187); // bzw. System aber 187
                    label.setText("");
                }
                catch(IndexOutOfBoundsException e1)
                {
                    label.setText("Zu hohe Zahl bei chatAuswahl, beachte angegebene Zahlen");
                    chatAuswahl.setText(s);
                }
                catch(NumberFormatException e1)
                {
                    label.setText("Buchstaben statt Zahlen?");
                    name.setText("name");
                    nachricht.setText("nachricht");
                    id.setText("id");
                }
            }
        });
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    chatList.get(Integer.valueOf(chatAuswahl.getText())).addNachricht(new Nachricht(name.getText(), Integer.valueOf(id.getText()), nachricht.getText())); // bzw. System aber 187
                    label.setText("");
                }
                catch(IndexOutOfBoundsException e1)
                {
                    label.setText("Zu hohe Zahl bei chatAuswahl, beachte angegebene Zahlen");
                    chatAuswahl.setText(s);
                }
                catch(NumberFormatException e1)
                {
                    label.setText("Buchstaben statt Zahlen?");
                    name.setText("name");
                    nachricht.setText("nachricht");
                    id.setText("id");
                }
            }
        });
        deleteMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    chatList.get(Integer.valueOf(chatAuswahl.getText())).delMes(Integer.valueOf(id.getText())); // bzw. System aber 187
                    label.setText("");
                }
                catch(IndexOutOfBoundsException e1)
                {
                    label.setText("Zu hohe Zahl bei chatAuswahl, beachte angegebene Zahlen");
                    chatAuswahl.setText(s);
                }
                catch(NumberFormatException e1)
                {
                    label.setText("Buchstaben statt Zahlen?");
                    name.setText("name");
                    nachricht.setText("nachricht");
                    id.setText("id");
                }
            }
        });

        chatVerlauf();

        add(panel);
        setVisible(true);
    }
    private void chatVerlauf() // NAME ID NACHRICHT
    {
        String s = "Ich\nmuss\nein\nwenig\nPlatz\nauffüllen\ndamit\nkein\nleerer\nPlatz\nda\nist\n:)";

        // Chat 1:
        chatList.get(0).addNachricht(new Nachricht("187", 187, s));
        chatList.get(0).addNachricht(new Nachricht("Nico", 1, "323<307<187 real talk"));
        chatList.get(0).addNachricht(new Nachricht("Deniz", 2, "nenenene"));
        chatList.get(0).addNachricht(new Nachricht("Deniz", 2, "323<187<307"));
        chatList.get(0).addNachricht(new Nachricht("Sebastian", 4, "?????"));
        chatList.get(0).addNachricht(new Nachricht("Anton", 3, "bittespieltlolmitmir:)"));
        chatList.get(0).addNachricht(new Nachricht("Nico", 1, "ne"));
        chatList.get(0).addNachricht(new Nachricht("Deniz", 2, "ne"));
        chatList.get(0).addNachricht(new Nachricht("Sebastian", 4, "ne"));
        chatList.get(0).addNachricht(new Nachricht("Julius", 5, "ne"));
        chatList.get(0).addNachricht(new Nachricht("System", -1, "ne"));
        chatList.get(0).addNachricht(new Nachricht("Deniz", 2, "hahahaha vom system hops genommen"));
        chatList.get(0).addNachricht(new Nachricht("187", 187, "187"));

        // Chat 2:
        chatList.get(1).addNachricht(new Nachricht("187", 187, s));
        chatList.get(1).addNachricht(new Nachricht("Nico", 1, "hi"));
        chatList.get(1).addNachricht(new Nachricht("Deniz", 2, "hi"));
        chatList.get(1).addNachricht(new Nachricht("Deniz", 2, "was geht"));
        chatList.get(1).addNachricht(new Nachricht("Sebastian", 4, "mein kühlschrank"));
        chatList.get(1).addNachricht(new Nachricht("Anton", 3, "meiner fliegt"));
        chatList.get(1).addNachricht(new Nachricht("187", 187, "187"));
        chatList.get(1).addNachricht(new Nachricht("Nico", 1, "meiner ist leer :("));
        chatList.get(1).addNachricht(new Nachricht("Deniz", 2, ":("));
        chatList.get(1).addNachricht(new Nachricht("Sebastian", 4, ":("));
        chatList.get(1).addNachricht(new Nachricht("Julius", 5, "ja"));
        chatList.get(1).addNachricht(new Nachricht("Deniz", 2, "ne"));

        // Chat 3:
        chatList.get(2).addNachricht(new Nachricht("187", 187, s));
        chatList.get(2).addNachricht(new Nachricht("187", 187, s));
        chatList.get(2).addNachricht(new Nachricht("Sebastian", 4, "heute essen gehen?"));
        chatList.get(2).addNachricht(new Nachricht("Deniz", 2, "essen bestellen?"));
        chatList.get(2).addNachricht(new Nachricht("Nico", 1, "essen kaufen?"));
        chatList.get(2).addNachricht(new Nachricht("187", 187, "187"));
        chatList.get(2).addNachricht(new Nachricht("Anton", 3, "essen essen?"));
        chatList.get(2).addNachricht(new Nachricht("Julius", 5, "wann?"));

        // Chat 4:
        chatList.get(3).addNachricht(new Nachricht("187", 187, s));
        chatList.get(3).addNachricht(new Nachricht("187", 187, s));
        chatList.get(3).addNachricht(new Nachricht("Julius", 5, "ist unser projekt jetzt eigentlich fertig?"));
        chatList.get(3).addNachricht(new Nachricht("Nico", 1, "nein"));
        chatList.get(3).addNachricht(new Nachricht("Anton", 3, "warum"));
        chatList.get(3).addNachricht(new Nachricht("Nico", 1, "weil niemand lust und laune hat die datenbank zu machen"));
        chatList.get(3).addNachricht(new Nachricht("Deniz", 2, "is wie is"));
        chatList.get(3).addNachricht(new Nachricht("187", 187, "187"));
        chatList.get(3).addNachricht(new Nachricht("Nico", 1, "ja der rest funkt ja eh"));

        // Chat 5:
        chatList.get(4).addNachricht(new Nachricht("187", 187, s));
        chatList.get(4).addNachricht(new Nachricht("187", 187, s));
        chatList.get(4).addNachricht(new Nachricht("Nico", 1, "jungs hat jemand bock auf komische chatverläufe zu machen für projekt"));
        chatList.get(4).addNachricht(new Nachricht("Nico", 1, "hallo?"));
        chatList.get(4).addNachricht(new Nachricht("Nico", 1, "nein??"));
        chatList.get(4).addNachricht(new Nachricht("Deniz", 2, "in den sommerferien hätte ich zeit"));
        chatList.get(4).addNachricht(new Nachricht("187", 187, "187"));

        // Chat 6:
        chatList.get(5).addNachricht(new Nachricht("187", 187, s));
        chatList.get(5).addNachricht(new Nachricht("187", 187, s));
        chatList.get(5).addNachricht(new Nachricht("187", 187, s));
        chatList.get(5).addNachricht(new Nachricht("Anton", 3, "warum eigentlich so viele chats?"));
        chatList.get(5).addNachricht(new Nachricht("Anton", 3, "ist doch eh überall der gleiche drin"));
        chatList.get(5).addNachricht(new Nachricht("Nico", 1, "187"));
        chatList.get(5).addNachricht(new Nachricht("Julius", 5, "chat 7"));
        chatList.get(5).addNachricht(new Nachricht("Deniz", 2, "nein 6"));

        // Chat 7:
        chatList.get(6).addNachricht(new Nachricht("187", 187, s));
        chatList.get(6).addNachricht(new Nachricht("187", 187, s));
        chatList.get(6).addNachricht(new Nachricht("Julius", 5, "chat 7"));
        chatList.get(6).addNachricht(new Nachricht("Nico", 1, "ja"));
        chatList.get(6).addNachricht(new Nachricht("Anton", 3, "wer is hier admin"));
        chatList.get(6).addNachricht(new Nachricht("Nico", 1, "niemand"));
        chatList.get(6).addNachricht(new Nachricht("Deniz", 2, "warum"));
        chatList.get(6).addNachricht(new Nachricht("Nico", 1, "weil niemand id 7 hat"));
        chatList.get(6).addNachricht(new Nachricht("Nico", 1, "aber 187 überall moderator"));
        chatList.get(6).addNachricht(new Nachricht("187", 187, "187"));

        // Chat 8:
        chatList.get(7).addNachricht(new Nachricht("187", 187, s));
        chatList.get(7).addNachricht(new Nachricht("Nico", 1, "moin"));
        chatList.get(7).addNachricht(new Nachricht("Deniz", 2, "moin"));
        chatList.get(7).addNachricht(new Nachricht("Deniz", 2, "moin"));
        chatList.get(7).addNachricht(new Nachricht("Sebastian", 4, "moin"));
        chatList.get(7).addNachricht(new Nachricht("Anton", 3, "moin"));
        chatList.get(7).addNachricht(new Nachricht("Nico", 1, "moin"));
        chatList.get(7).addNachricht(new Nachricht("Deniz", 2, "ne"));
        chatList.get(7).addNachricht(new Nachricht("187", 187, "ne"));
        chatList.get(7).addNachricht(new Nachricht("Sebastian", 4, "ne"));
        chatList.get(7).addNachricht(new Nachricht("Julius", 5, "ne"));
        chatList.get(7).addNachricht(new Nachricht("System", -1, "ne"));

        // Chat 9:
        chatList.get(8).addNachricht(new Nachricht("187", 187, s));
        chatList.get(8).addNachricht(new Nachricht("Nico", 1, "chat 9"));
        chatList.get(8).addNachricht(new Nachricht("Deniz", 2, "nein"));
        chatList.get(8).addNachricht(new Nachricht("Deniz", 2, "warte doch"));
        chatList.get(8).addNachricht(new Nachricht("Sebastian", 4, "doch"));
        chatList.get(8).addNachricht(new Nachricht("Anton", 3, "warum machen die chats nach unten hin immer weniger sinn"));
        chatList.get(8).addNachricht(new Nachricht("Nico", 1, "hmmm"));
        chatList.get(8).addNachricht(new Nachricht("187", 187, "jap"));
        chatList.get(8).addNachricht(new Nachricht("Deniz", 2, "lust und laune"));
        chatList.get(8).addNachricht(new Nachricht("Sebastian", 4, "genau"));
        chatList.get(8).addNachricht(new Nachricht("Julius", 5, "wie jetzt"));

        // Chat 10:
        chatList.get(9).addNachricht(new Nachricht("187", 187, s));
        chatList.get(9).addNachricht(new Nachricht("187", 187, s));
        chatList.get(9).addNachricht(new Nachricht("Sebastian", 4, "we made it"));
        chatList.get(9).addNachricht(new Nachricht("Deniz", 2, "chat 10 juhu"));
        chatList.get(9).addNachricht(new Nachricht("Nico", 1, "finally obamium"));
        chatList.get(9).addNachricht(new Nachricht("Anton", 3, "obama"));
        chatList.get(9).addNachricht(new Nachricht("187", 187, "obamium"));
        chatList.get(9).addNachricht(new Nachricht("Julius", 5, "finally"));

    }
}
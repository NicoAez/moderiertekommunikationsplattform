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

    ChatController187(List<Chat> chats)
    {
        chatList = chats;

        chatAuswahl.setText("0-"+chatList.size());

        chatAuswahl.setPreferredSize(new Dimension(100,20));
        id.setPreferredSize(new Dimension(100,20));
        nachricht.setPreferredSize(new Dimension(100,20));
        name.setPreferredSize(new Dimension(100,20));

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
        c.gridx = 2; c.gridwidth = 2;
        panel.add(label, c);

        int c = chats.size()-1;
        String s = "0-"+c;

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

        add(panel);
        setVisible(true);
    }
}
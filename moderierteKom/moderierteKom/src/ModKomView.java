import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;
import java.util.List;

public class ModKomView extends JFrame
{
    //Panels
    private List<anzeigeChat> chatCard = new ArrayList<anzeigeChat>(); // JPanels für Chats [!] evtl. Austausch durch "Chat" als Pane itsself (zukunft)
    private JPanel leftPane = new JPanel(); // Panel links für die Knöpfe
    private JPanel chatPane = new JPanel(); // Panel für die Chats
    private JTabbedPane topPane = new JTabbedPane(); // temporär tabbedPane, oder permanent weils sowieso funktioniert xd haha lustig :D
    private JPanel topPaneS = new JPanel(); // standard top panel
    private JPanel topPaneA = new JPanel(); // top panel mit erweiterten Funktionen, nach Auswahl einer Nachricht
    private JPanel viewPane = new JPanel(); // Panel mit cardLayout für Anmelde- und das normale Panel
    private JPanel panel = new JPanel(); // standard panel
    private JPanel anmeldePane = new JPanel(); // anmelde panel
    //Buttons
    private List<JButton> button = new ArrayList<JButton>(); // Buttons zum Auswahl der Chats
    private JButton closeButtonA = new JButton();
    private JButton closeButtonS = new JButton();
    private JButton closeButtonAF = new JButton();
    private JButton banButton = new JButton("ban");
    private JButton unbanButton = new JButton("unban");
    private JButton deleteButton = new JButton("loeschen");
    private JButton modModeButton = new JButton("mod only mode");
    private JButton okButton = new JButton("ok");
    //AnderesZeug
    private JTextField nameField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JLabel label = new JLabel();
    //Farben
    private Color nein = Color.red;
    private Color ja = new Color(59, 186, 36);
    private Color haupt = new Color(43, 43, 44);
    private Color hauptA = new Color(120, 120, 120);
    private Color fore = Color.white;
    //function
    public static Point punkt;     // Schönheit ohne Rand bedeutet auch kein click and drag
    public static Point aktuell;   // deshalb fügen wir es hinzu :flushed: cringe btw
    public static CardLayout cL = new CardLayout();

    public ModKomView(int anzahlChat)
    {
        //allgemein
        this.setResizable(false);
        this.setSize(new Dimension(1300,800));
        this.setTitle("MODKOM | moderierte Kommunikationsplattform");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setUndecorated(true);
        //abhängig
        for(int i = 0; i<anzahlChat; i++)
        {
            chatCard.add(new anzeigeChat());
            button.add(new JButton());
            button.get(i).setPreferredSize(new Dimension(10,10));
            button.get(i).setText("Chat "+(i+1));
            button.get(i).setBorder(BorderFactory.createEtchedBorder());
            button.get(i).setBackground(haupt.brighter());
            button.get(i).setForeground(fore);
            button.get(i).setFocusPainted(false);
        }
        //buttons
        closeButtonA.setPreferredSize(new Dimension(50,50));
        closeButtonA.setBackground(nein);
        closeButtonA.setBorderPainted(false);
        closeButtonA.setFont(new Font("Roboto", Font.BOLD, 20));
        closeButtonA.setFocusPainted(false);
        closeButtonA.setText("X");

        closeButtonS.setPreferredSize(new Dimension(50,50));
        closeButtonS.setBackground(nein);
        closeButtonS.setBorderPainted(false);
        closeButtonS.setFont(new Font("Roboto", Font.BOLD, 20));
        closeButtonS.setFocusPainted(false);
        closeButtonS.setText("X");

        closeButtonAF.setPreferredSize(new Dimension(200,200));
        closeButtonAF.setBackground(nein);
        closeButtonAF.setBorderPainted(false);
        closeButtonAF.setFont(new Font("Roboto", Font.BOLD, 20));
        closeButtonAF.setFocusPainted(false);
        closeButtonAF.setText("X");

        okButton.setPreferredSize(new Dimension(200, 200));
        okButton.setBackground(ja);
        okButton.setBorderPainted(false);
        okButton.setFont(new Font("Roboto", Font.BOLD, 20));
        okButton.setFocusPainted(false);

        banButton.setPreferredSize(new Dimension(100,50));
        banButton.setBorderPainted(false);
        banButton.setFocusPainted(false);

        unbanButton.setPreferredSize(new Dimension(100,50));
        unbanButton.setBorderPainted(false);
        unbanButton.setFocusPainted(false);

        deleteButton.setPreferredSize(new Dimension(100,50));
        deleteButton.setBorderPainted(false);
        deleteButton.setFocusPainted(false);

        modModeButton.setPreferredSize(new Dimension(100,50));
        modModeButton.setBorderPainted(false);
        modModeButton.setFocusPainted(false);

        //anderes
        nameField.setPreferredSize(new Dimension(200, 200));
        nameField.setFont(new Font("Optima", Font.BOLD, 43));
        nameField.setBackground(hauptA);
        nameField.setForeground(fore);
        nameField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Name", TitledBorder.LEFT, TitledBorder.LEFT, new Font("Optima", Font.PLAIN, 20)));
        nameField.setToolTipText("Name eingeben");

        passwordField.setPreferredSize(new Dimension(200, 200));
        passwordField.setFont(new Font("Optima", Font.BOLD, 43));
        passwordField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Passwort", TitledBorder.LEFT, TitledBorder.LEFT, new Font("Optima", Font.PLAIN, 20)));
        passwordField.setToolTipText("Passwort eingeben");
        passwordField.setBackground(hauptA);
        passwordField.setForeground(fore);


        label.setPreferredSize(new Dimension(300,100));
        label.setForeground(fore);
        label.setFont(new Font("VT323", Font.BOLD, 43));
        label.setText("Willkommen bei der moderiertenKommunikationsplattform. Bitte anmelden!");

        //viewPane
        viewPane.setSize(new Dimension(1300,800));
        viewPane.setLayout(cL);
        this.add(viewPane);
        //anmeldePanel
        GridBagConstraints c = new GridBagConstraints();
        anmeldePane.setBackground(hauptA);
        anmeldePane.setLayout(new GridBagLayout());
        anmeldePane.setSize(new Dimension(1300, 800));
        c.gridx = 0; c.gridy = 0; c.fill = GridBagConstraints.BOTH; c.insets = new Insets(0,0,0,0); c.weighty = 1300;
        anmeldePane.add(label, c);
        c.gridy = 2;
        anmeldePane.add(nameField, c);
        c.gridy = 3;
        anmeldePane.add(passwordField, c);
        c.gridy = 4;
        anmeldePane.add(okButton, c);
        c.gridy = 5;
        anmeldePane.add(closeButtonAF, c);
        viewPane.add("anmeldefenster",anmeldePane);
        //panel
        panel.setPreferredSize(new Dimension(1300,800));
        panel.setLayout(new BorderLayout());
        viewPane.add("standard",panel);
        //topPaneS
        topPaneS.setBackground(haupt);
        topPaneS.setLayout(new FlowLayout()); // vorerst FlowLayout, aus designgründen später wsl. was anderes
        topPaneS.setPreferredSize(new Dimension(1300,50));
        topPaneS.add(modModeButton);
        topPaneS.add(closeButtonS);
        //topPaneA
        topPaneA.setBackground(haupt);
        topPaneA.setLayout(new FlowLayout()); // siehe oben
        topPaneA.setPreferredSize(new Dimension(1300,50));
        topPaneA.add(banButton);
        topPaneA.add(unbanButton);
        topPaneA.add(deleteButton);
        topPaneA.add(closeButtonA);
        //topPane
        topPane.setLayout(new CardLayout());
        topPane.add("S", topPaneS);
        topPane.add("A", topPaneA);
        panel.add(topPane, BorderLayout.NORTH);
        //leftPane
        leftPane.setLayout(new GridLayout(button.size(),1));
        leftPane.setPreferredSize(new Dimension(300,600));
        for(int i = 0; i<button.size(); i++)
        {
            button.get(i).setName(String.valueOf(i));
            leftPane.add(button.get(i));
        }
        panel.add(leftPane, BorderLayout.WEST);
        //chatPane
        chatPane.setBorder(BorderFactory.createLineBorder(Color.white));
        chatPane.setPreferredSize(new Dimension(1000,600));
        chatPane.setLayout(cL);
        for(int i = 0; i<chatCard.size(); i++)
        {
            chatCard.get(i).setName(String.valueOf(i));
            chatPane.add(chatCard.get(i).getName(), chatCard.get(i));
        }
        panel.add(chatPane, BorderLayout.EAST);

        //function
        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e){}
            @Override
            public void mousePressed(MouseEvent e){punkt = e.getPoint();}
            @Override
            public void mouseReleased(MouseEvent e){punkt = null;}
            @Override
            public void mouseEntered(MouseEvent e){}
            @Override
            public void mouseExited(MouseEvent e){}
        };
        MouseMotionListener mouseMotionListener = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent event)
            {
                aktuell = event.getLocationOnScreen();
                ModKomView.super.setLocation(aktuell.x - punkt.x, aktuell.y - punkt.y);
            }
            @Override
            public void mouseMoved(MouseEvent e){}
        };
        topPane.addMouseListener(mouseListener);
        anmeldePane.addMouseListener(mouseListener);
        topPane.addMouseMotionListener(mouseMotionListener);
        anmeldePane.addMouseMotionListener(mouseMotionListener);

        //end
        cL.show(viewPane, "anmeldefenster");
        this.setVisible(true);
    }

    //Methoden
    void switchTopPane(int i)
    {
        if(i==1)
        {
            topPane.setSelectedComponent(topPaneA);
        }
        else
        {
            topPane.setSelectedComponent(topPaneS);
        }
    }
    List<anzeigeChat> getChat()
    {
        return chatCard;
    }
    void clear()
    {
        for(int i = 0; i<chatCard.size(); i++)
        {
            chatCard.get(i).clear();
        }
    }
    String getAName()
    {
        return nameField.getText();
    }
    String getAPasswort()
    {
        return String.valueOf(passwordField.getPassword());
    }
    void login(boolean b)
    {
        if(b)
        {
            cL.show(viewPane, "standard");
        }
        else
        {
            label.setText("Der angegebene Name oder das angegebene Passwort ist falsch!       :( ");
            label.setForeground(nein);
        }
    }
    void changerino(int id)
    {
        changeChat(button.get(9));
        changeChat(button.get(id));
    }
    String changeChat(Object o)
    {
        String s = "";
        for(int i = 0; i<button.size(); i++)
        {
            button.get(i).setBorder(BorderFactory.createEtchedBorder());
            if(button.get(i) == o)
            {
                s = button.get(i).getName();
                button.get(i).setBorder(BorderFactory.createLineBorder(Color.white));
            }
        }
        cL.show(chatPane, s);
        return s; // wir machen einfach so als ob das immer funktioniert, wenn es nicht funktioniert haben wir ein ganz anderes großes Problem
    }
    String einsachtsieben(Object o, int c)
    {
        return chatCard.get(c).getID(o);
    }
    String getNachricht(int i)
    {
        return chatCard.get(i).getNachricht();
    }

    //ActionListener
    void alCloseButton(ActionListener al)
    {
        closeButtonA.addActionListener(al);
        closeButtonS.addActionListener(al);
        closeButtonAF.addActionListener(al);
    }
    void alBanButton(ActionListener al)
    {
        banButton.addActionListener(al);
    }
    void alUnbanButton(ActionListener al)
    {
        unbanButton.addActionListener(al);
    }
    void alDeleteButton(ActionListener al)
    {
        deleteButton.addActionListener(al);
    }
    void alModButton(ActionListener al)
    {
        modModeButton.addActionListener(al);
    }
    void alOkButton(ActionListener al)
    {
        okButton.addActionListener(al);
    }
    void alNachricht(ActionListener al)
    {
        for(int i = 0; i<chatCard.size(); i++)
        {
            chatCard.get(i).alNachricht(al);
        }
    }
    void alChatButton(ActionListener al)
    {
        for(int i = 0; i<button.size(); i++)
        {
            button.get(i).addActionListener(al);
        }
    }
    void alACButton(ActionListener al)
    {
        for(int i = 0; i< chatCard.size(); i++)
        {
            chatCard.get(i).alButton(al);
        }
    }
}

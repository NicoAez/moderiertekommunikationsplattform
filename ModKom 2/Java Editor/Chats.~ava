import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.Hashtable;
import javax.swing.*;
import javax.swing.event.*;

public class Chats extends JFrame {
  // Anfang Attribute
  private JButton bOeffnen = new JButton();
  private JPanel jPanel1 = new JPanel(null, true);
  private JButton bSchliessen = new JButton();
  private JLabel lEinstellungen = new JLabel();
  private JButton bEinstellungen = new JButton();
  private JButton bNeuerChat = new JButton();
  
  
  //Diese Variable soll die Chats durchnummerieren, daher nach dem Erstllen eines Chats Wert++
  private int chatNummer = 1;
  //Vorrübergehende Variable um Text nach oben zu schieben, aber in falsche Richtung
  private int nachrichtPosition = 1;
  //Für Chatfenster
  JPanel jPanel = new JPanel(null, true);
  JButton bNachrichtabsenden = new JButton();
  JButton bChatschliessen = new JButton(); 
  private JTextField jTextField1 = new JTextField();
  
  // Ende Attribute
  
  public Chats() {
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 1280; 
    int frameHeight = 720;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Chats");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
   
    // Anfang Komponenten
    jPanel1.setBounds(300, 180, 564, 276);
    jPanel1.setOpaque(false);
    jPanel1.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 4));
    jPanel1.setVisible(false);
    cp.add(jPanel1);
    bSchliessen.setBounds(471, 240, 75, 25);
    bSchliessen.setText("Schließen");
    bSchliessen.setMargin(new Insets(2, 2, 2, 2));
    bSchliessen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bSchliessen_ActionPerformed(evt);
        jPanel1.setVisible(false);
      }
    });
    jPanel1.add(bSchliessen);
    lEinstellungen.setBounds(13, 10, 124, 25);
    lEinstellungen.setText("Einstellungen");
    lEinstellungen.setFont(new Font("Dialog", Font.BOLD, 18));
    jPanel1.add(lEinstellungen);
    bEinstellungen.setBounds(22, 15, 107, 25);
    bEinstellungen.setText("Einstellungen");
    bEinstellungen.setMargin(new Insets(2, 2, 2, 2));
    bEinstellungen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bEinstellungen_ActionPerformed(evt);
        jPanel1.setVisible(true);
      }
    });
    cp.add(bEinstellungen);
    bNeuerChat.setBounds(148, 15, 107, 25);
    bNeuerChat.setText("Neuer Chat");
    bNeuerChat.setMargin(new Insets(2, 2, 2, 2));
    bNeuerChat.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bNeuerChat_ActionPerformed(evt);
        chatÖffnen(271, 78, 772, 556);
        
        
        jTextField1.setBounds(330, 575, 500, 52);  
        cp.add(jTextField1);
        JButton bChatName = new JButton();
    
        bChatName.setBounds(30, 80 * chatNummer, 100, 30);
        bChatName.setText("Chat " + chatNummer);
        bChatName.setMargin(new Insets(2, 2, 2, 2));
        bChatName.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent evt) { 
            jPanel.setVisible(true);
            jTextField1.setVisible(true);
      }
    });
        cp.add(bChatName);
        chatNummer++;   
      }
    });
    cp.add(bNeuerChat);
  
    
    // Ende Komponenten
    setVisible(true);
  }

  // Anfang Methoden
  
  public static void main(String[] args) {
    new Chats();
  } // end of main
      
  public void chatÖffnen(int xPos, int yPos, int xSize, int ySize) {
    
  
    jPanel.setBounds(xPos, yPos, xSize, ySize);
    jPanel.setOpaque(false);
    jPanel.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 4));
    jPanel.setVisible(true);
    jTextField1.setBounds(24, 510, 534, 40);
    jPanel.add(jTextField1);
    bNachrichtabsenden.setBounds(574, 509, 163, 40);
    bNachrichtabsenden.setText("Nachricht absenden");
    bNachrichtabsenden.setMargin(new Insets(2, 2, 2, 2));
    bNachrichtabsenden.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        String Nachricht = jTextField1.getText();
        JLabel lNachricht = new JLabel();  
        
        lNachricht.setBounds(600,450 - 40 * nachrichtPosition,300,100);
        lNachricht.setText(Nachricht); 
        lNachricht.setFont(new Font("Dialog", Font.BOLD, 16));
        jPanel.add(lNachricht);
        lNachricht.repaint();
        nachrichtPosition++;
      }
    });
    jPanel.add(bNachrichtabsenden);
    bChatschliessen.setBounds(644, 12, 115, 25);
    bChatschliessen.setText("Chat schließen");
    bChatschliessen.setMargin(new Insets(2, 2, 2, 2));
    bChatschliessen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        //bChatschliessen_ActionPerformed(evt);
        jPanel.setVisible(false);
        jTextField1.setVisible(false);
      }
    });
    jPanel.add(bChatschliessen);
    jPanel.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 4));
    
    
    
    this.add(jPanel);
    this.repaint();
  }
  
  
  public void bOeffnen_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of bOeffnen_ActionPerformed

  public void bSchliessen_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of bSchliessen_ActionPerformed

  public void bEinstellungen_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen


  } // end of bEinstellungen_ActionPerformed

  public void bNeuerChat_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of bNeuerChat_ActionPerformed

  // Ende Methoden
} // end of class BankOverlay


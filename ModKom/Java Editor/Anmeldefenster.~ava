import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.Hashtable;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JFrame;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 09.03.2020
 * @author 
 */

public class Anmeldefenster extends JFrame{
  // Anfang Attribute
  
  private JLabel lModKom = new JLabel();
  private JLabel lHerzlichWillkommen = new JLabel();
  private JTextField jTextField1 = new JTextField();
  private JTextField jTextField2 = new JTextField();
  private JLabel lBenutzername = new JLabel();
  private JLabel lPasswort = new JLabel();
  private JButton bLogin = new JButton();
  private JButton bNochKeinenAccount = new JButton();
  
  private String benutzername = "Admin";
  private String passwort = "1234";
  
  JLabel lLeer = new JLabel();
  JLabel lErstellt = new JLabel();
  // Ende Attribute
  
  public Anmeldefenster() { 
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
    setTitle("Anmeldefenster");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    
    lModKom.setBounds(50, 18, 110, 33);
    lModKom.setText("ModKom");
    lModKom.setFont(new Font("Dialog", Font.BOLD, 24));
    cp.add(lModKom);
    lHerzlichWillkommen.setBounds(50, 60, 207, 28);
    lHerzlichWillkommen.setText("Herzlich Willkommen!");
    lHerzlichWillkommen.setFont(new Font("Dialog", Font.BOLD, 20));
    cp.add(lHerzlichWillkommen);
    jTextField1.setBounds(233, 122, 150, 20);
    cp.add(jTextField1);
    jTextField2.setBounds(233, 167, 150, 20);
    cp.add(jTextField2);
    lBenutzername.setBounds(70, 122, 110, 20);
    lBenutzername.setText("Benutzername");
    cp.add(lBenutzername);
    lPasswort.setBounds(70, 167, 110, 20);
    lPasswort.setText("Passwort");
    cp.add(lPasswort);
    bLogin.setBounds(306, 210, 75, 25);
    bLogin.setText("Login");
    bLogin.setMargin(new Insets(2, 2, 2, 2));
    bLogin.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bLogin_ActionPerformed(evt);
        
        if (benutzername.equals(jTextField1.getText()) && passwort.equals(jTextField2.getText())) {
          Chats Chats = new Chats();
        } else {
          JLabel lFehlermeldung = new JLabel();
          lFehlermeldung.setBounds(33, 250, 421, 25);
          lFehlermeldung.setText("Falscher Benutzername oder falsches Passwort");
          lFehlermeldung.setFont(new Font("Dialog", Font.BOLD, 18));
          lFehlermeldung.setBackground(Color.RED);
          lFehlermeldung.setOpaque(true);
          cp.add(lFehlermeldung); 
          lFehlermeldung.repaint();
        }   
      }
    });
    cp.add(bLogin);
    bNochKeinenAccount.setBounds(68, 210, 147, 25);
    bNochKeinenAccount.setText("Noch Keinen Account?");
    bNochKeinenAccount.setMargin(new Insets(2, 2, 2, 2));
    bNochKeinenAccount.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bNochKeinenAccount_ActionPerformed(evt);
        //accountErstellen test2 = new accountErstellen();
        RegistraionsFenster();
        
      }
    });
    cp.add(bNochKeinenAccount);

    // Ende Komponenten

    setVisible(true);
  } // end of public Anmeldefenster
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Anmeldefenster();
  } // end of main
  public void RegistraionsFenster() {
    JLabel lText = new JLabel();
    JLabel lText2 = new JLabel();
    JLabel lBenutzername = new JLabel();
    JLabel lPasswort = new JLabel();
    JTextField jTextField1 = new JTextField();
    JTextField jTextField2 = new JTextField();
    JButton bAccounterstellen = new JButton();
    
    Container cp = getContentPane();
    cp.setLayout(null);
    
    lText.setBounds(41, 323, 821, 25);
    lText.setText("Erstellen Sie sich einen Account indem Sie einen Benutzernamen und ein Passwort eingeben");
    lText.setFont(new Font("Dialog", Font.BOLD, 18));
    cp.add(lText);
    lText2.setBounds(41, 353, 821, 25);
    lText2.setText("Melden Sie sich anschließend mit ihren Daten an");
    lText2.setFont(new Font("Dialog", Font.BOLD, 18));
    cp.add(lText2);
    lBenutzername.setBounds(95, 418, 110, 20);
    lBenutzername.setText("Benutzername");
    cp.add(lBenutzername);
    lPasswort.setBounds(98, 480, 110, 20);
    lPasswort.setText("Passwort");
    cp.add(lPasswort);
    jTextField1.setBounds(260, 422, 150, 20);
    cp.add(jTextField1);
    jTextField2.setBounds(263, 483, 150, 20);
    cp.add(jTextField2);
    bAccounterstellen.setBounds(300, 535, 115, 25);
    bAccounterstellen.setText("Account erstellen");
    bAccounterstellen.setMargin(new Insets(2, 2, 2, 2));
    bAccounterstellen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 

        benutzername = jTextField1.getText();
        passwort = jTextField2.getText();
        
        if(!benutzername.equals("") && !passwort.equals("")){
          
          lText.setVisible(false);
          lText2.setVisible(false);
          lBenutzername.setVisible(false);
          lPasswort.setVisible(false);
          jTextField1.setVisible(false);
          jTextField2.setVisible(false);
          bAccounterstellen.setVisible(false);
          lLeer.setVisible(false);
          
          lErstellt.setBounds(33, 300, 328, 25);
          lErstellt.setText("Ihr Account wurde erfolgreich erstellt");
          lErstellt.setFont(new Font("Dialog", Font.BOLD, 18));
          lErstellt.setBackground(Color.GREEN);
          lErstellt.setOpaque(true);
          cp.add(lErstellt); 
          lErstellt.repaint();
        } else {
         
          lLeer.setBounds(33, 600, 435, 25);
          lLeer.setText("Geben Sie einen Benutzername und ein Passwort");
          lLeer.setFont(new Font("Dialog", Font.BOLD, 18));
          lLeer.setBackground(Color.RED);
          lLeer.setOpaque(true);
          cp.add(lLeer); 
          lLeer.repaint();
          
          //Problem: Hier wird dennoch ein Account erstellt mit BN = "" und PW = "" mit dem sich angemeldet werden kann
          //Möglicher Fix: benutzername und passwort werden erst überschrieben wenn beide Felder nicht leer sind
        }
   
      }
    });
    cp.add(bAccounterstellen);
    // Ende Komponenten
    this.repaint();
    setVisible(true); 
  }
  //public String getBenutzername(String name){
     //return jTextField1;
   // }
  public void bLogin_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of bLogin_ActionPerformed

  public void bNochKeinenAccount_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of bNochKeinenAccount_ActionPerformed

  // Ende Methoden
} // end of class Anmeldefenster


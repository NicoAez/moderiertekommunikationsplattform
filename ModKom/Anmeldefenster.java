import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.Hashtable;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 09.03.2020
 * @author 
 */

public class Anmeldefenster extends JFrame {
  // Anfang Attribute
  
  private JLabel lModKom = new JLabel();
  private JLabel lHerzlichWillkommen = new JLabel();
  private JTextField jTextField1 = new JTextField();
  private JTextField jTextField2 = new JTextField();
  private JLabel lBenutzername = new JLabel();
  private JLabel lPasswort = new JLabel();
  private JButton bLogin = new JButton();
  private JButton bNochKeinenAccount = new JButton();
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
        Chats test = new Chats();
      }
    });
    cp.add(bLogin);
    bNochKeinenAccount.setBounds(68, 210, 147, 25);
    bNochKeinenAccount.setText("Noch Keinen Account?");
    bNochKeinenAccount.setMargin(new Insets(2, 2, 2, 2));
    bNochKeinenAccount.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bNochKeinenAccount_ActionPerformed(evt);
        accountErstellen test2 = new accountErstellen();
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
  
  public void bLogin_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
    
  } // end of bLogin_ActionPerformed

  public void bNochKeinenAccount_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
    
  } // end of bNochKeinenAccount_ActionPerformed

  // Ende Methoden
} // end of class Anmeldefenster


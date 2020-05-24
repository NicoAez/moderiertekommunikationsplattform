import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 09.03.2020
 * @author 
 */

public class accountErstellen extends JFrame {
  // Anfang Attribute
  
  private JLabel lErstellenSiesicheinenAccountindemSieeinenBenutzernamenundeinPassworteingeben = new JLabel();
  private JLabel lBenutzername = new JLabel();
  private JLabel lPasswort = new JLabel();
  private JTextField jTextField1 = new JTextField();
  private JTextField jTextField2 = new JTextField();
  private JButton bAccounterstellen = new JButton();
  // Ende Attribute
  
  public accountErstellen() { 
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
    setTitle("Account erstellen");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    
    lErstellenSiesicheinenAccountindemSieeinenBenutzernamenundeinPassworteingeben.setBounds(41, 23, 821, 25);
    lErstellenSiesicheinenAccountindemSieeinenBenutzernamenundeinPassworteingeben.setText("Erstellen Sie sich einen Account indem Sie einen Benutzernamen und ein Passwort eingeben");
    lErstellenSiesicheinenAccountindemSieeinenBenutzernamenundeinPassworteingeben.setFont(new Font("Dialog", Font.BOLD, 18));
    cp.add(lErstellenSiesicheinenAccountindemSieeinenBenutzernamenundeinPassworteingeben);
    lBenutzername.setBounds(95, 88, 110, 20);
    lBenutzername.setText("Benutzername");
    cp.add(lBenutzername);
    lPasswort.setBounds(98, 150, 110, 20);
    lPasswort.setText("Passwort");
    cp.add(lPasswort);
    jTextField1.setBounds(260, 92, 150, 20);
    cp.add(jTextField1);
    jTextField2.setBounds(263, 153, 150, 20);
    cp.add(jTextField2);
    bAccounterstellen.setBounds(300, 205, 115, 25);
    bAccounterstellen.setText("Account erstellen");
    bAccounterstellen.setMargin(new Insets(2, 2, 2, 2));
    bAccounterstellen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bAccounterstellen_ActionPerformed(evt);
        //Nachdem der User einen Benutzername und ein Passwort eingegeben hat sollen diese Strings auf eine
        //Variable geschrieben werden und an die Klasse Anmeldefenster geschickt werden, damit überprüft werden
        //kann ob diese richtig sind und dann soll der User Zugang bekommen
      }
    });
    cp.add(bAccounterstellen);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public BankOverlay
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new accountErstellen();
  } // end of main
  
  public void bAccounterstellen_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of bAccounterstellen_ActionPerformed

  // Ende Methoden
} // end of class BankOverlay


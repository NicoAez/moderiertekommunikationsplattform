import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class anzeigeChat extends JPanel
{
    JScrollPane scrollPane = new JScrollPane();
    JScrollPane scrollText = new JScrollPane();
    JPanel panel = new JPanel();
    JPanel textPanel = new JPanel();
    JButton button = new JButton();
    JTextArea textField = new JTextArea();
    GridBagConstraints c = new GridBagConstraints();

    public anzeigeChat()
    {
        setLayout(null);
        setSize(new Dimension(1000,600));
        panel.setSize(new Dimension(1000,700));
        panel.setBackground(new Color(50, 50, 50));
        scrollPane.getVerticalScrollBar().setUnitIncrement(50);
        scrollPane.setSize(new Dimension(1000,700));
        panel.setLayout(new GridBagLayout());

        textPanel.setLayout(new BorderLayout());
        textPanel.setSize(new Dimension(1000,50));
        textPanel.setBounds(0,700, textPanel.getWidth(), textPanel.getHeight());
        button.setSize(new Dimension(45,45));
        textField.setMaximumSize(new Dimension(1000,50));
        textField.setLineWrap(true);
        textField.setWrapStyleWord(true);
        textField.setText("now its working for whatever reason 187 marching band");
        textField.setFont(new Font("Robot", Font.PLAIN, 20));
        scrollText.setViewportView(textField);
        textPanel.add(button, BorderLayout.EAST);
        textPanel.add(scrollText);

        c.insets = new Insets(5,5,5,5);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;

        String testString = "omgwaseinlangerundwilderstringdernurdazudaistumzuschauenwaspassiertwenndertexteinfachmassiv zu lang ist für das panel" +
                "und deren maxima um vieles überschreitet, ja genau das will ich hiermit herrausfinden und werde dann sehen, was ich dagegen tun" +
                "kann! wünscht mir bitte viel glück und vielleicht geschieht der zeilenumbruch auf magischerweise ja irgendwie von alleine ohne" +
                "das ich noch viel einstellen muss das wäre natürlich HYPERWILD"; // :)
        int counterRL = 0;
        int counter = 0;
        List<anzeigeNachricht> labelList = new ArrayList<anzeigeNachricht>();
        for(int i=0; i<100; i++)
        {
            labelList.add(new anzeigeNachricht("Nico", "anzeige TExt nachricht 187 so etwas ist das genaus so etwas du hund"+testString));
            if(counterRL==0)
            {
                c.anchor = GridBagConstraints.WEST;
                c.gridx = 0;
                c.gridy = counter;
                panel.add(labelList.get(i), c);
                counterRL++;
                counter++;
            }
            else if(counterRL==1)
            {
                c.anchor = GridBagConstraints.EAST;
                c.gridx = 1;
                c.gridy = counter;
                panel.add(labelList.get(i), c);
                counterRL = 0;
                counter++;
            }
        }
        scrollPane.setViewportView(panel);
        add(scrollPane);
        add(textPanel);
    }
    public String getNachricht()
    {
        return textField.getText();
    }
    public void alButton(ActionListener al)
    {
        button.addActionListener(al);
    }
}

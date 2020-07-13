import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class anzeigeChat extends JPanel
{
    private int counter = 0;
    private List<anzeigeNachricht> nList = new ArrayList<anzeigeNachricht>();
    private JScrollPane scrollPane = new JScrollPane();
    private JScrollPane scrollText = new JScrollPane();
    private JPanel panel = new JPanel();
    private JPanel textPanel = new JPanel();
    private JButton button = new JButton();
    private JTextArea textField = new JTextArea();
    private GridBagConstraints c = new GridBagConstraints();
    private ActionListener aL;

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
        textField.setFont(new Font("Robot", Font.PLAIN, 20));
        scrollText.setViewportView(textField);
        textPanel.add(button, BorderLayout.EAST);
        textPanel.add(scrollText);

        c.insets = new Insets(5,5,5,5);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;

        scrollPane.setViewportView(panel);
        add(scrollPane);
        add(textPanel);
    }
    public void addNachricht(boolean b, String name, String nachricht)
    {
        anzeigeNachricht aN = new anzeigeNachricht(b, name, nachricht);
        aN.addActionListener(aL);
        nList.add(aN);
        if(b)
        {
            c.anchor = GridBagConstraints.EAST;
            c.gridx = 1;
        }
        else
        {
            c.anchor = GridBagConstraints.WEST;
            c.gridx = 0;
        }
        c.gridy = counter;
        aN.setName(String.valueOf(counter));
        panel.add(aN, c);
        counter++;
    }
    public void clear()
    {
        for(int i = 0; i<nList.size(); i++)
        {
            panel.remove(nList.get(i));
        }
        nList.clear();
        counter = 0;
    }
    public String getNachricht()
    {
        String s = textField.getText();
        textField.setText("");
        return s;
    }
    public String getID(Object o)
    {
        String s = "";
        for(int i = 0; i<nList.size(); i++)
        {
            if(nList.get(i) == o)
            {
                s = nList.get(i).getName();
            }
        }
        return s;
    }
    public void alButton(ActionListener al)
    {
        button.addActionListener(al);
    }
    public void alTextField(KeyListener kl)
    {
        textField.addKeyListener(kl);
    }
    public void alNachricht(ActionListener al)
    {
        aL = al;
        for(int i=0; i<nList.size(); i++) // sicherheitshalber
        {
            nList.get(i).addActionListener(al);
        }
    }
}

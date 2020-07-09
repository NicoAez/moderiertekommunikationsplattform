import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class anzeigeNachricht extends JTextArea implements MouseListener
{
    private ActionListener al;
    private Color farbe = new Color(11, 77, 92, 255);
    private Color sFarbe = new Color(255, 255, 255);
    private Color hlFarbe = farbe.brighter();
    private int state;

    public anzeigeNachricht(String name, String nachricht)
    {
        setEditable(false);
        setText(name+"\n"+nachricht);
        setLineWrap(true);
        setWrapStyleWord(true);
        addMouseListener(this);
        setBorder(new EmptyBorder(5,10,5,10));
        setBackground(farbe);
        setForeground(sFarbe);
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {}

    @Override
    public void mousePressed(MouseEvent e)
    {
        setBackground(hlFarbe);
        state = 1;
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        //al.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "187"));
        setBackground(farbe);
        state = 0;
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        state = 2;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        setBackground(farbe);
        state = 0;
        repaint();
    }

    @Override
    public void paintBorder(Graphics g)
    {
        super.paintBorder(g);
        Graphics gg = g.create();
        gg.setColor(hlFarbe);
        switch(state) {
            case 0:
                gg.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
                break;
            case 1:
                gg.drawRect(1, 1, getWidth() - 3, getHeight() - 3);
                gg.setColor(hlFarbe);
                gg.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
                gg.drawRect(2, 2, getWidth() - 5, getHeight() - 5);
                break;
            case 2:
                Border b = new BevelBorder(BevelBorder.LOWERED);
                b.paintBorder(this, gg, 0, 0, getWidth(), getHeight());
                break;
        }
        gg.dispose();
    }

    public void addActionListener(ActionListener l)
    {
        al = l;
    }
}


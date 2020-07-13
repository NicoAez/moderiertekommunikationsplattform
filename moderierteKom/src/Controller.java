import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer
{
    private ModKomView view;
    private ModKom model;

    public Controller(ModKomView mkv, ModKom mk)
    {
        view = mkv;
        model = mk;

        registrieren();

        this.view.alCloseButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(1);
            }
        });
        this.view.alBanButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.ban();
                view.changerino(model.getCS());
                view.switchTopPane(0);
            }
        });
        this.view.alUnbanButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.unban();
                view.changerino(model.getCS());
                view.switchTopPane(0);
            }
        });
        this.view.alDeleteButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.delete();
                view.changerino(model.getCS());
                view.switchTopPane(0);
            }
        });
        this.view.alModButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.modOnly();
                view.changerino(model.getCS());
            }
        });
        this.view.alOkButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.login(model.anmelden(view.getAName(), view.getAPasswort()));
            }
        });
        this.view.alPasswordField(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e){}
            @Override
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    e.consume();
                    view.login(model.anmelden(view.getAName(), view.getAPasswort()));
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        this.view.alChatButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.changeCSelect(view.changeChat(e.getSource()));
                view.switchTopPane(0);
            }
        });
        this.view.alACButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.addNachricht(view.getNachricht(model.getCS()));
                view.changerino(model.getCS());
            }
        });
        // Methode unter mir als "Ersatz" zur theoretischen Methode darunter
        this.view.alTextField(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e){}
            @Override
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    e.consume();
                    model.addNachricht(view.getNachricht(model.getCS()));
                    view.changerino(model.getCS());
                }
            }
            @Override
            public void keyReleased(KeyEvent e){}
        });
        /*
        this.view.alTextField(new KeyListener()
        {
            List<Integer> keys = new ArrayList<Integer>();
            @Override
            public void keyTyped(KeyEvent e){}
            @Override
            public void keyPressed(KeyEvent e)
            {
                int key = e.getKeyCode();
                if((key == KeyEvent.VK_ENTER) || (key == KeyEvent.VK_SHIFT) && (!(keys.contains(key))))
                {
                    keys.add(key);
                }
            }
            @Override
            public void keyReleased(KeyEvent e)
            {
                if((keys.contains(KeyEvent.VK_ENTER) && (keys.contains(KeyEvent.VK_SHIFT))))
                {
                    e.consume();
                    // Hier müsste eine Methode stehen, welche einen Absatz bei der TextArea macht.
                    // -> Nachteil ist das Nachrichten senden mit Enter immer erst Absatz macht und dann schickt (weil Methode wird erst bei keyReleased aufgerufen)
                    // + ist mir zu viel Aufwand das zu machen nur für den side effect, kann gerne jemand der das hier liest machen :)
                    keys.clear();
                }
                else if(keys.contains(KeyEvent.VK_ENTER))
                {
                    e.consume();
                    model.addNachricht(view.getNachricht(model.getCS()));
                    view.changerino(model.getCS());
                    keys.clear();
                }
            }
        });
         */
        this.view.alNachricht(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.changeNSelect(view.einsachtsieben(e.getSource(), model.getCS()));
                view.switchTopPane(1);
            }
        });
    }
    public void registrieren()
    {
        model.registrierenOb(this);
    }
    @Override
    public void update(Observable o, Object arg)
    {
        view.clear();
        model.updateChat(view.getChat());
    }
}

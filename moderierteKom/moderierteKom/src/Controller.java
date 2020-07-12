import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                view.switchTopPane(0);
            }
        });
        this.view.alUnbanButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.unban();
                view.switchTopPane(0);
            }
        });
        this.view.alDeleteButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.delete();
                view.switchTopPane(0);
            }
        });
        this.view.alModButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.modOnly();
            }
        });
        this.view.alOkButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.login(model.anmelden(view.getAName(), view.getAPasswort()));
            }
        });
        this.view.alChatButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.changeCSelect(view.changeChat(e.getSource()));
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

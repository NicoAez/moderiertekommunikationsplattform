import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ModKom extends Observable implements Observer
{
    private List<Chat> chat;
    private List<List<Nachricht>> log = new ArrayList<List<Nachricht>>();
    private simulierteDatenbank datenbank;
    private int uid;
    private String name;
    private int cs = 0;
    private int ns = 0;

    public ModKom(simulierteDatenbank d, List<Chat> c)
    {
        datenbank = d;
        chat = c;
        registrieren();

        for(int i = 0; i<chat.size(); i++)
        {
            log.add(chat.get(i).getLog());
        }
    }

    @Override
    public void update(Observable o, Object arg)
    {
        setChanged();
        notifyObservers();
    }

    public void registrieren()
    {
        for(int i = 0; i<chat.size(); i++)
        {
            chat.get(i).registrieren(this);
        }
    }
    public void registrierenOb(Observer o)
    {
        addObserver(o);
    }
    public boolean anmelden(String n, String p)
    {
        uid = datenbank.anmelden(n,p);
        if(uid!=-1)
        {
            name = datenbank.getName(uid);
            setChanged();
            notifyObservers();
            return true;
        }
        else
        {
            return false;
        }
    }
    private int getNID()
    {
        return log.get(cs).get(ns).getID();
    }
    public void addNachricht(String s)
    {
        chat.get(cs).addNachricht(new Nachricht(name, uid, s));
    }
    public void ban()
    {
        chat.get(cs).addBan(getNID(), uid);
    }
    public void unban()
    {
        chat.get(cs).deleteBan(getNID(), uid);
    }
    public void delete()
    {
        chat.get(cs).deleteMessage(log.get(cs).get(ns), uid);
    }
    public void modOnly()
    {
        chat.get(cs).modModus(uid);
    }
    public void changeCSelect(String s)
    {
        cs = Integer.valueOf(s);
    }
    public void changeNSelect(String s)
    {
        ns = Integer.valueOf(s);
    }
    public int getCS()
    {
        return cs;
    }
    public void updateChat(List<anzeigeChat> aC)
    {


            boolean b;
            List<anzeigeChat> acList = aC;
            log.clear();
            for (int i = 0; i < chat.size(); i++) {
                log.add(chat.get(i).getLog());
                for (int j = 0; j < log.get(i).size(); j++) {
                    if (log.get(i).get(j).getID() == uid) {
                        b = true;
                    } else {
                        b = false;
                    }
                    acList.get(i).addNachricht(b, log.get(i).get(j).getName(), log.get(i).get(j).getNachricht());
                }
            }
    }
}

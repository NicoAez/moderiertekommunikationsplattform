import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ModKom implements Observer
{
    private List<Chat> chat;
    private List<List<Nachricht>> log = new ArrayList<List<Nachricht>>();
    private simulierteDatenbank datenbank;
    private int uid;
    private String name;
    private int cs;
    private int ns;

    public ModKom(simulierteDatenbank d, List<Chat> c)
    {
        datenbank = d;
        chat = c;

        for(int i = 0; i<chat.size(); i++)
        {
            log.add(chat.get(i).getLog());
        }
    }

    @Override
    public void update(Observable o, Object arg)
    {

    }

    public void registrieren()
    {
        for(int i = 0; i<chat.size(); i++)
        {
            chat.get(i).registrieren(this);
        }
    }
    public boolean anmelden(String n, String p)
    {
        uid = datenbank.anmelden(n,p);
        if(uid!=-1)
        {
            name = datenbank.getName(uid);
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
}

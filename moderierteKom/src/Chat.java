import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Chat extends Observable
{
    List<Nachricht> nachricht = new ArrayList<Nachricht>();
    List<Integer> moderator = new ArrayList<Integer>();
    List<Integer> admin = new ArrayList<Integer>();
    List<Integer> benutzer = new ArrayList<Integer>();
    List<Integer> gebannt = new ArrayList<Integer>();
    boolean modModus = false;
    int id;
    simulierteDatenbank datenbank;

    public Chat(int i, int id, simulierteDatenbank d)
    {
        admin.add(i);
        this.id = id;
        datenbank = d;

        addNachricht(new Nachricht("System", 0, "erste nachricht"));
    }

    public int getID()
    {
        return id;
    }
    public void registrieren(Observer o)
    {
        addObserver(o);
    }
    private void update()
    {
        setChanged();
        notifyObservers();
    }
    public void addNachricht(Nachricht n)
    {
        int i = n.getID();
        if(modModus)
        {
            if(moderator.contains(i)||admin.contains(i))
            {
                nachricht.add(n);
            }
        }
        else
        {
            if(!(gebannt.contains(i)))
            {
                nachricht.add(n);
            }
        }
        update();
    }
    public void deleteMessage(Nachricht n, int e)
    {
        if(moderator.contains(e)||admin.contains(e))
        {
            nachricht.get(nachricht.indexOf(n)).setNachricht("Nachricht wurde geloescht.");
        }
        update();
    }
    public void addModerator(int i, int e)
    {
        if(moderator.contains(e)||admin.contains(e))
        {
            if(!(moderator.contains(i)))
            {
                moderator.add(i);
                nachricht.add(new Nachricht("System", 0, datenbank.getName(i)+" ist jetzt Moderator ("+datenbank.getName(e)+")"));
            }
        }
        update();
    }
    public void deleteModerator(int i, int e)
    {
        if(moderator.contains(e)||admin.contains(e))
        {
            if(!(admin.contains(i)))
            {
                moderator.remove(moderator.indexOf(i));
                nachricht.add(new Nachricht("System", 0, datenbank.getName(i)+" ist nun kein Moderator mehr! ("+datenbank.getName(e)+")"));
            }
        }
        update();
    }
    public void addBenutzer(int i) // überflüssig, sofern nicht immer kontrolliert wird ob ID wirklich Benutzer ist
    {
        benutzer.add(i);
    }
    public void addBan(int i, int e)
    {
        if(moderator.contains(e)||admin.contains(e))
        {
            if(!(moderator.contains(i))||!(admin.contains(i)))
            {
                if(!(gebannt.contains(i)))
                {
                    gebannt.add(i);
                    nachricht.add(new Nachricht("System", 0, datenbank.getName(i)+" wurde gebannt. ("+datenbank.getName(e)+")"));
                }
            }
        }
        update();
    }
    public void deleteBan(int i, int e)
    {
        if(moderator.contains(e)||admin.contains(e))
        {
            gebannt.remove(gebannt.indexOf(i));
            nachricht.add(new Nachricht("System", 0, datenbank.getName(i)+" wurde entbannt. ("+datenbank.getName(e)+")"));
        }
    }
    public void modModus(int i)
    {
        if(moderator.contains(i)||admin.contains(i))
        {
            if(modModus==true)
            {
                modModus = false;
                nachricht.add(new Nachricht("System", 0, "Der mod-only Modus ist nun nicht mehr aktiv. ("+datenbank.getName(i)+")"));
            }
            else
            {
                modModus = true;
                nachricht.add(new Nachricht("System", 0, "Der mod-only Modus ist nun aktiv. ("+datenbank.getName(i)+")"));
            }
        }
        update();
    }
    public List<Nachricht> getLog()
    {
        return nachricht;
    }

}

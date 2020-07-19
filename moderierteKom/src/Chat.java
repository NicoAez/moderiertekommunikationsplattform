import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Chat extends Observable {
    List<Nachricht> nachricht = new ArrayList<Nachricht>();
    List<Integer> moderator = new ArrayList<Integer>();
    List<Integer> admin = new ArrayList<Integer>();
    List<Integer> benutzer = new ArrayList<Integer>();
    List<Integer> gebannt = new ArrayList<Integer>();
    boolean modModus = false;
    int id;
    simulierteDatenbank datenbank;

    public Chat(int i, int id, simulierteDatenbank d) {
        admin.add(i); admin.add(-1);
        this.id = id;
        datenbank = d;
        moderator.add(187);
    }

    public int getID() {
        return id;
    }

    public void registrieren(Observer o) {
        addObserver(o);
    }

    private void update() {
        setChanged();
        notifyObservers();
    }

    public void addNachricht(Nachricht n) {
        int i = n.getID();
        if (modModus) {
            if (moderator.contains(i) || admin.contains(i)) {
                nachricht.add(n);
            }
        } else {
            if (!(gebannt.contains(i))) {
                nachricht.add(n);
            }
        }
        update();
    }

    public void deleteMessage(Nachricht n, int e) {
        if (n.getID() == e)
        {
            nachricht.get(nachricht.indexOf(n)).setNachricht("Nachricht wurde geloescht. (" + datenbank.getName(e) + ")");
        }
        else if (moderator.contains(e))
        {
            if (!(moderator.contains(n.getID())) || !(admin.contains(n.getID())))
            {
                nachricht.get(nachricht.indexOf(n)).setNachricht("Nachricht wurde geloescht. (" + datenbank.getName(e) + ")");
            }
        }
        else if ((admin.contains(e)&&!(n.getID()==-1)))
        {
            nachricht.get(nachricht.indexOf(n)).setNachricht("Nachricht wurde geloescht. (" + datenbank.getName(e) + ")");
        }
        update();
    }

    public void delMes(int i) // lediglich für das testfenster
    {
        nachricht.get(i).setNachricht("Nachricht wurde geloescht. (System)");
    }
    public void addModerator(int i, int e)
    {
        if(admin.contains(e))
        {
            if(!(moderator.contains(i)))
            {
                moderator.add(i);
                nachricht.add(new Nachricht("System", -1, datenbank.getName(i)+" ist jetzt Moderator ("+datenbank.getName(e)+")"));
            }
        }
        update();
    }
    public void deleteModerator(int i, int e)
    {
        if(admin.contains(e))
        {
            moderator.remove(moderator.indexOf(i));
            nachricht.add(new Nachricht("System", -1, datenbank.getName(i)+" ist nun kein Moderator mehr! ("+datenbank.getName(e)+")"));
        }
        update();
    }
    public void addBenutzer(int i) // überflüssig, sofern nicht immer kontrolliert wird ob ID wirklich Benutzer ist
    {
        benutzer.add(i);
    }
    public void addBan(int i, int e)
    {
        if(!(gebannt.contains(i)))
        {
            if(admin.contains(e))
            {
                if(moderator.contains(i))
                {
                    moderator.remove(moderator.indexOf(i));
                    gebannt.add(i);
                    nachricht.add(new Nachricht("System", -1, datenbank.getName(i)+" wurde gebannt! ("+datenbank.getName(e)+")"));
                }
                else
                {
                    gebannt.add(i);
                    nachricht.add(new Nachricht("System", -1, datenbank.getName(i)+" wurde gebannt! ("+datenbank.getName(e)+")"));
                }
            }
            else if(moderator.contains(e))
            {
                if(!(moderator.contains(i)))
                {
                    if(!(admin.contains(i)))
                    {
                        gebannt.add(i);
                        nachricht.add(new Nachricht("System", -1, datenbank.getName(i)+" wurde gebannt! ("+datenbank.getName(e)+")"));
                    }
                }
            }
            update();
        }
    }
    public void deleteBan(int i, int e)
    {
        if(moderator.contains(e)||admin.contains(e))
        {
            if(gebannt.contains(i))
            {
                gebannt.remove(gebannt.indexOf(i));
                nachricht.add(new Nachricht("System", -1, datenbank.getName(i)+" wurde entbannt. ("+datenbank.getName(e)+")"));
            }
        }
        update();
    }
    public void modModus(int i)
    {
        if(moderator.contains(i)||admin.contains(i))
        {
            if(modModus==true)
            {
                modModus = false;
                nachricht.add(new Nachricht("System", -1, "Der mod-only Modus ist nun nicht mehr aktiv. ("+datenbank.getName(i)+")"));
            }
            else
            {
                modModus = true;
                nachricht.add(new Nachricht("System", -1, "Der mod-only Modus ist nun aktiv. ("+datenbank.getName(i)+")"));
            }
        }
        update();
    }
    public List<Nachricht> getLog()
    {
        return nachricht;
    }

}

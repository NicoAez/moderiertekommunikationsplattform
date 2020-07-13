import java.util.ArrayList;
import java.util.List;

public class simulierteDatenbank
{
    List<Benutzer> liste = new ArrayList<Benutzer>();

    public simulierteDatenbank()
    {
        fill();
    }
    public void fill()
    {
        liste.add(new Benutzer("Nico", "187Straßenbande", 1));
        liste.add(new Benutzer("Deniz", "307lebt", 2));
        liste.add(new Benutzer("Anton", "Internetrambo", 3));
        liste.add(new Benutzer("Sebastian", "Hosenmann", 4));
        liste.add(new Benutzer("Julius", "MariosBart", 5));
        liste.add(new Benutzer("", "", 6));
        liste.add(new Benutzer("187", "187", 187));
    }
    public int anmelden(String n, String p)
    {
        for(int i = 0; i<liste.size(); i++)
        {
            if(liste.get(i).anmelden(n,p))
            {
                return liste.get(i).getId();
            }

        }
        return -1;
    }
    public String getName(int e)
    {
        for(int i = 0; i<liste.size(); i++)
        {
            if(liste.get(i).getId()==e)
            {
                return liste.get(i).getName();
            }
        }
        return "System"; // oder System als Benutzer hinzufügen und dann tatsächlich "Fehler" o.ä. anzeigen
    }
}

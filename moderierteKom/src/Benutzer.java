public class Benutzer
{
    private String name;
    private String pw;
    private int id;

    public Benutzer(String n, String p, int i)
    {
        name = n;
        pw = p;
        id = i;
    }

    public boolean anmelden(String n, String p)
    {
        if(name.equalsIgnoreCase(n)&&pw.equals(p))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
}

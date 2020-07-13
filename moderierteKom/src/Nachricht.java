public class Nachricht
{
    String name;
    String nachricht;
    int id;

    public Nachricht(String n,int i,String s)
    {
        name = n;
        id = i;
        nachricht = s;
    }

    public String getName()
    {
        return name;
    }
    public String getNachricht()
    {
        return nachricht;
    }
    public int getID()
    {
        return id;
    }
    public void setNachricht(String s)
    {
        nachricht = s;
    }
}

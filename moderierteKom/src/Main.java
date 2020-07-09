import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String args[])
    {
        simulierteDatenbank datenbank = new simulierteDatenbank();
        List<Chat> chat = new ArrayList<Chat>();
        chat.add(new Chat(1, 187, datenbank));
        chat.add(new Chat(2, 307, datenbank));
        chat.add(new Chat(3, 323, datenbank));
        ModKomView mkView = new ModKomView(10);
        ModKom mk = new ModKom(datenbank, chat);
        Controller mkController = new Controller(mkView, mk);
    }
}

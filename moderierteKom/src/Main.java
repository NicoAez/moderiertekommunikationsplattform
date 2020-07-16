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
        chat.add(new Chat(4, 324, datenbank));
        chat.add(new Chat(5, 325, datenbank));
        chat.add(new Chat(6, 326, datenbank));
        chat.add(new Chat(7, 327, datenbank));
        chat.add(new Chat(8, 328, datenbank));
        chat.add(new Chat(9, 329, datenbank));
        chat.add(new Chat(10, 30, datenbank));
        ModKomView mkView = new ModKomView(10);
        ModKom mk = new ModKom(datenbank, chat);
        Controller mkController = new Controller(mkView, mk);
        ChatController187 cc = new ChatController187(chat);
    }
}

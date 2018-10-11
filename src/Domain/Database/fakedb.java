package Domain.Database;

import Domain.Lyokowarrior;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 8/3/18.
 */
public class fakedb {
    List<Lyokowarrior> players = new ArrayList<>();

    public List<Lyokowarrior> getPlayers() {
        return players;
    }

    public Lyokowarrior get(String name){
        for (Lyokowarrior lyokowarrior: players){
            if (lyokowarrior.getUsername().equalsIgnoreCase(name)){
                return lyokowarrior;
            }
        }
        return null;
    }
}

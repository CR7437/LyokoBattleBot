package Database;

import Domain.DatabaseInterface;
import Domain.Lyokowarrior;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 8/3/18.
 */
public class fakedb implements DatabaseInterface {
    List<Lyokowarrior> players = new ArrayList<>();

    public List<Lyokowarrior> getPlayers() {
        return players;
    }

    @Override
    public Lyokowarrior getWarrior(String name){
        for (Lyokowarrior lyokowarrior: players){
            if (lyokowarrior.getUsername().equalsIgnoreCase(name)){
                return lyokowarrior;
            }
        }
        return null;
    }



    @Override
    public Lyokowarrior deleteWarrior(String name) {
        Lyokowarrior lyokowarrior = null;
        if (hasWarrior(name)){
            lyokowarrior = getWarrior(name);
            players.remove(lyokowarrior);
        }
        return lyokowarrior;
    }

    @Override
    public boolean hasWarrior(String name) {
        boolean found = false;
        for (Lyokowarrior lyokowarrior : players) {
            if (lyokowarrior.getUsername().equals(name)) {
                found = true;
            }
        }
        return found;
    }
    /*Useless method in this case because everything lives in memory*/
    @Override
    public Lyokowarrior updateWarrior(Lyokowarrior lyokowarrior) {
        for (int i = 0; i < players.size(); i++) {
            Lyokowarrior warrior = players.get(i);
            if (warrior.getUsername().equals(lyokowarrior.getUsername())) {
                players.set(i,lyokowarrior);
            }
        }
        return lyokowarrior;
    }

    @Override
    public void addWarrior(Lyokowarrior lyokowarrior) {
        if (!hasWarrior(lyokowarrior.getUsername())){
            players.add(lyokowarrior);
        }
    }
}

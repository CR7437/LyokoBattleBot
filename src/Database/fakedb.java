package Database;

import Discord.DiscordFormatter;
import Domain.DatabaseInterface;
import Domain.Lyokowarrior;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 8/3/18.
 */
public class fakedb implements DatabaseInterface {
    List<Lyokowarrior> players = new ArrayList<>();

    public List<Lyokowarrior> getPlayers() { return players; }

    @Override
    public Lyokowarrior getWarrior(long id){
        for (Lyokowarrior lyokowarrior: players){
            if (lyokowarrior.getId() == id){
                return lyokowarrior;
            }
        }
        return null;
    }



    @Override
    public Lyokowarrior deleteWarrior(long id) {
        Lyokowarrior lyokowarrior = null;
        if (hasWarrior(id)){
            lyokowarrior = getWarrior(id);
            players.remove(lyokowarrior);
        }
        return lyokowarrior;
    }

    @Override
    public boolean hasWarrior(long id) {
        boolean found = false;
        for (Lyokowarrior lyokowarrior : players) {
            if (lyokowarrior.getId() == id) {
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
            if (warrior.getId() == lyokowarrior.getId()) {
                players.set(i,lyokowarrior);
            }
        }
        return lyokowarrior;
    }

    @Override
    public void addWarrior(Lyokowarrior lyokowarrior) {
        if (!hasWarrior(lyokowarrior.getId())){
            players.add(lyokowarrior);
        }
    }
}

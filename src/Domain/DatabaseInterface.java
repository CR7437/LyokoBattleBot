package Domain;

/**
 * Created by jack on 10/12/18.
 */
public interface DatabaseInterface {
    Lyokowarrior getWarrior(String name);
    Lyokowarrior deleteWarrior(String name);
    boolean hasWarrior(String name);
    Lyokowarrior updateWarrior(Lyokowarrior lyokowarrior);
    void addWarrior(Lyokowarrior lyokowarrior);
}

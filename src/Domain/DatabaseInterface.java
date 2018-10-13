package Domain;

/**
 * Created by jack on 10/12/18.
 */
public interface DatabaseInterface {
    Lyokowarrior getWarrior(long id);
    Lyokowarrior deleteWarrior(long id);
    boolean hasWarrior(long id);
    Lyokowarrior updateWarrior(Lyokowarrior lyokowarrior);
    void addWarrior(Lyokowarrior lyokowarrior);
}

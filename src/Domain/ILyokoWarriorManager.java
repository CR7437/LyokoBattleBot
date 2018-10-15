package Domain;

public interface ILyokoWarriorManager {
    Lyokowarrior getLyokoWarrior(long id);
    Lyokowarrior getLyokoWarrior(String string);
    Lyokowarrior deleteWarrior(long id);
    Lyokowarrior deleteWarrior(String string);
    Lyokowarrior updateWarrior(Lyokowarrior lyokowarrior);
    boolean hasWarrior(long id);
    boolean hasWarrior(String string);
    void addWarrior(Lyokowarrior lyokowarrior); //TODO more paramters to create object inside the method?
}

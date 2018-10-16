package Domain;

import Domain.Enums.LYOKOCLASS;

public interface ILyokoWarriorManager {
    Lyokowarrior getLyokoWarrior(long id);
    Lyokowarrior getLyokoWarrior(String string);
    Lyokowarrior deleteWarrior(long id);
    Lyokowarrior deleteWarrior(String string);
    Lyokowarrior updateWarrior(Lyokowarrior lyokowarrior);
    boolean hasWarrior(long id);
    boolean hasWarrior(String string);
    void addWarrior(Lyokowarrior lyokowarrior);
    void addWarrior(long id, LYOKOCLASS lyokoclass);
}

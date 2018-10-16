package Application;

import Domain.DatabaseInterface;
import Domain.Enums.LYOKOCLASS;
import Domain.ILyokoWarriorManager;
import Domain.Lyokowarrior;

public class LyokoWarriorManager implements ILyokoWarriorManager {
    private DatabaseInterface database;

    public LyokoWarriorManager(DatabaseInterface database) {
        this.database = database;
    }

    @Override
    public Lyokowarrior getLyokoWarrior(String string) {
        long id = Checker.checkNumber(string);
        return getLyokoWarrior(id);

    }

    @Override
    public Lyokowarrior getLyokoWarrior(long id) {
        return database.getWarrior(id);
    }

    @Override
    public Lyokowarrior deleteWarrior(String string) {
            long id = Checker.checkNumber(string);
            return deleteWarrior(id);
    }

    @Override
    public Lyokowarrior deleteWarrior(long id) {
        return database.deleteWarrior(id);
    }

    @Override
    public boolean hasWarrior(String string) {
            long id = Checker.checkNumber(string);
            return hasWarrior(id);
    }

    @Override
    public boolean hasWarrior(long id) {
        return database.hasWarrior(id);
    }

    @Override
    public Lyokowarrior updateWarrior(Lyokowarrior lyokowarrior) {
        return database.updateWarrior(lyokowarrior);
    }

    @Override
    public void addWarrior(long id, LYOKOCLASS lyokoclass) { database.addWarrior(new Lyokowarrior(id,lyokoclass)); }

    @Override
    public void addWarrior(Lyokowarrior lyokowarrior) {database.addWarrior(lyokowarrior);}

}

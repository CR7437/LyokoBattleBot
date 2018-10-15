package Application;

import Domain.DatabaseInterface;
import Domain.ILyokoWarriorManager;
import Domain.Lyokowarrior;

public class LyokoWarriorManager implements ILyokoWarriorManager {
    private DatabaseInterface database;
    public LyokoWarriorManager(DatabaseInterface database) {this.database = database;}

    @Override
    public Lyokowarrior getLyokoWarrior(String string) {
        try {
            long id = Checker.checkNumber(string);
            return database.getWarrior(id);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    @Override
    public Lyokowarrior getLyokoWarrior(long id) { return database.getWarrior(id);}

    @Override
    public Lyokowarrior deleteWarrior(String string) {
        try {
            long id = Checker.checkNumber(string);
            return database.deleteWarrior(id);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    @Override
    public Lyokowarrior deleteWarrior(long id) {return database.deleteWarrior(id);}

    @Override
    public boolean hasWarrior(String string) {
        try {
            long id = Checker.checkNumber(string);
            return database.hasWarrior(id);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    @Override
    public boolean hasWarrior(long id) {return database.hasWarrior(id);}
    @Override
    public Lyokowarrior updateWarrior(Lyokowarrior lyokowarrior) {return database.updateWarrior(lyokowarrior);}
    @Override
    public void addWarrior(Lyokowarrior lyokowarrior) {database.addWarrior(lyokowarrior);}
}

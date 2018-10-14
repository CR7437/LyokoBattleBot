package Application;

import Domain.DatabaseInterface;
import Domain.ILyokoWarriorManager;
import Domain.Lyokowarrior;

public class LyokoWarriorManager implements ILyokoWarriorManager {
    private DatabaseInterface database;

    public LyokoWarriorManager(DatabaseInterface database) {this.database = database;}

    public Lyokowarrior getLyokoWarrior(String string) {
        try {
            long id = Checker.checkNumber(string);
            return database.getWarrior(id);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    public Lyokowarrior getLyokoWarrior(long id) { return database.getWarrior(id);}

    public Lyokowarrior deleteWarrior(String string) {
        try {
            long id = Checker.checkNumber(string);
            return database.deleteWarrior(id);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    public Lyokowarrior deleteWarrior(long id) {return database.deleteWarrior(id);}

    public boolean hasWarrior(String string) {
        try {
            long id = Checker.checkNumber(string);
            return database.hasWarrior(id);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    public boolean hasWarrior(long id) {return database.hasWarrior(id);}

    public Lyokowarrior updateWarrior(Lyokowarrior lyokowarrior) {return database.updateWarrior(lyokowarrior);}

    public void addWarrior(Lyokowarrior lyokowarrior) {database.addWarrior(lyokowarrior);}
}

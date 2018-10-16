package Application;

import Application.Exceptions.CommandException;
import Application.Exceptions.InvalidClassException;
import Domain.Enums.LYOKOCLASS;
import sx.blah.discord.handle.obj.IMessage;

public class Checker {

    public static int checkNumber(String number) throws NumberFormatException {
        int retNumber;
        try { retNumber = Integer.parseInt(number);}
        catch (NumberFormatException e){ throw e; }
        return retNumber;
    }
}

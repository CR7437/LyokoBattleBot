package Application.Commands;

import Application.Exceptions.CommandException;
import Application.Main;
import sx.blah.discord.handle.obj.IMessage;

public class Create extends LyokoCommand {

    public Create() {
        super("create");
        setHelpMessage("Creates a LW for your user.");
        setUsage(String.format("%screate", Main.prefix));
    }

    @Override
    protected void doCommand(IMessage message, String[] args) throws CommandException {
        checkArgs(message,args,0,0);

    }
}

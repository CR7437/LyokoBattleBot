package Application.Commands;

import Application.Checker;
import Application.Exceptions.CommandException;
import Application.Exceptions.InvalidClassException;
import Application.Main;
import Discord.DiscordFormatter;
import Domain.Enums.LYOKOCLASS;
import Domain.Lyokowarrior;
import sx.blah.discord.handle.obj.IMessage;

public class Create extends LyokoCommand {

    public Create() {
        super("create");
        setHelpMessage("Creates a LW for your user.");
        setUsage(String.format("%screate <SAMURAI/FELINE/GEISHA/ANGEL>", Main.prefix));
    }

    @Override
    protected void doCommand(IMessage message, String[] args) throws CommandException {
        checkArgs(message, args, 1, 1);
            if (Main.getLwManager().hasWarrior(message.getAuthor().getLongID())) {
                message.getChannel().sendMessage(message.getAuthor() + ", you already have a LyokoWarrior!");
            } else {
                LYOKOCLASS lyokoclass = this.isClass(message, args[0]);
                Lyokowarrior lw = new Lyokowarrior(message.getAuthor().getLongID(), lyokoclass);
                Main.getLwManager().addWarrior(lw);
                message.getChannel().sendMessage(String.format("Created **%s's** LyokoWarrior!", DiscordFormatter.getName(lw)));
            }
    }

    public LYOKOCLASS isClass(IMessage message, String classCheck) throws CommandException {
        for(LYOKOCLASS lyokoclass : LYOKOCLASS.values()) {
            if(classCheck.equalsIgnoreCase(lyokoclass.toString())) {
                return lyokoclass;
            }
        }
        throw new InvalidClassException(message,classCheck);
    }
}

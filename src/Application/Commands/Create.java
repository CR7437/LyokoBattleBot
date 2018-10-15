package Application.Commands;

import Application.Exceptions.CommandException;
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
        checkArgs(message,args,1,1);
        try {
            if(Main.getLwManager().hasWarrior(message.getAuthor().getLongID())) {
                message.getChannel().sendMessage(message.getAuthor() + "**, you already have a LyokoWarrior!");
            } else {
                String lwclass = args[0].toUpperCase();
                LYOKOCLASS lyokoclass = LYOKOCLASS.valueOf(lwclass);
                Lyokowarrior lw = new Lyokowarrior(message.getAuthor().getLongID(), lyokoclass);
                Main.getLwManager().addWarrior(lw);
                message.getChannel().sendMessage("Created **" + DiscordFormatter.getName(lw) + "'s** LyokoWarrior!");
            }
        }
        catch (IllegalArgumentException e) {
            message.getChannel().sendMessage(message.getAuthor() + ", " + args[0] + " isn't a valid class!\n"
            + "__Valid Classes:__ `SAMURAI, FELINE, GEISHA, ANGEL`");
        }
    }
}

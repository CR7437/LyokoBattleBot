package Application.Commands;

import Application.Exceptions.CommandException;
import Application.Exceptions.InvalidCommandException;
import Application.Main;
import Discord.DiscordFormatter;
import Domain.Enums.LYOKOCLASS;
import Domain.Lyokowarrior;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;

import java.util.ArrayList;
import java.util.List;

public class Delete extends LyokoCommand {

    List<IUser> userList = new ArrayList<>();

    public Delete() {
        super("delete");
        setHelpMessage("Deletes your own LyokoWarrior.");
        setUsage(String.format("%sdelete", Main.prefix));
    }

    @Override
    protected void doCommand(IMessage message, String[] args) throws CommandException {
        checkArgs(message,args,0,1);
        if(Main.getLwManager().hasWarrior(message.getAuthor().getLongID())) {
            if(args.length == 0) {
                if(!userList.contains(message.getAuthor())) {
                    userList.add(message.getAuthor());
                }
                message.getChannel().sendMessage(String.format(message.getAuthor() + ", are you sure that you want to remove your LyokoWarrior?\n__**Type `%sdelete confirm` to confirm.**__",Main.prefix));
            } else if(args.length == 1 && args[0].equalsIgnoreCase("confirm")) {
                if(userList.contains(message.getAuthor())) {
                    Main.getLwManager().deleteWarrior(message.getAuthor().getLongID());
                    message.getChannel().sendMessage("Removed " + message.getAuthor() + "'s LyokoWarrior.");
                } else {
                    throw new InvalidCommandException(message,getUsage());
                }
            } else {
                throw new InvalidCommandException(message,getUsage());
            }
        } else {
            message.getChannel().sendMessage(message.getAuthor() + ", you don't have a LyokoWarrior!");
        }
    }
}

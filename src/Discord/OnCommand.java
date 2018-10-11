package Discord;

import Domain.Enums.LYOKOCLASS;
import Domain.Lyokowarrior;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;

public class OnCommand {
    public void processCommand(IMessage message, String prefix){
        IUser sender = message.getAuthor();
        IChannel channel = message.getChannel();
        IGuild guild = message.getGuild();

        String[] command = message.getContent().toLowerCase().replaceFirst(prefix, "").split(" ");
        String[] command2 = message.getContent().replaceFirst(prefix, "").split(" "); //no lowercase

        if(command[0].equals("hello")) {
            channel.sendMessage("Hai!");
        } else if(command[0].equals("create")) {
            if(command.length < 2) {
                channel.sendMessage("Invalid arguments. Usage: `" + prefix + "create name`");
            }
            Lyokowarrior LW = new Lyokowarrior(command2[1], LYOKOCLASS.SAMURAI);
            channel.sendMessage(LW.getUsername() + " has been created.\nLevel: " + LW.getLevel() + " (" + LW.getXp() + " XP)");
            channel.sendMessage("Attacks: TO BE PRINT");
            LW.addXP(1500);
            channel.sendMessage("1500 XP added.");
            channel.sendMessage(LW.getUsername() + "\nLevel: " + LW.getLevel() + " (" + LW.getXp() + " XP)");
        }
    }
}

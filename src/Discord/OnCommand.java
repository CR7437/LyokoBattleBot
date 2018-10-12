package Discord;

import Domain.Enums.LYOKOCLASS;
import Domain.Lyokowarrior;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;

import java.util.Arrays;

public class OnCommand {

    public OnCommand(){
        
    }

    public void processCommand(IMessage message, String prefix){
        IUser sender = message.getAuthor();
        IChannel channel = message.getChannel();
        IGuild guild = message.getGuild();

        String[] command = message.getContent().replaceFirst(prefix, "").split(" ");
        String commandName = command[0];
        String[] args = Arrays.copyOfRange(command, 1, command.length);

        if(commandName.equalsIgnoreCase("hello")) {
            channel.sendMessage("Hai!");
        } else if(commandName.equalsIgnoreCase("create")) {
            if(command.length < 2) {
                channel.sendMessage("Invalid arguments. Usage: `" + prefix + "create name`");
            }
            createCommand(channel,args);
        } else {channel.sendMessage("Invalid command.");}
    }

    public void createCommand(IChannel channel, String[] args){
        Lyokowarrior LW = new Lyokowarrior(args[0], LYOKOCLASS.SAMURAI);
        channel.sendMessage(LW.getUsername() + " has been created.\nLevel: " + LW.getLevel() + " (" + LW.getXp() + " XP)");
        channel.sendMessage("Attacks: TO BE PRINT");
        LW.addXP(1500);
        channel.sendMessage("1500 XP added.");
        channel.sendMessage(LW.getUsername() + "\nLevel: " + LW.getLevel() + " (" + LW.getXp() + " XP)");
    }
}

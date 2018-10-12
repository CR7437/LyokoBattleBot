package Discord;

import Application.Commands.Ping;
import Domain.Enums.LYOKOCLASS;
import Domain.Lyokowarrior;
import sx.blah.discord.handle.impl.obj.User;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OnCommand {
    private static final long TIMEOUT_SECONDS = 10;
    private Map<User,LocalDate> usages;
    CommandList commandList;
    public OnCommand(){
        usages = new HashMap<>();
        commandList = new CommandList();
        commandList.addCommand(new Ping());
    }

    public void processCommand(IMessage message, String prefix){
        IUser sender = message.getAuthor();
        IChannel channel = message.getChannel();
        IGuild guild = message.getGuild();

        String[] command = message.getContent().replaceFirst(prefix, "").split(" ");
        String commandName = command[0];
        String[] args = Arrays.copyOfRange(command, 1, command.length);

        if (commandList.hasCommand(commandName)){
            commandList.getCommand(commandName).run(message,args);
        }else {
            channel.sendMessage("Invalid command!");
        }
       /* if(commandName.equalsIgnoreCase("hello")) {
            channel.sendMessage("Hai!");
        } else if(commandName.equalsIgnoreCase("create")) {
            if(command.length < 2) {
                channel.sendMessage("Invalid arguments. Usage: `" + prefix + "create name`");
            }
            createCommand(channel,args);
        } else {channel.sendMessage("Invalid command.");}*/
    }

    public void createCommand(IChannel channel, String[] args){
        Lyokowarrior LW = new Lyokowarrior(args[0], LYOKOCLASS.SAMURAI);
        channel.sendMessage(LW.getUsername() + " has been created.\nLevel: " + LW.getLevel() + " (" + LW.getXp() + " XP)");
        channel.sendMessage("Attacks: TO BE PRINT");
        LW.addXP(1500);
        channel.sendMessage("1500 XP added.");
        channel.sendMessage(LW.getUsername() + "\nLevel: " + LW.getLevel() + " (" + LW.getXp() + " XP)");
    }

    public boolean isTimedOut(User user){
        if (usages.containsKey(user)){
            LocalDate lastUsage = usages.get(user);
            Duration period = Duration.between(lastUsage,LocalDate.now());
            if (period.getSeconds() > TIMEOUT_SECONDS){
                usages.remove(user);
                return false;
            }else {
                return true;
            }
        }
        return false;
    }
    public long getTimeOut(User user){
        if(isTimedOut(user)){
            LocalDate lastUsage = usages.get(user);
            long secondsBetween = Duration.between(lastUsage, LocalDate.now()).getSeconds();
            return TIMEOUT_SECONDS - secondsBetween;
        }else {
            return 0;
        }
    }
}

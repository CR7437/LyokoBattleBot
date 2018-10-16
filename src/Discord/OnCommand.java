package Discord;

import Application.Commands.Create;
import Application.Commands.Delete;
import Application.Commands.Ping;
import Application.Commands.Stats;
import Application.Main;
import Domain.Enums.LYOKOCLASS;
import Domain.Lyokowarrior;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OnCommand {
    private static final long TIMEOUT_SECONDS = 1;
    private Map<IUser,LocalDateTime> usages;
    private CommandList commandList;
    private String prefix;
    public OnCommand(){
        usages = new HashMap<>();
        commandList = new CommandList();
        commandList.addCommand(new Ping());
        commandList.addCommand(new Create());
        commandList.addCommand(new Delete());
        commandList.addCommand(new Stats());
        prefix = Main.prefix;
    }

    public void processCommand(IMessage message){
        IUser sender = message.getAuthor();
        IChannel channel = message.getChannel();
        IGuild guild = message.getGuild();

        String[] command = message.getContent().replaceFirst(prefix, "").split(" ");
        String commandName = command[0];
        String[] args = Arrays.copyOfRange(command, 1, command.length);

        if (commandList.hasCommand(commandName)){
            if (isTimedOut(sender)){
                channel.sendMessage(String.format("Slow down, %s (%ds)",sender.getName()+"#"+sender.getDiscriminator(),getTimeOut(sender)));
            }else {
                commandList.getCommand(commandName).run(message,args);
                usages.put(sender,LocalDateTime.now());
            }
        }else {
            channel.sendMessage("Invalid command!");
        }
    }

    public boolean isTimedOut(IUser user){
        if (usages.containsKey(user)){
            LocalDateTime lastUsage = usages.get(user);
            Duration period = Duration.between(lastUsage,LocalDateTime.now());
            if (period.getSeconds() > TIMEOUT_SECONDS){
                usages.remove(user);
                return false;
            }else {
                return true;
            }
        }
        return false;
    }
    public long getTimeOut(IUser user){
        if(isTimedOut(user)){
            LocalDateTime lastUsage = usages.get(user);
            long secondsBetween = Duration.between(lastUsage, LocalDateTime.now()).getSeconds();
            return TIMEOUT_SECONDS - secondsBetween;
        }else {
            return 0;
        }
    }
}

package Application.Commands;

import Application.Exceptions.CommandException;
import Application.Main;
import sx.blah.discord.handle.obj.IMessage;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by jack on 10/13/18.
 */
public class Ping extends LyokoCommand {
    private List<String> replies = Arrays.asList("Aelita, you've activated my tower!","I don't want to talk about it.","Elisabeth, I am very dissapointed in you!");
    public Ping() {
        super("ping");
        setHelpMessage("Shows you how shit your internet really is");
        setUsage(String.format("%sping", Main.prefix));
    }

    @Override
    protected void doCommand(IMessage message, String[] args) throws CommandException {
        checkArgs(message,args,0,0);
        int selection = new Random().nextInt(replies.size());
        LocalDateTime sentTime = LocalDateTime.ofInstant(message.getCreationDate(), ZoneId.systemDefault());
        IMessage probe = message.getChannel().sendMessage(replies.get(selection));
        LocalDateTime repliedTime = LocalDateTime.ofInstant(probe.getTimestamp(),ZoneId.systemDefault());
        long ping = Duration.between(sentTime,repliedTime).toMillis();
        probe.edit(String.format("Pong! %s (%d ms)",message.getAuthor().mention(),ping));
    }
}

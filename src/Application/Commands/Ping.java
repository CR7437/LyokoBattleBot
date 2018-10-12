package Application.Commands;

import Application.Exceptions.CommandException;
import sx.blah.discord.handle.obj.IMessage;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by jack on 10/13/18.
 */
public class Ping extends LyokoCommand {
    private List<String> replies = Arrays.asList("Aelita, you've activated my tower!","I dont want to talk about it","Elisabeth, I am very dissapointed in you!");
    public Ping() {
        super("Ping");
        setHelpMessage("Shows you how shit your internet really is");
    }

    @Override
    protected void doCommand(IMessage message, String[] args) throws CommandException {
        int selection = new Random().nextInt(replies.size());
        LocalDateTime sentTime = LocalDateTime.from(message.getTimestamp());
        IMessage probe = message.getChannel().sendMessage(replies.get(selection));
        LocalDateTime repliedTime = LocalDateTime.from(probe.getTimestamp());
        long ping = Duration.between(sentTime,repliedTime).toMillis();
        probe.edit(String.format("Pong! %s (%d ms)",message.getAuthor().mention(),ping));
    }
}

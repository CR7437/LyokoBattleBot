package Application.Exceptions;

import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;

/**
 * Created by jack on 10/13/18.
 */
public class InvalidCommandException extends CommandException {

    public InvalidCommandException(IChannel channel, IUser user, String errorMessage) {
        super(channel, user, String.format("**Invalid syntax!**\nUse: %s",errorMessage));
    }

    public InvalidCommandException(IMessage message, String errorMessage) {
        super(message, String.format("**Invalid syntax!**\nUse: %s",errorMessage));
    }
}

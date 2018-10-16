package Application.Exceptions;

import Domain.Enums.LYOKOCLASS;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;

/**
 * Created by Kaz on 16/10/2018
 */
public class InvalidClassException extends CommandException {

    public InvalidClassException(IChannel channel, IUser user, String invalidClass) {
        super(channel, user, String.format("**%s isn't a valid class!**\n__Valid Classes__: `%s`",invalidClass, LYOKOCLASS.getStringClasses()));
    }

    public InvalidClassException(IMessage message, String invalidClass) {
        super(message, String.format("**%s isn't a valid class!**\n__Valid Classes__: `%s`",invalidClass, LYOKOCLASS.getStringClasses()));
    }
}

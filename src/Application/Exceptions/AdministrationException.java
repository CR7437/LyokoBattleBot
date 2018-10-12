package Application.Exceptions;

import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IUser;

/**
 * Created by jack on 10/13/18.
 */
public class AdministrationException extends CommandException {
    private IUser owner;
    public AdministrationException(IChannel channel, String errorMessage) {
        super(channel, channel.getGuild().getOwner(),String.format("%s! You made a mistake: %s",channel.getGuild().getOwner().mention(),errorMessage));
    }
}

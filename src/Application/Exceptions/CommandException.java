package Application.Exceptions;

import Domain.Exceptions.LyokoExceptionI;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IUser;

/**
 * Created by jack on 10/13/18.
 */
public class CommandException implements LyokoExceptionI {
    private final String errorMessage;
    private final IUser user;
    private final IChannel channel;
    public CommandException(IChannel channel, IUser user, String errorMessage){
        this.user = user;
        this.errorMessage = errorMessage;
        this.channel = channel;
    }


    @Override
    public String getErrorMessage() {
        return String.format("%s : %s",user.getName(),errorMessage);
    }

    @Override
    public void resolve() {
        channel.sendMessage(getErrorMessage());
    }

    public IUser getUser() {
        return user;
    }

    public IChannel getChannel() {
        return channel;
    }
}

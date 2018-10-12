package Application.Exceptions;

import sx.blah.discord.handle.impl.obj.Role;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;

/**
 * Created by jack on 10/13/18.
 */
public class NoPermissionException extends CommandException {
    private final String roleName;
    public NoPermissionException(IChannel channel, IUser user, String rolename) {
        super(channel, user, String.format("You need to have the %s role to perform this command",rolename));
        this.roleName = rolename;
    }
    public NoPermissionException(IChannel channel, IUser user, Role requiredRole){
        this(channel,user,requiredRole.getName());
    }
    public NoPermissionException(IMessage message, String roleName){
        this(message.getChannel(),message.getAuthor(),roleName);
    }

    public String getRoleName() {
        return roleName;
    }
}

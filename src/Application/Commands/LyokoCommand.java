package Application.Commands;

import Application.Exceptions.AdministrationException;
import Application.Exceptions.CommandException;
import Application.Exceptions.NoPermissionException;
import sx.blah.discord.handle.impl.obj.Role;
import sx.blah.discord.handle.impl.obj.User;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IRole;
import sx.blah.discord.handle.obj.IUser;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;

/**
 * Created by jack on 10/12/18.
 */
public abstract class LyokoCommand {
    private String name;
    private List<String> aliasses;
    private String requiredRoleName;
    private String helpMessage;

    public LyokoCommand(String name){
        aliasses = new ArrayList<>();
        helpMessage = "N/A";
        requiredRoleName = "@everyone";
        this.name = name;
    }

    public final void run(IMessage message, String[] args){
        try {
            checkRole(message);
            doCommand(message,args);
        }catch (CommandException e){
            e.resolve();
        }
    }
    protected abstract void doCommand(IMessage message, String[] args) throws CommandException;

    public String getRequiredRoleName() {
        return requiredRoleName;
    }
    public IRole getRequiredRole(IMessage message) throws AdministrationException {
        List<IRole> roles = message.getGuild().getRolesByName(requiredRoleName);
        if (roles.size() > 1) {
            throw new AdministrationException(message.getChannel(), "There are multiple roles named: " + requiredRoleName);
        }
        if (roles.isEmpty()){
            throw new AdministrationException(message.getChannel(),"There are no roles named: "+requiredRoleName);
        }
        return roles.get(0);
    }
    public void checkRole(IMessage message) throws AdministrationException, NoPermissionException {
        if (!message.getAuthor().hasRole(getRequiredRole(message))){
            throw new NoPermissionException(message,requiredRoleName);
        }
    }

    public List<String> getAliasses() {
        return aliasses;
    }

    public String getName() {
        return name;
    }

    protected void setRequiredRole(String requiredRole) {
        this.requiredRoleName = requiredRole;
    }

    public String getHelpMessage() {
        return helpMessage;
    }

    protected void setHelpMessage(String helpMessage) {
        this.helpMessage = helpMessage;
    }
    protected void addAlias(String alias){
        if (!aliasses.contains(alias)){
            aliasses.add(alias);
        }
    }

}

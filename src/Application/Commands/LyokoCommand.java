package Application.Commands;

import sx.blah.discord.handle.impl.obj.User;

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
    private String requiredRole;
    private String helpMessage;

    public LyokoCommand(String name){
        aliasses = new ArrayList<>();
        helpMessage = "N/A";
        requiredRole = "@Everyone";

        this.name = name;
    }

    public String getRequiredRole() {
        return requiredRole;
    }

    public List<String> getAliasses() {
        return aliasses;
    }

    public String getName() {
        return name;
    }

    public void setRequiredRole(String requiredRole) {
        this.requiredRole = requiredRole;
    }

    public String getHelpMessage() {
        return helpMessage;
    }

    public void setHelpMessage(String helpMessage) {
        this.helpMessage = helpMessage;
    }
    public void addAlias(String alias){
        if (!aliasses.contains(alias)){
            aliasses.add(alias);
        }
    }

}

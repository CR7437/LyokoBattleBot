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
    private static final long TIMEOUT_SECONDS = 10;
    private String name;
    private List<String> aliasses;
    private String requiredRole;
    private String helpMessage;
    private Map<User,LocalDate> usages;
    public LyokoCommand(String name){
        aliasses = new ArrayList<>();
        helpMessage = "N/A";
        requiredRole = "@Everyone";
        usages = new HashMap<>();
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
    public boolean isTimedOut(User user){
        if (usages.containsKey(user)){
            LocalDate lastUsage = usages.get(user);
            Duration period = Duration.between(lastUsage,LocalDate.now());
            if (period.getSeconds() > TIMEOUT_SECONDS){
                usages.remove(user);
                return false;
            }else {
                return true;
            }
        }
        return false;
    }
    public long getTimeOut(User user){
        if(isTimedOut(user)){
            LocalDate lastUsage = usages.get(user);
            long secondsBetween = Duration.between(lastUsage, LocalDate.now()).getSeconds();
            return TIMEOUT_SECONDS - secondsBetween;
        }else {
            return 0;
        }
    }
}

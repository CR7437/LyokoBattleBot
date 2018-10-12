package Discord;

import Application.Commands.LyokoCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 10/13/18.
 */
public class CommandList {
    List<LyokoCommand> commandList;
    public CommandList(){
        commandList = new ArrayList<>();
    }
    public void addCommand(LyokoCommand command){
        if (!commandList.contains(command)){
            commandList.add(command);
        }
    }
    public boolean hasCommand(String command){
        for (LyokoCommand foundcommand: commandList) {
            if (foundcommand.getName().equalsIgnoreCase(command) || foundcommand.getAliasses().contains(command)){
                return true;
            }
        }
        return false;
    }
    public LyokoCommand getCommand(String command){
        if (hasCommand(command)){
            for (LyokoCommand foundcommand: commandList) {
                if (foundcommand.getName().equalsIgnoreCase(command)||foundcommand.getAliasses().contains(command)){
                    return foundcommand;
                }
            }
        }
        return null;

    }
}

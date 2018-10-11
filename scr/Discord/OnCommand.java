package Discord;

import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;

public class OnCommand {
    public void processCommand(IMessage message, String prefix){
        IUser sender = message.getAuthor();
        IChannel channel = message.getChannel();
        IGuild guild = message.getGuild();

        String[] command = message.getContent().toLowerCase().replaceFirst(prefix, "").split(" ");
        String[] command2 = message.getContent().replaceFirst(prefix, "").split(" "); //no lowercase

        if(command[0].equals("hello")) {
            channel.sendMessage("Hai!");
        } else if(command[0].equals("health")) {
            channel.sendMessage("kys");
        }
    }
}

package Discord;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

public class MessageListener {

    public MessageListener(){

    }
    public String prefix = new String(".");
    OnCommand useCommand = new OnCommand();

    @EventSubscriber
    public void onMessageEvent(MessageReceivedEvent event){
        if(event.getMessage().getContent().toLowerCase().startsWith(prefix)) {
            useCommand.processCommand(event.getMessage(),prefix);
        }
    }
}

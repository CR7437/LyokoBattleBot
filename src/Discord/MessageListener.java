package Discord;

import Application.Main;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

public class MessageListener {

    public MessageListener(){

    }

    OnCommand useCommand = new OnCommand();

    @EventSubscriber
    public void onMessageEvent(MessageReceivedEvent event){
        if(event.getMessage().getContent().toLowerCase().startsWith(Main.prefix)) {
            useCommand.processCommand(event.getMessage());
        }
    }
}

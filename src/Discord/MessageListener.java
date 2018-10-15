package Discord;

import Application.Main;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

public class MessageListener {
    private OnCommand commandProcessor; //interface might be cleaner but eh
    public MessageListener(){
        commandProcessor = new OnCommand();
    }

    @EventSubscriber
    public void onMessageEvent(MessageReceivedEvent event){
        if(event.getMessage().getContent().toLowerCase().startsWith(Main.prefix)) {
            commandProcessor.processCommand(event.getMessage());
        }
    }
}

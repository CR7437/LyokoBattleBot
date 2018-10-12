package Application;

import Discord.BotBuilder;
import Discord.MessageListener;
import sx.blah.discord.api.IDiscordClient;

public class Main {

    public static void main(String args[]){
            IDiscordClient bot = BotBuilder.getBot("tokenhere");
            bot.getDispatcher().registerListener(new MessageListener());
            bot.login();
        System.out.println("The bot is starting...");
    }
}

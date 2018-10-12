package Application;

import Discord.BotBuilder;
import Discord.Config;
import Discord.MessageListener;
import sx.blah.discord.api.IDiscordClient;

public class Main {
    public static IDiscordClient LBB;
    public static Config config;
    public static void main(String args[]){
            config = new Config();
            IDiscordClient bot = BotBuilder.getBot();
            bot.getDispatcher().registerListener(new MessageListener());
            bot.login();
        System.out.println("The bot is starting...");
    }
}

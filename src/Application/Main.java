package Application;

import Discord.Config;
import Discord.MessageListener;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;

public class Main {
    public static IDiscordClient LBB;
    public static Config config;
    public static String prefix;
    public static void main(String args[]){
            config = new Config();
            prefix = config.getPREFIX();
            IDiscordClient bot = new ClientBuilder().withToken(config.getTOKEN()).build();
            bot.getDispatcher().registerListener(new MessageListener());
            bot.login();
            LBB = bot;
        System.out.println("The bot is starting...");
    }
}

package Application;

import Database.fakedb;
import Discord.Config;
import Discord.MessageListener;
import Domain.DatabaseInterface;
import Domain.ILyokoWarriorManager;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;

public class Main {
    public static IDiscordClient LBB;
    public static Config config;
    public static String prefix;
    private static ILyokoWarriorManager lwManager;
    private static DatabaseInterface database;
    public static void main(String args[]){
            config = new Config();
            prefix = config.getPREFIX();
            IDiscordClient bot = new ClientBuilder().withToken(config.getTOKEN()).build();
            bot.getDispatcher().registerListener(new MessageListener());
            bot.login();
            LBB = bot;
            database = new fakedb();
            lwManager = new LyokoWarriorManager(database);
        System.out.println("The bot is starting...");
    }

    public static ILyokoWarriorManager getLwManager() {return lwManager;}
    public static DatabaseInterface getDatabase() {return database;}
}

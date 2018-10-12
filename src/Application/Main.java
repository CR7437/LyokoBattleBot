package Application;

import Discord.MessageListener;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.util.DiscordException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String args[]){
        try{
            File tokenfile = new File("./src/Application/token.txt");
            System.out.println(tokenfile);
            Scanner token = new Scanner(tokenfile);
            IDiscordClient bot = BotBuilder.getBot(token.nextLine());
            bot.getDispatcher().registerListener(new MessageListener());
            bot.login();
        }catch (FileNotFoundException k){
            k.printStackTrace();
            return;
        }
        System.out.println("The bot is starting...");
    }

    public static IDiscordClient createClient(String token, boolean login)
    {
        ClientBuilder clientBuilder = new ClientBuilder();
        clientBuilder.withToken(token);
        try
        {
            if (login)
            {
                return clientBuilder.login();
            }
            else
            {
                return clientBuilder.build();
            }
        }
        catch (DiscordException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}

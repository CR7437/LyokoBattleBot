import Discord.MessageListener;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.util.DiscordException;
public class Main {
    public static final IDiscordClient bot = createClient("NDk0NjIxNjcxMDYwMjc1MjAx.Do2L3w.HfLSCUrGu5eoP38FmiaafF37m5s", true);

    public static void main(String args[]){
        EventDispatcher dis = bot.getDispatcher();
        dis.registerListener(new MessageListener());
        System.out.println("The bot is online, you did something right!");
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

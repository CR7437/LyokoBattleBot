package Discord;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;

public class BotBuilder {
    public static String prefix = ".";
    public static IDiscordClient getBot(String token) {
        return new ClientBuilder().withToken(token).build();
    }
}

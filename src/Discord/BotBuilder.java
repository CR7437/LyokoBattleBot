package Discord;

import Application.Main;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;

public class BotBuilder {
    public static String prefix = ".";
    public static IDiscordClient getBot() {
        return new ClientBuilder().withToken(Main.config.getTOKEN()).build();
    }
}

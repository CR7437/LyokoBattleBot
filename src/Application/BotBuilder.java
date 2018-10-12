package Application;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;

class BotBuilder {
    static String prefix = ".";
    static IDiscordClient getBot(String token) {
        return new ClientBuilder().withToken(token).build();
    }
}

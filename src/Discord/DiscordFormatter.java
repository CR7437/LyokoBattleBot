package Discord;

import Application.Main;
import Domain.Lyokowarrior;

public class DiscordFormatter {

    public static String getName(Lyokowarrior lyokowarrior) { return Main.LBB.getUserByID(lyokowarrior.getId()).getName(); }
}

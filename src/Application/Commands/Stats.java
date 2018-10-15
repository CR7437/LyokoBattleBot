package Application.Commands;

import Application.Exceptions.CommandException;
import Application.Main;
import Discord.DiscordFormatter;
import Domain.Enums.ATTACKS;
import Domain.Enums.LYOKOCLASS;
import Domain.Lyokowarrior;
import sx.blah.discord.handle.obj.IMessage;

import java.util.List;

public class Stats extends LyokoCommand {

    public Stats() {
        super("stats");
        setHelpMessage("Shows your LW's stats.");
        setUsage(String.format("%sstats", Main.prefix));
    }

    @Override
    protected void doCommand(IMessage message, String[] args) throws CommandException {
        checkArgs(message,args,0,0);
        if(Main.getLwManager().hasWarrior(message.getAuthor().getLongID())) {
            Lyokowarrior lw = Main.getLwManager().getLyokoWarrior(message.getAuthor().getLongID());
            message.getChannel().sendMessage("__**" + DiscordFormatter.getName(lw).toUpperCase() + " STATS:**__" +
                    "\n   **-Class:** " + lw.getLyokoclass().toString() +
                    "\n   **-Level:** " + lw.getLevel() +
                    "\n   **-XP:** " + lw.getXp() +
                    "\n   **-Attacks:** " + getFormattedAttacks(lw.getAttacks()));
        } else {
            message.getChannel().sendMessage(message.getAuthor() + ", you don't have a LyokoWarrior!");
        }
    }

    public String getFormattedAttacks(List<ATTACKS> list) {
        StringBuilder builder = new StringBuilder();
        for(ATTACKS attacks : list) {
            String attack = "\n       **-> __" + attacks.getName() + ":__**  Level **" + attacks.getLevel() + "** / Damage **" + attacks.getDamage() + "**";
            builder.append(attack);
        }
        return builder.toString();
    }
}

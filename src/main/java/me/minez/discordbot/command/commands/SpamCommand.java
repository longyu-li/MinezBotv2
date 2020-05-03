package me.minez.discordbot.command.commands;

import me.minez.discordbot.Config;
import me.minez.discordbot.command.CommandContext;
import me.minez.discordbot.command.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;

public class SpamCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();
        try {
            if (args.size() < 2) {
                EmbedBuilder error = new EmbedBuilder();
                error.setColor(0xff0a0a);
                error.setTitle("Specify a valid message to spam");
                error.setDescription("Format is: " + Config.get("PREFIX") + "spam [# of times between 1-20] [message]");
                channel.sendMessage(error.build()).queue();
                error.clear();

            }
            else {
                int numTimes = Integer.parseInt(args.get(0));
                if (numTimes <= 20 && numTimes >= 1) {
                    int count = 0;
                    String toSend = args.get(1);
                    for(int i = 2; i < args.size(); i++) {
                        toSend = toSend + " " + args.get(i);
                    }
                    while (count < numTimes) {
                        channel.sendMessage(toSend).queue();
                        count++;
                    }
                }
                else {
                    throw new IllegalArgumentException("Invalid Format!");
                }
            }
        }
        catch (Exception e){
            EmbedBuilder error = new EmbedBuilder();
            error.setColor(0xff0a0a);
            error.setTitle("Invalid format!");
            error.setDescription("Format is: " + Config.get("PREFIX") + "spam [# of times between 1-20] [message]");
            channel.sendMessage(error.build()).queue();
            error.clear();
        }
    }

    @Override
    public String getName() {
        return "spam";
    }

    @Override
    public String getHelp() {
        return "Spams a provided message a target number of times";
    }
}

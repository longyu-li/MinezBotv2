package me.minez.discordbot.command.commands;

import me.minez.discordbot.command.CommandContext;
import me.minez.discordbot.command.ICommand;
import net.dv8tion.jda.api.JDA;

public class PingCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        JDA jda = ctx.getJDA();

        jda.getRestPing().queue((ping) -> ctx.getChannel().sendMessageFormat("Reset ping: %sms\nWS ping: %sms", ping, jda.getGatewayPing()).queue());

    }

    public String getHelp() {
        return "Shows the current ping from the bot to the discord servers";
    }

    @Override
    public String getName() {
        return "ping";
    }
}

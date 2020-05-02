package me.minez.discordbot.command.commands;

import me.minez.discordbot.command.CommandContext;
import me.minez.discordbot.command.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;

public class InfoCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        TextChannel channel = ctx.getChannel();
        EmbedBuilder info = new EmbedBuilder();
        info.setTitle("MinezBot Information");
        info.setDescription("This is a work in progress Bot by MinezGamez for mostly test purposes.");
        info.addField("Creator", "MinezGamez", false);
        info.setColor(0x2b7cff);
        info.setFooter("Called by: " + ctx.getAuthor().getAsTag(), ctx.getAuthor().getAvatarUrl());

        channel.sendMessage(info.build()).queue();
        info.clear();
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getHelp() {
        return "A description about the bot";
    }
}

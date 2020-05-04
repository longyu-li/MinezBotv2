package me.minez.discordbot.command.commands.Reddit;

import me.minez.discordbot.command.CommandContext;
import me.minez.discordbot.command.ICommand;

public class MeirlCommand extends RedditImageTemplate implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        super.handle("meirl", ctx);
    }

    @Override
    public String getName() {
        return "meirl";
    }

    @Override
    public String getHelp() {
        return "Posts a random recently popular meirl meme";
    }
}

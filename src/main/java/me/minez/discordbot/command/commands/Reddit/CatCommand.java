package me.minez.discordbot.command.commands.Reddit;

import me.minez.discordbot.command.CommandContext;
import me.minez.discordbot.command.ICommand;

public class CatCommand extends RedditImageTemplate implements ICommand {

    @Override
    public void handle(CommandContext ctx) {
        super.handle("cat", ctx);
    }

    @Override
    public String getName() {
        return "cat";
    }

    @Override
    public String getHelp() {
        return "Posts a random recently popular cute cat.";
    }
}

package me.minez.discordbot.command.commands.Reddit;

import me.minez.discordbot.command.CommandContext;
import me.minez.discordbot.command.ICommand;

public class AwwCommand extends RedditImageTemplate implements ICommand {

    @Override
    public void handle(CommandContext ctx) {
        super.handle("aww", ctx);
    }

    @Override
    public String getName() {
        return "aww";
    }

    @Override
    public String getHelp() {
        return "Posts a random recently popular cute animal.";
    }
}

package me.minez.discordbot.command.commands.Reddit;

import me.minez.discordbot.command.CommandContext;
import me.minez.discordbot.command.ICommand;

import java.util.Arrays;
import java.util.List;

public class AnimemeCommand extends RedditImageTemplate implements ICommand {

    @Override
    public void handle(CommandContext ctx) {
        super.handle("animemes", ctx);
    }

    @Override
    public String getName() {
        return "animeme";
    }

    @Override
    public String getHelp() {
        return "Posts a random recently popular animeme.";
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("animemes", "animememes", "animememe");
    }
}

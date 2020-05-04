package me.minez.discordbot.command.commands.Reddit;

import me.minez.discordbot.command.CommandContext;
import me.minez.discordbot.command.ICommand;

import java.util.Arrays;
import java.util.List;

public class HistoryMemeCommand extends RedditImageTemplate implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        super.handle("HistoryMemes", ctx);
    }

    @Override
    public String getName() {
        return "historymeme";
    }

    @Override
    public String getHelp() {
        return "Posts a random recently popular history meme";
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("hmeme", "hmemes", "historymemes");
    }
}

